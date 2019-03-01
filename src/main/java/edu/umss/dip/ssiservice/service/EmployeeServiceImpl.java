/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.model.Employee;
import edu.umss.dip.ssiservice.repositories.EmployeeRepository;
import edu.umss.dip.ssiservice.repositories.GenericRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveImage(Long id, InputStream file) {
        Employee employeePersisted = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            employeePersisted.setImage(bytes);
            getRepository().save(employeePersisted);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }
    }

    @Override
    protected GenericRepository<Employee> getRepository() {
        return repository;
    }
}
