/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.model.Item;
import edu.umss.dip.ssiservice.repositories.GenericRepository;
import edu.umss.dip.ssiservice.repositories.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item> implements ItemService {
    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Item> getRepository() {
        return repository;
    }

    @Override
    public void saveImage(Long id, MultipartFile file) {
        Item item = findById(id);
        item.setImage(getBytes(file));
        save(item);
    }
}
