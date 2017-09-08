package com.rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.demo.domain.JobLogger;

public interface JobLoggerRepository extends JpaRepository<JobLogger, Long>{

}
