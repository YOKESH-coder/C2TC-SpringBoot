package com.cg.asm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.asm.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{

}
