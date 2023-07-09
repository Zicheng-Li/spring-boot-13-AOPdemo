package lzc.com.example.AOPdemo.dao;


import lzc.com.example.AOPdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOlmpl implements AccountDAO{

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println("do getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("do setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("do getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("do setServiceCode");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // we will simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }
        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Luca", "Gold");
        // add account to list
        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);
        return myAccounts;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);

    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
