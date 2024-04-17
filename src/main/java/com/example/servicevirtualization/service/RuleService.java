package com.example.servicevirtualization.service;

import com.example.servicevirtualization.dto.RuleDTO;
import com.example.servicevirtualization.entity.Rule;
import com.example.servicevirtualization.repository.RuleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RuleService {
    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public RuleDTO createRule(RuleDTO ruleDTO) {
        Rule rule = modelMapper.map(ruleDTO, Rule.class);
        rule = ruleRepository.save(rule);
        return modelMapper.map(rule, RuleDTO.class);
    }

    @Transactional
    public RuleDTO updateRule(Long ruleId, RuleDTO ruleDTO) {
        Rule existingRule = ruleRepository.findById(ruleId)
                .orElseThrow(() -> new IllegalArgumentException("Rule not found"));

        // Update existingRule properties with those from ruleDTO
        existingRule.setName(ruleDTO.getName());
        existingRule.setDescription(ruleDTO.getDescription());

        // Save and return updated rule
        Rule updatedRule = ruleRepository.save(existingRule);
        return modelMapper.map(updatedRule, RuleDTO.class);
    }

    @Transactional(readOnly = true)
    public List<RuleDTO> getRulesByEndpoint(Long endpointId) {
        // Implement logic to fetch rules by endpointId from repository
        List<Rule> rules = ruleRepository.findByEndpointIdOrderByRuleOrderAsc(endpointId);
        return rules.stream()
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .collect(Collectors.toList());
    }
}
