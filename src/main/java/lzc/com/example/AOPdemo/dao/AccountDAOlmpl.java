package lzc.com.example.AOPdemo.dao;


import lzc.com.example.AOPdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOlmpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
