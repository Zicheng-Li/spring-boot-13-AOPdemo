package lzc.com.example.AOPdemo.dao;

import lzc.com.example.AOPdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag );
    public String getName() ;

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
