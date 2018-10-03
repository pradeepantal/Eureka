package com.digi.dfs.services;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digi.dfs.model.Contact;

@FeignClient(name="user-service" )
public interface UserManagementProxy {
	@RequestMapping("/user/{userId}/contacts/")
	public Collection<Contact> findByUserId(@PathVariable(value="userId") int userId);
	
	@RequestMapping("/user/message")
	public String findMessage();


}
