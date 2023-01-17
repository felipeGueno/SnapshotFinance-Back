package com.guenodev.snapshotFinance.repository;

import com.guenodev.snapshotFinance.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    boolean existsByEmail(String email);


}
