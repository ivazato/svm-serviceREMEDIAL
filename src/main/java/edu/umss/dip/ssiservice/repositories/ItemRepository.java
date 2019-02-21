/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.repositories;

import edu.umss.dip.ssiservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
  