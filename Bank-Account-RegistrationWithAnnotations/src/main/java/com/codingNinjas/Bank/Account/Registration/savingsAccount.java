package com.codingNinjas.Bank.Account.Registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("savingsAccount")
@Scope("prototype")
public class savingsAccount implements Account {
	double amount = 0;

	@PostConstruct
	public void init() {
		System.out.println("savings account created");
	}

	@Override
	public String getAccountType() {
		// TODO Auto-generated method stub
		return "Savings Account";
	}

	@Override
	public void addBalance(double balance) {
		// TODO Auto-generated method stub
		this.amount += balance;

	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return this.amount;
	}
}
