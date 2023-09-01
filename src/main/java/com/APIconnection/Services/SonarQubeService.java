package com.APIconnection.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SonarQubeService {
	
	
	 private final RestTemplate restTemplate;
	    private final String sonarQubeUrl;
	    private final String sonarQubeToken;

	    @Autowired
	    public SonarQubeService(
	            RestTemplate restTemplate,
	            @Value("${sonarqube.url}") String sonarQubeUrl,
	            @Value("${sonarqube.token}") String sonarQubeToken) {
	        this.restTemplate = restTemplate;
	        this.sonarQubeUrl = sonarQubeUrl;
	        this.sonarQubeToken = sonarQubeToken;
	    }

	    public ResponseEntity<String> getSonarQubeData(String endpoint) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "Bearer " + sonarQubeToken);

	        HttpEntity<String> entity = new HttpEntity<>(headers);

	        String apiUrl = sonarQubeUrl + endpoint;
	        return restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
	    }

}
