/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.dto.CategoryDto;
import edu.umss.dip.ssiservice.model.Category;
import edu.umss.dip.ssiservice.service.CategoryService;
import edu.umss.dip.ssiservice.service.GenericService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController extends GenericController<Category, CategoryDto> {
    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @GetMapping
    public List<Category> getCategories(@RequestParam(value = "code", required = false) String code) {
        return StringUtils.isEmpty(code) ? service.findAll() : service.findByCode(code);
    }
}
