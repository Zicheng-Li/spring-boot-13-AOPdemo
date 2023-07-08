package lzc.com.example.AOPdemo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOlmpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
