package com.week2.work.week2work.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.week2.work.week2work.DepartmentEntity.DepartmentEntity;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long>{

}
 
