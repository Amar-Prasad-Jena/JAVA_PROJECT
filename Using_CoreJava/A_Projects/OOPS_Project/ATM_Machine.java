package com.Amar.A_Projects.OOPS_Project;
import java.util.Scanner;
public class ATM_Machine {
    public static void main(String[] args) {
        ATM ob = new ATM();
    }
}
class ATM{
    private int pin=8144;
    private double balance=2500;
    Scanner sc=new Scanner(System.in);
    public ATM(){
        System.out.print(" Please Enter PIN : ");
        int temp=sc.nextInt();
        if(temp == pin){
            menu();
        }else{
            System.out.println("Invalid Pin");
        }
    }
    private void menu(){
        System.out.println("Enter Your Choice >>");
        System.out.println("1 : Check Balance");
        System.out.println("2 : Withdrawal Amount");
        System.out.println("3 : Deposit Amount");
        System.out.println("4 : EXIT");

        System.out.print("Enter---- > ");
        int choice=sc.nextInt();

        if(choice == 1){
            checkBalance();
            menu();
        }
        if(choice == 2){
            withdraw();
            menu();
        }
        if(choice == 3){
            deposit();
            menu();
        }
        if(choice == 4){
            return;
        }
    }
    private void checkBalance(){
        System.out.println("Your Balance : " + balance);
    }
    private void withdraw(){
        System.out.print("Enter Withdraw Amount : ");
        double amt=sc.nextDouble();
        balance=balance-amt;
        System.out.println("Successful Withdrawal");
    }
    private void deposit(){
        System.out.print("Enter Amount for Deposit : ");
        double amt=sc.nextDouble();
        balance=balance+amt;
    }
}
