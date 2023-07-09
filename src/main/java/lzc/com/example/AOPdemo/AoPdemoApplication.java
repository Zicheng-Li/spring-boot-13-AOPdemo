package lzc.com.example.AOPdemo;

import lzc.com.example.AOPdemo.dao.AccountDAO;
import lzc.com.example.AOPdemo.dao.MembershipDAO;
import lzc.com.example.AOPdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO );
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoAroundHandleException(trafficFortuneService);
			demoAroundRethrowException(trafficFortuneService);
		};
	}

	private void demoAroundRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: Around Advice with exception Rethrow");
        System.out.println("calling the fortune service");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("\n Main Program: Fortune is "+data);
        System.out.println("\n Main Program: Finished");
	}

	private void demoAroundHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: Around Advice with exception handling");
        System.out.println("calling the fortune service");
		boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("\n Main Program: Fortune is "+data);
        System.out.println("\n Main Program: Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: Around Advice");
		System.out.println("calling the fortune service");
        String data = trafficFortuneService.getFortune();
        System.out.println("\n Main Program: Fortune is "+data);
        System.out.println("\n Main Program: Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
			// add a boolean flag to simulate an exception
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}

		catch (Exception e) {
			System.out.println("\n Main Program: catch exception "+e.getMessage());
		}

		// display the account
		System.out.println("\n Main Program: AoPdemoApplication  "+ accounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		// call the method to find the accounts
		List<Account> accounts = null;
		try {
			// add a boolean flag to simulate an exception
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        }

		catch (Exception e) {
			System.out.println("\n Main Program: catch exception "+e.getMessage());
		}

		// display the account
		System.out.println("\n Main Program: AoPdemoApplication  "+ accounts);
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
