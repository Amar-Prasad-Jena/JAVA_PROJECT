package com.Amar.A_Projects.JDBC.Hospital_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Doctors {
    private static Connection conn;
    private static Doctors doc = new Doctors();
    private Doctors(){
    }
    public static Doctors getDoctor(Connection conn){
        Doctors.conn=conn;
        return  doc;
    }
    public void viewDoctors(){
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM doctors");
            ResultSet res=pst.executeQuery();
            System.out.println("Doctors : ");

            System.out.println("+-----------+--------------------+-------------------+");
            System.out.println("| Doctors Id|   Name             | Specialization    |");
            System.out.println("+-----------+--------------------+-------------------+");
            while(res.next()){
                int id=res.getInt("ID");
                String name=res.getString("NAME");
                String spl=res.getString("SPECIALIZATION");
                System.out.printf("| %-9s | %-18s | %-17s |\n",id,name,spl);
                System.out.println("+-----------+--------------------+-------------------+");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean getDoctorsById(int id){

        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM doctors WHERE ID = ?");
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
