package com.Amar.A_Projects.JDBC.Inupt_Student_Table;
import java.sql.*;

public class Input_Student {
    public static void main(String[] args) throws Exception {
        // createStuTable();
      /*  Scanner sc = new Scanner(System.in);
        System.out.print("Enter No Of Students : ");
        int n=sc.nextInt();

        while(n>0) {
            System.out.print("Enter Student Name : ");
            String name = sc.next();

            System.out.print("Enter Student Roll No : ");
            int roll = sc.nextInt();

            System.out.print("Enter Department : ");
            String dpt = sc.next();

            System.out.print("Enter Students City : ");
            String city = sc.next();

            addData(name, roll, dpt, city);
            n--;
        }*/
        printInfo();
    }
    public static void createStuTable() throws Exception{
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Amar.123");
        String query="CREATE TABLE Input_Student(Name VARCHAR(50), RollNo INT, Department VARCHAR(50), City VARCHAR(20))";
        Statement stm=conn.createStatement();
        stm.execute(query);
        System.out.println("Done");
        conn.close();
    }
    public static void addData(String name,int roll,String dpt,String city) throws Exception{
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Amar.123");
        String query="insert into Input_Student values ('"+name+"','"+roll+"','"+dpt+"','"+city+"')";
        PreparedStatement pst = conn.prepareStatement(query);
        int i=pst.executeUpdate();
        if(i!=0)
            System.out.println("Data Added Successfully");
        conn.close();
    }
    public static void printInfo() {
        try {
            String url = "jdbc:mysql://localhost:3306/java";
            String userName = "root";
            String password = "Amar.123";
            Connection con = DriverManager.getConnection(url, userName, password);
            System.out.println("Successfully done");
            Statement st=con.createStatement();
            ResultSet res= st.executeQuery("select * from Input_Student");
            while(res.next()){
                System.out.println(res.getString("Name"));
                System.out.println(res.getString("RollNo"));
                System.out.println(res.getString("Department"));
                System.out.println(res.getString("City"));

            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
