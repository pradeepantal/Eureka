package com.digi.dfs.controller;

import java.util.Collection;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digi.dfs.model.Contact;
import com.digi.dfs.services.UserServiceConfiguration;

@RefreshScope
@RestController
@RequestMapping("/rest")
@RibbonClient(name = "user-service", configuration = UserServiceConfiguration.class)
public class TransactionRestController {

	

	@Autowired
	RestTemplate restTemplate;

	@Value("${message}")
	private String message;

	@Autowired
	public TransactionRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/{userId}/contacts")
	public Collection<Contact> getContactsByUserId() {
		ParameterizedTypeReference<List<Contact>> responseType = new ParameterizedTypeReference<List<Contact>>() {
		};
		ResponseEntity<List<Contact>> exchange = this.restTemplate.exchange(
				"http://user-service/user/{userId}/contacts", HttpMethod.GET, null, responseType, (Object) "1");
		exchange.getBody().forEach(System.out::println);
		return exchange.getBody();
	}

	@RequestMapping("/message")
	public String getMessage() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http:/user-service/user/message", String.class);
		return response.getBody();
	}
}
