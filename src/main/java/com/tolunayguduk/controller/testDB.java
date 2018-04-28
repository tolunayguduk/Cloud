package com.tolunayguduk.controller;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

@WebServlet("/testDB")
public class testDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "root";
        String pass = "";
        String jdbcURL ="jdbc:mysql://localhost:3306/cloud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";


        try{

            PrintWriter out = resp.getWriter();
            out.println("Veritabanına bağlanti : " + jdbcURL);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcURL,user,pass);
            out.println("BASARILI");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException();
        }

    }
}
