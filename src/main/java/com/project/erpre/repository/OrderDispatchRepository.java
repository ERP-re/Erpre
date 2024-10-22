package com.project.erpre.repository;

import com.project.erpre.model.entity.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDispatchRepository extends JpaRepository<Dispatch, Integer> {

}
