/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.model.Item;
import org.springframework.web.multipart.MultipartFile;

public interface ItemService extends GenericService<Item> {
    void saveImage(Long id, MultipartFile file);
}

    