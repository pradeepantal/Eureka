package com.digi.dfs.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.dfs.model.Contact;
import com.digi.dfs.services.UserManagementProxy;

@RefreshScope
@RestController
@RequestMapping("/transaction")
public class TransactionController {

	UserManagementProxy userManagementProxy;
	
	@Autowired
	public TransactionController(UserManagementProxy userManagementProxy) {
		this.userManagementProxy = userManagementProxy;
	}

	@RequestMapping("/{userId}/contacts")
	public Collection<Contact> getContactsByUserId(@PathVariable int userId) {
		return userManagementProxy.findByUserId(userId);
	}
	
	@RequestMapping("/{userId}/message")
	public String getMessage() {
		return userManagementProxy.findMessage();
	}

}

