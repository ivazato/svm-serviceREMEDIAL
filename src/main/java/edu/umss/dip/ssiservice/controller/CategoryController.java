/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.model.Category;
import edu.umss.dip.ssiservice.service.CategoryService;
import edu.umss.dip.ssiservice.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categories")
public class CategoryController extends GenericController<Category> {
    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @GetMapping
    public String getCategories(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute(getPlural(), StringUtils.isEmpty(code) ? service.findAll() : service.findByCode(code));
        return getPlural();
    }

    @Override
    protected String getSingular() {
        return "category";
    }

    @Override
    protected String getPlural() {
        return "categories";
    }
}
