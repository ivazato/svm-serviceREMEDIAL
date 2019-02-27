/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.dto.EmployeeDto;
import edu.umss.dip.ssiservice.model.Employee;
import edu.umss.dip.ssiservice.service.EmployeeService;
import edu.umss.dip.ssiservice.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends GenericController<Employee, EmployeeDto> {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<EmployeeDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }

}
