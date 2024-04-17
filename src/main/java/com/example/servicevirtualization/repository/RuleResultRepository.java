package com.example.servicevirtualization.repository;

import com.example.servicevirtualization.entity.RuleResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleResultRepository extends JpaRepository<RuleResult, Long> {
}
