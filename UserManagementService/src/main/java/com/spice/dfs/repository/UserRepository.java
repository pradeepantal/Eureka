package com.spice.dfs.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.digi.dfs.model.Contact;



public interface UserRepository extends JpaRepository<Contact, Long> {

	public Collection<Contact> findByUserId(String userId);
}
