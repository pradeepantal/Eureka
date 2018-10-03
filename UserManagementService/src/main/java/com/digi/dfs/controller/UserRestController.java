package com.digi.dfs.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digi.dfs.model.Contact;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Value("${message}")
	private String message;
	
	@Autowired
	DiscoveryClient client;
	
	
	@RequestMapping("/{userId}/contacts")
	public Collection<Contact> getContactsByUserId(@PathVariable String userId){
		return getHardCodedContacts();
	}
	
	private Collection<Contact> getHardCodedContacts() {
		Collection<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("A1", "FName", "LName", "dummy@email.com"));
		return contacts;
	}

	@RequestMapping("/message")
	public String getMessage(){
		ServiceInstance localInstance = client.getLocalServiceInstance();
		return this.message+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}
	
}
