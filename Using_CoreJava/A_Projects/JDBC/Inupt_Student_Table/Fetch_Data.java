package com.Amar.A_Projects.JDBC.Inupt_Student_Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fetch_Data {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Amar.123");
        PreparedStatement pst=con.prepareStatement("SELECT * FROM Input_Student");
        ResultSet res=pst.executeQuery();

        while(res.next()){
            String Name=res.getString("Name");
           // String Roll=res.getString("RollNo");
            //String Dpt=res.getString("Department");
            //String City=res.getString("City");
            System.out.println(Name);
            //System.out.println(Dpt);
            //System.out.println(City);
        }
        con.close();
    }
}
