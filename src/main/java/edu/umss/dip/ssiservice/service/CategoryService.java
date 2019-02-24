/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.service;

import edu.umss.dip.ssiservice.model.Category;

import java.util.List;

public interface CategoryService extends GenericService<Category> {
    List<Category> findByCode(String code);
}

    