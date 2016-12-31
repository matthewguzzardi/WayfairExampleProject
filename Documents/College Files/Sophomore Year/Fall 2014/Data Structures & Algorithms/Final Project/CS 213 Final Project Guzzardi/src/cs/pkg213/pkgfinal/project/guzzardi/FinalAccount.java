/*
Author: Matthew Guzzardi
File: FinalAccount.java
Title: Account Class
Objective: Account Class Part 3
*/
package cs.pkg213.pkgfinal.project.guzzardi;

import java.util.*;

public class FinalAccount {
    private String name;
    private int social;
    private int account;
    private double balance;
    
    private final double INTRESTRATE = 0.01;
    
    public FinalAccount(String newName, double newBalance)
    {
        name=newName;
        
        //social
        Random gen = new Random ();
        social = gen.nextInt(900000000) + 100000000;
        
        //account
        if(name.equals("") && balance == 0){ account = 0;
        }
        else account = gen.nextInt(90000) + 10000;
        
        balance=newBalance;
        
    }
    //deposit
    public double deposit(double amount){
        if (amount > 0)
            balance = balance + amount;
        return balance;
    }
    //withdraw
    public double withdraw(double amount){
        if (amount > 0 && amount < balance)
            balance = balance - amount;
        else if (amount > balance)
            System.out.println("NOT ENOUGH MONEY TO WITHDRAW");
        return balance;
    }
    public double addIntrest(){
        balance = balance + (balance * INTRESTRATE);
        return balance;
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        String actNumb = Integer.toString(account);
        return(actNumb);
    }
    public int getIntAccountNumber(){
        return(account);
    }
    public String getAccountName(){
        return(name);
    }
    public String toString(){
        return(account + "\t" + name + "\t" + balance);
    }
   public String changeName(String changedName){
       name = changedName;
       return(name);
   }
    
}


