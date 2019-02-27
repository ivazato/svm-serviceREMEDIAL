/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.model.Employee;
import edu.umss.dip.ssiservice.service.EmployeeService;
import edu.umss.dip.ssiservice.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController extends GenericController<Employee> {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public String getAll(Model model) {
        return super.getAll(model);
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
