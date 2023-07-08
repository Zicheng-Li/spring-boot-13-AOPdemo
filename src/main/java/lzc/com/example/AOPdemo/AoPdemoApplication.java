package lzc.com.example.AOPdemo;

import lzc.com.example.AOPdemo.dao.AccountDAO;
import lzc.com.example.AOPdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AoPdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AoPdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO );
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account myAccount = new Account();

		accountDAO.addAccount(myAccount, true);
		membershipDAO.addSillyMember();
		// call the AccountDAO getter/setter methods
		accountDAO.setName("john");
		accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();
	}

}
