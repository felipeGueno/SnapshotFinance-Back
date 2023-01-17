package com.guenodev.snapshotFinance.repository;

import com.guenodev.snapshotFinance.entity.Group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository  extends CrudRepository<Group, Integer> {
}
