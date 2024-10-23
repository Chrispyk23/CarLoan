/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.carloan;
import java.util.Scanner;
/**
 *
 * @author chris
 */
public class CarLoan {

    public static void main(String[] args) {
  Scanner scanner  = new Scanner(System.in);
  System.out.print("enter loan amount:");
  int carLoan = scanner.nextInt();
  
  System.out.print("enter loan length:");
  int loanLength = scanner.nextInt();
  
  System.out.print("enter interest rate:");
  double interestRate = scanner.nextDouble() / 100;
          
  System.out.print("enter down payment amount:");
  int downPayment = scanner.nextInt();
  
  if(loanLength <= 0 || interestRate <= 0){
  System.out.println("Please take out a valid car loan");
  }else if (downPayment >= carLoan){
    System.out.println("The car can be paid in full");
  }  
    else{
    int remainingBalance = carLoan - downPayment;
    int months = loanLength * 12;
    int monthlyBalance = remainingBalance / months;
    double interest = monthlyBalance * interestRate;
    double monthlyPayment = monthlyBalance + interest;
    System.out.println(monthlyPayment);

   scanner.close();
  }

    }
}
