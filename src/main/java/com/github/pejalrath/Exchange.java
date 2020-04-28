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
            try{
            banner();
            mode=sc.nextInt();
            switch (mode) {
                case 1:
                    mode_1();
                    break;
                case 2:
                    mode_2(); 
                    break;
                case 3:
                    break;
                    
                default:
                    System.out.println("Invalid input! Please enter '1': User Input; '2': File Input; or '3': Quit");
                    break;
            }

            }
            catch (Exception e)
            {
                System.out.println("Invalid input! Please enter '1': User Input; '2': File Input; or '3': Quit");
                System.exit(1);
                
            }


        }while(mode!=3);

    }
    static private Data search (String args) //Search for local history
    {   
        if(history.containsKey(args))
        {
            return history.get(args);
        }
        else
        {
            Data user_input=new Data(args);
            history.put(args,user_input);
            return history.get(args);
        }
    }
    static private void mode_1()//User input
    {
        Scanner sc=new Scanner(System.in);    
        System.out.println("***User Input Mode***");
        System.out.print("Please enter the number of bill for exchange: ");
        String args=sc.nextLine();
        Data result=search(args);
        result.output();
    }
    static private void mode_2()  //File input
    {
        System.out.println("***File Input Mode***");
        System.out.print("Please enter names of input file and [Option] output file: ");
        List<Data> datas=read();//

            //Insert into databbase sql
        SqlDataSource dataSource = SqlDataSource.getInstance();
        SqlExchangeRepository dRep=new SqlExchangeRepository(dataSource);
        dRep.insertToDB(datas);
            //Read from database
        List<Data> sql_data=dRep.readFromDB();
        for(Data d:sql_data)
        {
            System.out.println(d);
        }


    }
    private static void write(String fn,String data)//Write to file
    {
        File file_name=new File(fn);
        FileWriter file_w=null;
        BufferedWriter buff_w=null;

        try{
            file_w=new FileWriter(file_name,true);
            buff_w=new BufferedWriter(file_w);
            buff_w.write(data);
        }
        catch(IOException e)
        {
            System.out.println("IOException!!!");
        }
        finally{
            try{
                buff_w.close();
                file_w.close();
            }
            catch(IOException e)
            {
                System.out.println("IOExecption!!");
            }
        }


    }
    private static List<Data> read()//read from file
    {
        List<Data> result=new ArrayList<>();//

        BufferedReader reader;
        Scanner sc=new Scanner(System.in);
        String input_filename[]=(sc.nextLine()).split(" ");
        try{
            reader=new BufferedReader(new FileReader(input_filename[0]));
            String line=reader.readLine();
            Data temp;
            while(line!=null)
            {  
                temp=search(line);
                if(input_filename.length==2)
                {
                    write(input_filename[1], temp.toString());
                }
                else if(input_filename.length==1)
                {
                    System.out.println(temp);
                }
                result.add(temp);//
                line=reader.readLine();
            }
            reader.close();
            
        }
        catch(IOException e)
        {
            System.out.println(input_filename[0]+ " No such file exit!");
            
        }
        return result;
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
        user_promt();

    }


}