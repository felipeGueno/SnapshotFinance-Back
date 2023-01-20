package com.guenodev.snapshotFinance.repository;

import com.guenodev.snapshotFinance.entity.ExpenseGroup;


import com.guenodev.snapshotFinance.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface GroupRepository  extends CrudRepository<ExpenseGroup, Integer> {

     @Query("from ExpenseGroup where group_name =:groupName and userAdm =:id")
    ExpenseGroup existsByGroupNameAndUserAdmin(@Param("id") Users id, @Param("groupName") String groupName);





}
