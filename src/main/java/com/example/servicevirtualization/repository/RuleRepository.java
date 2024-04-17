package com.example.servicevirtualization.repository;

import com.example.servicevirtualization.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
    List<Rule> findByEndpointIdOrderByRuleOrderAsc(Long endpointId);
}