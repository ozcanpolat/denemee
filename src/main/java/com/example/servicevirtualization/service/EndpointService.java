package com.example.servicevirtualization.service;

import com.example.servicevirtualization.dto.RuleDTO;
import com.example.servicevirtualization.entity.Endpoint;
import com.example.servicevirtualization.entity.Rule;
import com.example.servicevirtualization.repository.EndpointRepository;
import com.example.servicevirtualization.repository.RuleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EndpointService {
    @Autowired
    private EndpointRepository endpointRepository;
    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public RuleDTO addRuleToEndpoint(Long endpointId, RuleDTO ruleDTO) {
        Endpoint endpoint = endpointRepository.findById(endpointId)
                .orElseThrow(() -> new IllegalArgumentException("Endpoint not found"));
        Rule rule = modelMapper.map(ruleDTO, Rule.class);
        rule.setEndpoint(endpoint);
        rule = ruleRepository.save(rule);
        return modelMapper.map(rule, RuleDTO.class);
    }
}