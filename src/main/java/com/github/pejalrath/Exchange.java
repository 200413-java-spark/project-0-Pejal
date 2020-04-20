package com.github.pejalrath;

import  java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class Exchange{
    static private Hashtable<String,Data> history=new Hashtable<String,Data>();
    
    static private void user_promt()
    {
        int mode=0;
        Scanner sc=new Scanner(System.in);
        do{
            banner();
            mode=sc.nextInt();
            switch (mode) {
                case 1:
                    mode_1();
                    break;
                case 2:
                    //mode_2(); //not yet implement
                    break;
                case 3:
                    break;
                    
                default:
                    System.out.println("Invalid input! Please enter '1': User Input; '2': File Input; or '3': Quit");
                    break;
            }


        }while(mode!=3);

    }
    static private void mode_1()//User input
    {
        Scanner sc=new Scanner(System.in);
            
        System.out.println("***User Input Mode***");
        System.out.print("Please enter the number of bill for exchange: ");
        
        String args=sc.nextLine();
    
        if(history.containsKey(args))
        {
            (history.get(args)).output();
        }
        else{
            Data user_input=new Data(args);
            history.put(args,user_input);
            (history.get(args)).output();
        }
        
    
    }
    static private void mode_2()//File input
    {
        System.out.println("***File Input Mode***");
        System.out.print("Please enter names of input file and [Option] output file: ");
        

    }
     
    static private void banner()
    {
        System.out.println("*****Exchange System*****");
        System.out.println("Please select mode: ");
        System.out.println("1) User input");
        System.out.println("2) File input");
        System.out.println("3) Quit");
    }

    public static void main(String[] args)
    {
        // Data user_input=new Data(args);
        // history.put(args[0],user_input);
        // (history.get(args[0])).output();
        user_promt();

    }


}