<%-- 
    Document   : admin
    Created on : Sep 26, 2023, 11:39:09 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADM</h1>
        
        <button onclick="createAcc()">CREATE ACCOUNT </button>
        <button onclick="createType()">CREATE TYPE OF ACCOUNT </button>

        <form action="" id="createTypeAcc" style="display: none">
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>categories</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listType}" var="type">
                    <tr>
                        <td>${type.id}</td>
                        <td>${type.categories}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </form>
        <!--  form List Account -->
        <form action="" id="createAcc" style="display: none">
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>username</th>
                      <th>password</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listAcc}" var="acc">
                    <tr>
                        <td>${acc.id}</td>
                        <td>${acc.username}</td>
                        <td>${acc.password}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </form>
        
        <script>
            function createAcc(){
                let x = document.getElementById("createAcc");
                if(x.style.display=='none')
                {
                    x.style.display="block";
                }else{
                                        x.style.display="none";

                }
                
            }
             function createType(){
                let x = document.getElementById("createTypeAcc");
                if(x.style.display=='none')
                {
                    x.style.display='block';
                }else{
                                        x.style.display="none";

                }
                
            }
        </script>
    </body>
</html>
