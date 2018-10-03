package com.digi.dfs.users;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringCloudApplication
@EnableDiscoveryClient
@ComponentScan("com.digi.dfs")
public class UserManagementApplication {
    public static void main(String args[]) throws Throwable {
        SpringApplication.run(UserManagementApplication.class, args);
    }
}
