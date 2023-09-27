/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.TypeAccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class HomeServlet extends HttpServlet {

    AccountDAO accDao = new AccountDAO();
    TypeAccountDAO typeDao = new TypeAccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listAcc", accDao.getList());
        request.setAttribute("listType", typeDao.getList());
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get username,password,id
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        int id =accDao.getid(username,password);
        
        Account acc = new Account (id, username, password);    
     if (accDao.checkLogin(acc) == true) {
            request.setAttribute("listAcc", accDao.getList());
            request.setAttribute("listType", typeDao.getList());
            switch (acc.getId()) {
                case 1:
                    request.setAttribute("listAcc", accDao.getList());
                    request.setAttribute("listType", typeDao.getList());
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                    break;
                case 2:
                    response.sendRedirect("user.jsp");
                    break;
                case 3:
                    request.getRequestDispatcher("employee.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            PrintWriter out = response.getWriter();
            out.print("Account fail!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}

