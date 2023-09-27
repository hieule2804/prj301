/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends DBContext{
    
    //lay ve list account
    public List<Account> getList(){
     List<Account> list = new ArrayList<>();
     //connect db
     connection = getConnection();
     String sql="select * from Account";
        try {
            statement=connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                Account acc= new Account();
                acc.setId(resultSet.getInt("id"));
                acc.setUsername(resultSet.getString("username"));
                                acc.setPassword(resultSet.getString("password"));
                                list.add(acc);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean checkLogin(Account acc) {
        boolean check = false;
        for (Account account : getList()) {
            if(account.getId()==acc.getId()&&account.getUsername().equals(acc.getUsername())
                    && account.getPassword().equals(acc.getPassword()))
            {
                check =true;
            }
        }
        return check;
    }

    public int getid(String username, String password) {
        for (Account account : getList()) {
            if(account.getUsername().equals(username)&&account.getPassword().equals(password))
            {
                return account.getId();
            }
        }
 
    return -1;
}
}