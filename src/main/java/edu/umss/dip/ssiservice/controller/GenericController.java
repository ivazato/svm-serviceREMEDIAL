package edu.umss.dip.ssiservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umss.dip.ssiservice.exception.InternalErrorException;
import edu.umss.dip.ssiservice.model.ModelBase;
import edu.umss.dip.ssiservice.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.reflect.ParameterizedType;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class GenericController<E extends ModelBase> {

    protected static final String ID = "id";
    private static final String FORM = "Form";
    private static final String PATH_SEPARATOR = "/";

    @Autowired
    protected ObjectMapper objectMapper;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    @RequestMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute(getSingular(), (getService().findById(id)));
        return getSingular();
    }

    public String getAll(Model model) {
        model.addAttribute(getPlural(), getService().findAll());
        return getPlural();
    }

    @RequestMapping("/new")
    public String newElement(Model model) {
        model.addAttribute(getSingular(), getInstanceOfE());
        return getSingular() + FORM;
    }

    @PostMapping
    public RedirectView save(Model model, E element) {
        E elementPersisted = (E) getService().save(element);
        model.addAttribute(getSingular(), elementPersisted);
        RedirectView redirectView =
                new RedirectView(PATH_SEPARATOR + getPlural() + PATH_SEPARATOR + elementPersisted.getId());
        redirectView.setHttp10Compatible(false);
        return redirectView;
    }

    @GetMapping("/update/{id}")
    public String updateRequest(Model model, @PathVariable String id) {
        model.addAttribute(getSingular(), getService().findById(Long.valueOf(id)));
        return getSingular() + FORM;
    }

    @RequestMapping(value = "/delete/{id}")
    public RedirectView deleteRequest(Model model, @PathVariable String id) {
        getService().deleteById(Long.valueOf(id));
        RedirectView redirectView = new RedirectView(PATH_SEPARATOR + getPlural());
        redirectView.setHttp10Compatible(false);
        return redirectView;
    }

    protected abstract GenericService getService();

    protected abstract String getSingular();

    protected abstract String getPlural();

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
