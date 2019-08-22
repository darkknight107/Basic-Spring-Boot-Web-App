package com.shirish.LoginAuthentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {
	@Autowired
	private AccountRepository account_repo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("newaccount")
	public String addAccount(@RequestBody AccountDTO accountdto) {
		Account newUser= new Account();
		newUser.setUsername(accountdto.getUsername());
		newUser.setPassword(passwordEncoder.encode(accountdto.getPassword()));
		account_repo.save(newUser);
		System.out.println("User added!");
		return "Added";
	}

}
