package com.services;

import com.dao.AccountDAO;
import com.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.ArrayList;

@Component
public class AccountServise implements Servises<Account>{


    private AccountDAO accountDAO;

    @Autowired
    public AccountServise(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void save(Account data) {
        accountDAO.save(data);
    }

    public Account get(String pattern) {
        return accountDAO.get(pattern);
    }

    public ArrayList<Account> getAll()  {
        return accountDAO.getAll();
    }

    public ArrayList<Account> findByStatus(String pattern)  {
        return accountDAO.findByStatus(pattern);
    }

    public ArrayList<Account> findByLogin(String pattern) {
        return accountDAO.findByLogin(pattern);
    }

    public void delete(String pattern)  {
        accountDAO.delete(pattern);
    }

    public void update(Account data, String pattern) {
       accountDAO.update(data,pattern);
    }
}
