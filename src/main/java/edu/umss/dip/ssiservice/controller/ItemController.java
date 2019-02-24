/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.model.Item;
import edu.umss.dip.ssiservice.service.GenericService;
import edu.umss.dip.ssiservice.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController extends GenericController<Item> {
    private ItemService service;

    public ItemController(ItemService service) {
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
        return "item";
    }

    @Override
    protected String getPlural() {
        return "items";
    }
}
