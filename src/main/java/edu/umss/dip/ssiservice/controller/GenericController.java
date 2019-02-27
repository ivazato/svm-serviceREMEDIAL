package edu.umss.dip.ssiservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umss.dip.ssiservice.exception.InternalErrorException;
import edu.umss.dip.ssiservice.model.ModelBase;
import edu.umss.dip.ssiservice.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class GenericController<E extends ModelBase> {

    protected static final String ID = "id";

    @Autowired
    protected ObjectMapper objectMapper;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{id}")
    public E getById(@PathVariable("id") @NotNull Long id) {
        return (E) getService().findById(id);
    }

    public List<E> getAll() {
        return getService().findAll();
    }

    @PostMapping
    public E save(E element) {
        return (E) getService().save(element);
    }

    @PutMapping
    public E update(E element) {
        return (E) getService().save(element);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRequest(@PathVariable("id") @NotNull String id) {
        getService().deleteById(Long.valueOf(id));
    }

    protected abstract GenericService getService();

    private E getInstanceOfE() {
        Class<E> type = getDomainClass();
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new InternalErrorException("No default constructor.", e);
        }
    }

    private Class<E> getDomainClass() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) superClass.getActualTypeArguments()[0];
    }
}
