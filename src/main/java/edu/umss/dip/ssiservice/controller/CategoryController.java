/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.dto.CategoryDto;
import edu.umss.dip.ssiservice.model.Category;
import edu.umss.dip.ssiservice.service.CategoryService;
import edu.umss.dip.ssiservice.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryController extends GenericController<Category, CategoryDto> {
    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @GET
    public List<Category> getCategories(@QueryParam(value = "code") String code) {
        return StringUtils.isEmpty(code) ? service.findAll() : service.findByCode(code);
    }
}
