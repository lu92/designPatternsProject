package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.personalData.Privilege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 31.03.15.
 */


@Transactional
public interface PrivelegeRepository extends CrudRepository<Privilege, Long> {
}
