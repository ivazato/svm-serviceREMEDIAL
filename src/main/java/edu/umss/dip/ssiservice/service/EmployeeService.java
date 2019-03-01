/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.model.Employee;

import java.io.InputStream;

public interface EmployeeService extends GenericService<Employee> {
    void saveImage(Long id, InputStream inputStream);
}

    