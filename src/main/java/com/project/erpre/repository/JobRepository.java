package com.project.erpre.repository;

import com.project.erpre.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    // Job_id로 Job_role을 가져옴
    Optional<Job> findByJobId(Integer JobId);


}
