package lzc.com.example.AOPdemo.dao;

import lzc.com.example.AOPdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();
    void addAccount(Account theAccount, boolean vipFlag );
    public String getName() ;

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
