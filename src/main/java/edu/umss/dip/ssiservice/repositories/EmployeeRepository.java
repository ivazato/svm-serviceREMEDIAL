/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.repositories;

import edu.umss.dip.ssiservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
