package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.Scanner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		
		Scanner s=new Scanner(System.in);
		//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.codingNinjas.Bank.Account.Registration");
		ApplicationContext context=SpringApplication.run(BankAccountRegistrationApplication.class, args);
		System.out.println("Welcome to Account Registration Appliacation!");
		User myUser=context.getBean(myUser.class);
		System.out.println("Please enter your name?");
		String name=s.nextLine();
		myUser.setUserDetails(name);
		System.out.println("Do you want to add account\n1. Yes\n2. No");
		int choice=s.nextInt();
		s.nextLine();
		int continueOrExit=0;
		String accountType="";
		Account account=null;
		while(true) {
			switch (choice) {
			case 1: {
				System.out.println("Please select the account type\n1. Current\n2. Savings");
				int accountChoice=s.nextInt();
				s.nextLine();
				switch(accountChoice) {
				case 1:
					accountType="currentAccount";
					account=context.getBean(currentAccount.class);
					break;
				case 2:
					accountType="savingsAccount";
					account=context.getBean(savingsAccount.class);
					break;
				}
				
				System.out.println("Enter opening balance");
				double balance=s.nextDouble();
				s.nextLine();
				account.addBalance(balance);
				myUser.addAccount(account);
				System.out.println("Do you want to add more account\n1. Yes\n2. No");
				continueOrExit=s.nextInt();
				s.nextLine();
				if(continueOrExit==2) {
					break;
				}
			
			break;	
			}
			
			case 2:
				break;
			
			default:
				
			}

			if(choice==2 || continueOrExit==2) {
				break;
			}
			
		}
		System.out.println("Hi "+name+", here is the list of your accounts:");
		ArrayList<Account> ist=(ArrayList<Account>) myUser.getAllAccounts();
		for(Account a:ist) {
			int l=a.toString().length();
			System.out.println(a.getAccountType()+" : Opening balance - "+a.getBalance()+" Reference Id "+a.toString().substring(l-9));
		}
		s.close();
		//context.close();
		

	}

}
