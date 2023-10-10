package com.Amar.A_Projects.JDBC.Inupt_Student_Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete_Row {
    public static void main(String[] args) throws Exception{
        String RollNo="1";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Amar.123");
        PreparedStatement pst=con.prepareStatement("delete from Input_Student where RollNo= ?");
        pst.setString(1,RollNo);

        int i=pst.executeUpdate();
        if(i>0){
            System.out.println("Successfully Deleted");
        }else{
            System.out.println("Fail");
        }
    }
}
