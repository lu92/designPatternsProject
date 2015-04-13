package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.personalData.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 31.03.15.
 */

@Transactional
public interface AddressRepository extends CrudRepository<Address, Long> {
}
