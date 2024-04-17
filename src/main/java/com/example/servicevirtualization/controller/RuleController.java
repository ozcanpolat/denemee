package com.example.servicevirtualization.controller;

import com.example.servicevirtualization.dto.RuleDTO;
import com.example.servicevirtualization.service.RuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @PostMapping
    public ResponseEntity<RuleDTO> createRule(@Valid @RequestBody RuleDTO ruleDTO) {
        RuleDTO createdRule = ruleService.createRule(ruleDTO);
        return ResponseEntity.ok(createdRule);
    }

    @PutMapping("/{ruleId}")
    public ResponseEntity<RuleDTO> updateRule(@PathVariable Long ruleId, @Valid @RequestBody RuleDTO ruleDTO) {
        RuleDTO updatedRule = ruleService.updateRule(ruleId, ruleDTO);
        return ResponseEntity.ok(updatedRule);
    }

    @GetMapping("/endpoint/{endpointId}")
    public ResponseEntity<List<RuleDTO>> getRulesByEndpoint(@PathVariable Long endpointId) {
        List<RuleDTO> rules = ruleService.getRulesByEndpoint(endpointId);
        return ResponseEntity.ok(rules);
    }
}