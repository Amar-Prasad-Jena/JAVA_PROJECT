package com.Amar.A_Projects.JDBC.Hospital_Management_System;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "Amar.123";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      /*  try{
            Class.forName("com.mysql.jdbc.Driver");

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }*/

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Patient patient = Patient.getPatient(con,sc);
            Doctors doctor = Doctors.getDoctor(con);

            while(true){
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.print("Enter Your Choice : ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1: //Add patient
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2: //View Patients
                        patient.viewPatient();
                        System.out.println();
                        break;
                    case 3: //View Doctors
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4: //Book Appointment
                        bookAppointment(patient,doctor,con,sc);
                        break;
                    case 5: //Exit
                        System.out.println("THANK YOU! FOR USING HOSPITAL MANAGEMENT SYSTEM");
                        return;
                    default :
                        System.out.println("Enter valid choice!!!");
                        break;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public static void bookAppointment (Patient pt,Doctors doc,Connection conn,Scanner sc){
        System.out.print("Enter Patient Id : ");
        int patientId = sc.nextInt();
        System.out.print("Enter Doctor Id : ");
        int doctorId = sc.nextInt();
        System.out.print("Enter appointment Date(YYYY-MM-DD): ");
        String appointmentDate=sc.next();

        if(pt.getPatientById(patientId) && doc.getDoctorsById(doctorId)){
            if(isAvailableDoc(doctorId , appointmentDate , conn)){
                try {
                    PreparedStatement pst = conn.prepareStatement("INSERT INTO appointments (pateint_id,doctors_id,appointment_date) VALUES (?,?,?)");
                    pst.setInt(1,patientId);
                    pst.setInt(2,doctorId);
                    pst.setString(3,appointmentDate);

                    int isExecute=pst.executeUpdate();
                    if (isExecute>0){
                        System.out.println("Appointment Booked");
                    }else{
                        System.out.println("Failed to Book Appointment!!!");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("Doctor not Available At this Date!!");
            }
        }else{
            System.out.println("Either Doctor or Patient does not Exit !!!");
        }
    }
    public static boolean isAvailableDoc(int doctorsId,String date,Connection conn){
        String query = "SELECT COUNT(*) FROM appointments WHERE doctors_id = ? AND appointment_date = ? ";
        try{
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1,doctorsId);
            pst.setString(2,date);
            ResultSet res=pst.executeQuery();
            if(res.next()){
               int count = res.getInt(1);
               if(count == 0){
                   return true;
               }else{
                   return false;
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
