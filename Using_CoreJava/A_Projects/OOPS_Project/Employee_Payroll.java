package com.Amar.A_Projects.OOPS_Project;
import java.util.ArrayList;
public class Employee_Payroll {
    public static void main(String[] args) {
        Payroll PayrollSystem=new Payroll();
        FullTimeEmployee Emp1 = new FullTimeEmployee("Amar",04,22000);
        PartTimeEmployee Emp2 = new PartTimeEmployee("Kisan",49,30,1000);

        PayrollSystem.addEmp(Emp1);
        PayrollSystem.addEmp(Emp2);

        System.out.println("Initial Employee Details -->> ");
        PayrollSystem.display();

        System.out.println("\nRemoving Employee...");
        PayrollSystem.removeEmp(49);

        System.out.println("Remaining Details -->>");
        PayrollSystem.display();
    }
}
abstract class Employee {
    static int count = 0;

    {
        count++;
    }

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    abstract double calculateSal();

    @Override
    public String toString() {
        return "Employee[ Name : " + name + " , Id : " + id + " , Salary : " + calculateSal() + " ]";
    }
}
    class FullTimeEmployee extends Employee{
        private double monthSal;
        FullTimeEmployee(String name,int id,double monthSal){
            super(name,id);
            this.monthSal=monthSal;
        }
        double calculateSal(){
            return monthSal;
        }
    }
    class PartTimeEmployee extends Employee{
        private int hoursWorked;
        private int hoursRate;
        PartTimeEmployee(String name,int id,int hoursWorked,int hoursRate){
            super(name,id);
            this.hoursWorked=hoursWorked;
            this.hoursRate=hoursRate;
        }
        double calculateSal(){
            return hoursWorked * hoursRate;
        }
    }
    class Payroll{
        ArrayList<Employee> EmpList;
        Payroll(){

            EmpList=new ArrayList<>();
        }
        public void addEmp(Employee emp){
            EmpList.add(emp);
            System.out.println("SuccessFully Add");
        }
        public void removeEmp(int id){
            Employee empToRemove=null;
            for(Employee emp : EmpList){
                if(emp.getId() == id){
                    empToRemove = emp;
                }
            }
            if(empToRemove != null){
                EmpList.remove(empToRemove);
                Employee.count--;
                System.out.println("Successfully Removed");
            }else{
                System.out.println("Invalid Id...!!");
            }
        }
        public void display(){
            for(Employee emp : EmpList){
                System.out.println();
                System.out.println("Total Employee : "+Employee.count);
                System.out.println(emp);
            }
        }
    }