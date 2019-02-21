/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.repositories;

import edu.umss.dip.ssiservice.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
  