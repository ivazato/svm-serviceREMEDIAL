/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.repositories;

import edu.umss.dip.ssiservice.model.Category;
import edu.umss.dip.ssiservice.model.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends GenericRepository<SubCategory> {
    Optional<List<Category>> findByCode(String code);
}
  