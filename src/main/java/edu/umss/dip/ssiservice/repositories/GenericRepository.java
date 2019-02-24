package edu.umss.dip.ssiservice.repositories;

import edu.umss.dip.ssiservice.model.ModelBase;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("rawtypes")
public interface GenericRepository<T extends ModelBase> extends JpaRepository<T, Long> {
}