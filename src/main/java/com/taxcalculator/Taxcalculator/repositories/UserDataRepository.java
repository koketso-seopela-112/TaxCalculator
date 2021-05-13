package com.taxcalculator.Taxcalculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxcalculator.Taxcalculator.entities.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {
 
}
