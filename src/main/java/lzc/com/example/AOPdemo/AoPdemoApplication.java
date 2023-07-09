package lzc.com.example.AOPdemo;

import lzc.com.example.AOPdemo.dao.AccountDAO;
import lzc.com.example.AOPdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AoPdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AoPdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO );
			demoTheAfterReturningAdvice(accountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		// call the method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();
		// display the account
		System.out.println("\n Main Program: AoPdemoApplication  "+ accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("John");
		myAccount.setLevel("Platinum");
		accountDAO.addAccount(myAccount, true);
		membershipDAO.addSillyMember();
		// call the AccountDAO getter/setter methods
		accountDAO.setName("john");
		accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();
	}

}
