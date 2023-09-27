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
import model.TypeAccount;

/**
 *
 * @author ADMIN
 */
public class TypeAccountDAO extends DBContext{
    
    public List<TypeAccount> getList(){
     List<TypeAccount> list = new ArrayList<>();
     //connect db
     connection = getConnection();
     String sql="select * from TypeOfAccount";
        try {
            statement=connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                TypeAccount acc= new TypeAccount();
                acc.setId(resultSet.getInt("id"));
                acc.setCategories(resultSet.getString("categories"));
                                list.add(acc);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
