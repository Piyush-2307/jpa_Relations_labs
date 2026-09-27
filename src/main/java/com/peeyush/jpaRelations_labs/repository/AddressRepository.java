package com.peeyush.jpaRelations_labs.repository;

import com.peeyush.jpaRelations_labs.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
