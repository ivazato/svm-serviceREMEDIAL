/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.model.Item;

import java.io.InputStream;

public interface ItemService extends GenericService<Item> {
    void saveImage(Long id, InputStream file);
}

    