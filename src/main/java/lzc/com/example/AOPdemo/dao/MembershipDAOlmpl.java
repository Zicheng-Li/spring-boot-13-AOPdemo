package lzc.com.example.AOPdemo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOlmpl implements MembershipDAO{
    @Override
    public void addSillyMember() {
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING a membership ACCOUNT");
    }
}
