/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.dto;

import edu.umss.dip.ssiservice.model.Accident;
import org.modelmapper.ModelMapper;

import java.util.Date;

public class AccidentDto extends DtoBase<Accident> {
    private Long employeeId;
    private Date date;
    private String description;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public DtoBase toDto(Accident element, ModelMapper mapper) {
        super.toDto(element, mapper);
        setEmployeeId(element.getEmployee().getId());
        return this;
    }
}