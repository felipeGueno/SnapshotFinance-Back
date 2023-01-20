package com.guenodev.snapshotFinance.repository;

import com.guenodev.snapshotFinance.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    boolean existsByEmail(String email);

    Users findById(UUID uuid);


}
