package com.krokotiles.krokompany.repository;

import com.krokotiles.krokompany.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    List<EmployeeModel> findByName(String name);

    List<EmployeeModel> findByRole(String role);

    List<EmployeeModel> findByNameAndRole(String name, String role);

    Long countByName(String name);

    Long countByRole(String role);

    Long countByNameAndRole(String name, String role);
}
