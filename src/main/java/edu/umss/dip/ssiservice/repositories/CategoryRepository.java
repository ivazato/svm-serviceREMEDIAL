/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.repositories;

import edu.umss.dip.ssiservice.model.Category;

import java.util.List;

public interface CategoryRepository extends GenericRepository<Category> {
    List<Category> findByCode(String code);
}
  