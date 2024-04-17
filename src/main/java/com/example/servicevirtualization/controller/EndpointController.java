package com.example.servicevirtualization.controller;

import com.example.servicevirtualization.dto.RuleDTO;
import com.example.servicevirtualization.service.EndpointService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/endpoints")
public class EndpointController {
    @Autowired
    private EndpointService endpointService;

    @PostMapping("/{endpointId}")
    public ResponseEntity<RuleDTO> addRuleToEndpoint(@PathVariable Long endpointId, @RequestBody @Valid RuleDTO ruleDTO) {
        RuleDTO createdRule = endpointService.addRuleToEndpoint(endpointId, ruleDTO);
        return ResponseEntity.ok(createdRule);
    }
}