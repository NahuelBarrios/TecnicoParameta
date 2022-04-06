package com.examen.repository;

import com.examen.repository.models.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel,Long> {
}
