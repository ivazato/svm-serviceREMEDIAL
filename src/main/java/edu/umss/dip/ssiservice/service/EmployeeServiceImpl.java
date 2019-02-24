/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.model.Employee;
import edu.umss.dip.ssiservice.repositories.EmployeeRepository;
import edu.umss.dip.ssiservice.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Employee> getRepository() {
        return repository;
    }
}
