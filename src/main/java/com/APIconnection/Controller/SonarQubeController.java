package com.APIconnection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.APIconnection.Services.SonarQubeService;

@RestController
@RequestMapping("/sonarqube")
public class SonarQubeController {
	
	
	  private final SonarQubeService sonarQubeService;

	    @Autowired
	    public SonarQubeController(SonarQubeService sonarQubeService) {
	        this.sonarQubeService = sonarQubeService;
	    }

	    @GetMapping("/data")
	    public ResponseEntity<String> getSonarQubeData(@RequestParam String endpoint) {
	        return sonarQubeService.getSonarQubeData(endpoint);
	    }

}
