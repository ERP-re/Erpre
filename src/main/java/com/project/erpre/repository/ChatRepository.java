package com.project.erpre.repository;

import com.project.erpre.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>, ChatRepositoryCustom, QuerydslPredicateExecutor<Chat> {

}
