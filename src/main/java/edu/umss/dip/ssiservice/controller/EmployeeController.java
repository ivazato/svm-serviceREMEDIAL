/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.model.Employee;
import edu.umss.dip.ssiservice.service.EmployeeService;
import edu.umss.dip.ssiservice.service.GenericService;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController extends GenericController<Employee> {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @Override
    protected String getSingular() {
        return "employee";
    }

    @Override
    protected String getPlural() {
        return "employees";
    }
}
