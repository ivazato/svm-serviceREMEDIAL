/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.exception.ValidationException;
import edu.umss.dip.ssiservice.model.ModelBase;
import edu.umss.dip.ssiservice.repositories.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@SuppressWarnings("rawtypes")
public abstract class GenericServiceImpl<T extends ModelBase> implements GenericService<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(Long id) {
        final T optional = getRepository().getOne(id);
        if (optional == null) {
            String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                    .getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf('.') + 1);
            throw new NoResultException(String.format("%s Not found with id %s", typeName, id));
        } else {
            return optional;
        }
    }

    @Override
    public T save(T model) {
        validateSave(model);
        try {
            return getRepository().save(model);
        } catch (EntityExistsException e) {
            throw new ValidationException("Error saving entity. The entity already exists!", e);

        } catch (IllegalArgumentException e) {
            throw new ValidationException("Error saving entity. You provided a ilegal argument.", e);
        } catch (Exception e) {
            throw new ValidationException("Error saving entity.", e);
        }

    }

    protected void validateSave(T model) {

    }

    @Override
    public List<T> saveAll(Iterable<T> models) {
        return StreamSupport.stream(models.spliterator(), false).map(this::save).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public Byte[] getBytes(MultipartFile file) {
        try {
            Byte[] bytes = new Byte[file.getBytes().length];
            int i = 0;
            for (Byte aByte : file.getBytes()) {
                bytes[i++] = aByte;
            }
            return bytes;
        } catch (IOException e) {
            logger.error("Error reading file", e);
        }
        return new Byte[0];
    }

    protected <E extends ModelBase> void appendModel(E model, Set<E> modelSet) {
        if (model != null) {
            modelSet.add(model);
        }
    }

    protected abstract GenericRepository<T> getRepository();
}
