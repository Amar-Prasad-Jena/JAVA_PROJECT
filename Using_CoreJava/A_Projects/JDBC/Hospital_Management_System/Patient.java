package com.Amar.A_Projects.JDBC.Hospital_Management_System;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Patient {
    private static Connection conn;
    private static Scanner sc;
    private static Patient pt = new Patient();
    private Patient(){

    }
    public static Patient getPatient(Connection conn,Scanner sc){
        Patient.conn=conn;
        Patient.sc=sc;
        return pt;
    }
    public void addPatient(){
        System.out.print("Enter Patient  Name : ");
        String name=sc.next();
        System.out.print("Patient Age : ");
        int age=sc.nextInt();
        System.out.print("Patient Gender : ");
        String gender=sc.next();
        try{
            PreparedStatement pst = conn.prepareStatement("INSERT INTO pateint(NAME,AGE,GENDER) VALUES (?,?,?)");
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.setString(3,gender);
            int isExecute=pst.executeUpdate();
            if(isExecute>0){
                System.out.println("Successfully Added");
            }else{
                System.out.println("Failed");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void viewPatient(){
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM pateint");
            ResultSet res=pst.executeQuery();
            System.out.println("Patient : ");
            System.out.println("+-----------+---------------------+-------+------------+");
            System.out.println("| PatientId |   Name              | Age   | Gender     |");
            System.out.println("+-----------+---------------------+-------+------------+");
            while(res.next()){
                int id=res.getInt("ID");
                String name=res.getString("NAME");
                int age=res.getInt("AGE");
                String gender=res.getString("GENDER");
                System.out.printf("| %-9s | %-19s | %-5s | %-10s |\n",id,name,age,gender);
                System.out.println("+-----------+---------------------+-------+------------+");

            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean getPatientById(int id){

        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM pateint WHERE ID = ?");
            pst.setInt(1,id);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
