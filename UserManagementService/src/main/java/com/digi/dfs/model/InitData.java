package com.digi.dfs.model;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.spice.dfs.repository.UserRepository;

@Component
public class InitData {

	/*@Bean
	CommandLineRunner init(UserRepository cr) {
		return args -> {
			Arrays.asList("jlong,rwinch,dsyer,pwebb,sgibb,brunowei".split(","))
					.forEach(userId -> Arrays.asList("Dave,Syer;Phil,Webb;Juergen,Hoeller;Bruno,Wei".split(";"))
							.stream().map(n -> n.split(",")).forEach(name -> cr.save(
									new Contact(userId, name[0], name[1], name[0].toLowerCase() + "@email.com"))));
			cr.findAll().forEach(System.out::println);
		};

	}*/

}
