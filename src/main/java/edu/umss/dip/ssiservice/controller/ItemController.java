/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.controller;

import edu.umss.dip.ssiservice.exception.NotFoundException;
import edu.umss.dip.ssiservice.model.Item;
import edu.umss.dip.ssiservice.service.GenericService;
import edu.umss.dip.ssiservice.service.ItemService;
import edu.umss.dip.ssiservice.service.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController extends GenericController<Item> {
    private ItemService service;
    private SubCategoryService subCategoryService;

    public ItemController(ItemService service, SubCategoryService subCategoryService) {
        this.service = service;
        this.subCategoryService = subCategoryService;
    }

    @Override
    @GetMapping
    public List<Item> getAll() {
        return super.getAll();
    }


/*
    @GetMapping("/{id}/readimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        Item itemPersisted = service.findById(Long.valueOf(id));

        if (itemPersisted.getImage() != null) {
            byte[] byteArray = new byte[itemPersisted.getImage().length];
            int i = 0;

            for (Byte wrappedByte : itemPersisted.getImage()) {
                byteArray[i++] = wrappedByte;
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
*/

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

}
