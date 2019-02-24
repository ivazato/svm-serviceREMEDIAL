/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.repositories;

import edu.umss.dip.ssiservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends GenericRepository<Category> {
    Optional<List<Category>> findByCode(String code);
}
  