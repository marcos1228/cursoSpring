package com.springcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

}
