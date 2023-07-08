package lzc.com.example.AOPdemo.dao;


import lzc.com.example.AOPdemo.Account;
import org.springframework.stereotype.Repository;

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
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
