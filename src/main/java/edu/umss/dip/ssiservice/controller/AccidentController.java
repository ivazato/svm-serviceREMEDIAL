/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.dto.AccidentDto;
import edu.umss.dip.ssiservice.model.Accident;
import edu.umss.dip.ssiservice.service.AccidentService;
import edu.umss.dip.ssiservice.service.EmployeeService;
import edu.umss.dip.ssiservice.service.GenericService;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("/accidents")
@Produces(MediaType.APPLICATION_JSON)
public class AccidentController extends GenericController<Accident, AccidentDto> {
    private AccidentService service;
    private EmployeeService employeeService;

    public AccidentController(AccidentService service, EmployeeService employeeService) {
        this.service = service;
        this.employeeService = employeeService;
    }

    @Override
    @GET
    public List<AccidentDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @Override
    protected Accident toModel(AccidentDto dto) {
        Accident accident = super.toModel(dto);
        // recuperamos a travez del servicio de empleado al modelo employee y lo fijamos al modelo de accident
        accident.setEmployee(employeeService.findById(dto.getEmployeeId()));
        return accident;
    }
}