/*
Author: Matthew Guzzardi
File: CS213FinalProjectGuzzardi.java
Title: Bank Final Project
Objective: Driver
*/
package cs.pkg213.pkgfinal.project.guzzardi;

import java.util.*;

public class CS213FinalProjectGuzzardi {

   public static void main(String[] args) {
        FinalAccount[] accountArray = new FinalAccount[25]; //Creation of the Array of Accounts
            int globalArrayCounter = 25; // Counter to store array length
        //For loop fills the Array with null data
             for(int i=0; i < globalArrayCounter; i++){ 
                 accountArray[i] = new FinalAccount ("",0);
              }
             
        //Original 10 Accounts that come pre-loaded with program
        accountArray[0] = new FinalAccount ("Matthew Guzzardi", 5678.00);
        accountArray[1] = new FinalAccount ("Sam Fargo", 3450.00);
        accountArray[2] = new FinalAccount ("Sean Mahar", 0.00);
        accountArray[3] = new FinalAccount ("Cosmo Erbafina", 107000.00);
        accountArray[4] = new FinalAccount ("Barry Mcpherson", 145000.00);
        accountArray[5] = new FinalAccount ("Andrew Beliveau", 25.00);
        accountArray[6] = new FinalAccount ("Emily Mason", 3300.00);
        accountArray[7] = new FinalAccount ("Mike Smith", 389.00);
        accountArray[8] = new FinalAccount ("Greg Laboe", 487.00);
        accountArray[9] = new FinalAccount ("Shawn Murphy", 667.00);
        
        System.out.println("Saint Anselm Bank - Account Center");
        
        Scanner scan = new Scanner(System.in); //Create a Scanner "scan" menu choice
        //Menu options printed and choice is scanned
            int choice;
            
              System.out.println();
              System.out.println("Options:");
              System.out.println("Enter 1: Display all accounts.");
              System.out.println("Enter 2: Search using Full Name (Linear) and Account Number (Binary), to Display account and make deposit or withdrawl.");
              System.out.println("Enter 3: Compare Selection Sort and Bubble Sort");
              System.out.println("Enter 4: Add intrest to an account.");
              System.out.println("Enter 5: Delete an account.");
              System.out.println("Enter 6: Display number of accounts with bank.");
              System.out.println("Enter 7: Create a new account.");
              System.out.println("Enter 8: Change Name on Account.");
              System.out.println("Enter 9: Quit Program.");
                  choice = scan.nextInt();
     
        //Scanners declared
            Scanner scanName = new Scanner (System.in); //Scan Name to search for
            Scanner scantodw = new Scanner(System.in); //Scan Amount to deposit or withdraw
            Scanner actNumbScan = new Scanner(System.in); //Scan Account Number to search for
        //Variables for searches    
            String enterName;
            String scannedAccountNumber;
            String changedName;
        
        switch(choice){
            case 1: //Enter 1: Display all accounts.
                for(int i=0; i<globalArrayCounter; i++){
                    if(!accountArray[i].getAccountNumber().equals("0")){
                        System.out.println(accountArray[i]);
                    }
                    
        }
            break;
            case 2: 
                double linearSearchResults = 0;
                double binarySearchResults = 0;
                    //Linear Search by Name   
                System.out.println("\nEnter full name of account holder to display detail: (Linear Search)");
                double amttodep = 0;
                double amttowith = 0;
                enterName = scanName.nextLine();
                            long startTimeLinear = System.nanoTime(); //Start Recording System Time
                        
                for(int i=0; i<globalArrayCounter; i++){
                    if(accountArray[i].getAccountName().equals(enterName)){
                        if(enterName.equals(""))
                            break;
                        System.out.println(accountArray[i]);
                        
                            long elapsedTimeLinear = System.nanoTime() - startTimeLinear; //Find Elapsed Time of Linear Search
                            System.out.println("\nSystem Time to Complete Linear Search: " + elapsedTimeLinear + "nano seconds"); //Report Time
                            linearSearchResults = elapsedTimeLinear;
                        System.out.println("\nEnter amount to Deposit:");
                            amttodep = scantodw.nextDouble();
                            accountArray[i].deposit(amttodep);
                        System.out.println("\nEnter amount to Withdraw:");
                            amttowith = scantodw.nextDouble();
                            accountArray[i].withdraw(amttowith);
                        System.out.println(accountArray[i]);
                    }
                }
                        //Finish Linear Search
                        
                        //Begin Sort Necessary for Binary Search
                FinalAccount tempBub = new FinalAccount ("",0);
                for (int i=0; i<globalArrayCounter; i++) {
                    for (int j=1; j<(globalArrayCounter-1); j++) {
                        if (accountArray[j-1].getIntAccountNumber() > accountArray[j].getIntAccountNumber()){
                            tempBub = accountArray[j-1];
                            accountArray[j-1] = accountArray[j];
                            accountArray[j] = tempBub;
                        }
                    }
                }
                        //Begin Binary Search
                System.out.println();
                System.out.println("\nEnter an account number to display detail: (Binary Search)");
                scannedAccountNumber = actNumbScan.nextLine();
                
                    int low = 0;
                    int high = globalArrayCounter - 1;
                    int actNumbInt = Integer.parseInt(scannedAccountNumber);
                long startTimeBinary = System.nanoTime(); //Start Timer
                while(high >= low) {
                    int middle = (low + high) / 2;
                    if(accountArray[middle].getAccountNumber().equals(scannedAccountNumber)){
                        System.out.println(accountArray[middle]);
                        break;
                    }
                    if(accountArray[middle].getIntAccountNumber() < actNumbInt) {
                        low = middle + 1;
                    }
                    if(accountArray[middle].getIntAccountNumber() > actNumbInt) {
                        high = middle - 1;
                    }
                }
                long elapsedTimeBinary = System.nanoTime() - startTimeBinary; //End Timer
                System.out.println("\nSystem Time to Complete Binary Search: " + elapsedTimeBinary + "nano seconds");
                binarySearchResults = elapsedTimeBinary;
                System.out.println("\nEFFICIENCY DETAILS:");
                System.out.println("Linear Search: " + linearSearchResults + "nanoseconds");
                System.out.println("Binary Search: " + binarySearchResults + "nanoseconds");
                if(linearSearchResults > binarySearchResults){
                System.out.println("In this instance, the *Binary Search* took less time and was more efficient.");
                        }
                if(linearSearchResults < binarySearchResults){
                System.out.println("In this instance, the *Linear Search* took less time and was more efficient.");
                        }
            break;
            case 3: 
                double selectionSortResults = 0;
                double bubbleSortResults = 0;
                //Selection Sort by Name
                    long startTimeSelectSort = System.nanoTime(); //Start Recording System Time
                for (int i=1; i<globalArrayCounter; i++){
                    int s = i-1; //Index of Smallest
                    for(int j=i; j<globalArrayCounter; j++){
                        if(accountArray[j].getAccountName().compareTo(accountArray[s].getAccountName()) < 0){
                            s = j;
                        }
                    }
                    FinalAccount tempSelect = new FinalAccount ("",0);
                    tempSelect = accountArray[i-1];
                    accountArray[i-1] = accountArray[s];
                    accountArray[s] = tempSelect;
                    
                }
                    long elapsedTimeSelectSort = System.nanoTime() - startTimeSelectSort; //End Timer
                    System.out.println("\n*Sorted*");
                    //Display Sorted Accounts
                        for(int k=0; k<globalArrayCounter; k++){
                            if(!accountArray[k].getAccountNumber().equals("0")){
                            System.out.println(accountArray[k]);
                     }
                        
                    System.out.println("\nSystem Time to Complete Selection Sort: " + elapsedTimeSelectSort + "nano seconds");
                    selectionSortResults = elapsedTimeSelectSort;
                    
                
                    
                //Bubble Sort by Account Number
                    //Begin Bubble Sort
                long startTimeBubSort = System.nanoTime(); //Start Timer
                for (int i=0; i<globalArrayCounter; i++) {
                    for (int j=1; j<(globalArrayCounter-1); j++) {
                        if (accountArray[j-1].getIntAccountNumber() > accountArray[j].getIntAccountNumber()){
                            tempBub = accountArray[j-1];
                            accountArray[j-1] = accountArray[j];
                            accountArray[j] = tempBub;
                        }
                    }
               
                }
                long elapsedTimeBubSort = System.nanoTime() - startTimeBubSort; //End Timer
                System.out.println("\n*Sorted*");
                    //Display Sorted Accounts
                        for(int k=0; k<globalArrayCounter; k++){
                            if(!accountArray[k].getAccountNumber().equals("0")){
                            System.out.println(accountArray[k]);
                     }
                        }
                System.out.println("\nSystem Time to Complete Bubble Sort: " + elapsedTimeBubSort + "nano seconds");
                bubbleSortResults = elapsedTimeBubSort;
                //End Bubble sort
                System.out.println("\nEFFICIENCY DETAILS:");
                System.out.println("Selection Sort: " + selectionSortResults + "nanoseconds");
                System.out.println("Bubble Sort: " + bubbleSortResults + "nanoseconds");
                if(selectionSortResults > bubbleSortResults){
                System.out.println("In this instance, the *Bubble Sort* took less time and was more efficient.");
                        }
                if(selectionSortResults < bubbleSortResults){
                System.out.println("In this instance, the *Selection Sort* took less time and was more efficient.");
                        }
                
             break;
             case 4: //Enter 4: Add intrest to an account.
                System.out.println("\nEnter full name of account holder to add interest: ");
                    enterName = scanName.nextLine();
                for(int i=0; i<globalArrayCounter; i++){
                    if(accountArray[i].getAccountName().equals(enterName)){
                        accountArray[i].addIntrest();
                        System.out.println("\n*Intrest Added*");
                    }
                }
            break;
            case 5: //Enter 5: Delete an account.
                System.out.println("\nEnter account number to delete account:");
                scannedAccountNumber = actNumbScan.nextLine();
                for(int i=0; i<globalArrayCounter; i++){
                    if(!scannedAccountNumber.equals("") && accountArray[i].getAccountNumber().equals(scannedAccountNumber)){

                        accountArray[i] = new FinalAccount ("",0);
                        accountArray[i] = accountArray[i+1];
                        
                        
                    }
                }
                System.out.println("\nEnter full name to delete account:");
                enterName = scanName.nextLine();
                for(int i=0; i<globalArrayCounter; i++){
                    if(!enterName.equals("") && accountArray[i].getAccountName().equals(enterName)){
 
                         accountArray[i] = new FinalAccount ("",0);
                         accountArray[i] = accountArray[i+1];
                         
                }
        }
            break;
            case 6: //Enter 6: Display number of accounts with bank.

                int counter = 0;
                for(int i=0; i<globalArrayCounter;i++){
                    if(!accountArray[i].getAccountNumber().equals("0"))
                    counter++;
                }
                for(int i=0; i<globalArrayCounter; i++){
                    for(int x = i+1; x<globalArrayCounter; x++){
                        if(accountArray[i] == accountArray[x] && !accountArray[i].getAccountNumber().equals("0")) counter--;

                    }
                }
                System.out.println("\nThe number of accounts currently open: " + counter);
            break;
            case 7: //Enter 7: Create a new account.
                System.out.println("\nEnter Full Name for new account: ");
                    String newAccountName = scanName.nextLine();
                System.out.println("\nEnter starting Balance for new account: ");
                    int newAccountBalance = scan.nextInt();
                
                for(int i=0; i < globalArrayCounter; i++){ 
                    if(accountArray[i].getAccountNumber().equals("0")){
                    accountArray[i] = new FinalAccount (newAccountName, newAccountBalance);
                    break;
                    }
                }
            break;
            case 8: 
                System.out.println("\nEnter original name to change name on bank account.");
                enterName = scanName.nextLine();
                for(int i=0; i<globalArrayCounter; i++){
                    if(accountArray[i].getAccountName().equals(enterName)){
                        if(enterName.equals(""))
                            break;
                        System.out.println(accountArray[i]);
                        System.out.println("\nPlease Enter new Full Name...");
                        changedName = scanName.nextLine();
                        accountArray[i].changeName(changedName);
                
        }
                }
                //actnumb
                System.out.println("\nEnter account number to change name on bank account.");
                scannedAccountNumber = actNumbScan.nextLine();
                for(int i=0; i<globalArrayCounter; i++){
                    if(accountArray[i].getAccountNumber().equals(scannedAccountNumber)){
                        if(scannedAccountNumber.equals(""))
                            break;
                   
                        System.out.println(accountArray[i]);
                        System.out.println("\nPlease Enter new Full Name...");
                        changedName = scanName.nextLine();
                        accountArray[i].changeName(changedName);
                    }
                }
                
                
                      
        break;
        }
    
        
        
   }while(choice < 9);
             System.exit(0);
}
}

             
        
        
    
    

   
