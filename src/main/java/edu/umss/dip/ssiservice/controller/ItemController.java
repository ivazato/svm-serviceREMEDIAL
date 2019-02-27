/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.model.Item;
import edu.umss.dip.ssiservice.model.SubCategory;
import edu.umss.dip.ssiservice.service.GenericService;
import edu.umss.dip.ssiservice.service.ItemService;
import edu.umss.dip.ssiservice.service.SubCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController extends GenericController<Item> {
    private ItemService service;
    private SubCategoryService subCategoryService;

    public ItemController(ItemService service, SubCategoryService subCategoryService) {
        this.service = service;
        this.subCategoryService = subCategoryService;
    }

    @Override
    public String newElement(Model model) {
        String view = super.newElement(model);
        Item newItem = (Item) model.asMap().get("item");
        newItem.setSubCategory(new SubCategory());
        model.addAttribute("subCategories", subCategoryService.findAll());
        return view;
    }

    @Override
    public String updateRequest(Model model, @PathVariable Long id) {
        String view = super.updateRequest(model, id);
        model.addAttribute("subCategories", subCategoryService.findAll());
        return view;
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
        return "item";
    }

    @Override
    protected String getPlural() {
        return "items";
    }
}
