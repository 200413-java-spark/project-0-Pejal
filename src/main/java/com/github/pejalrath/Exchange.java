package com.github.pejalrath;
class Exchange{
    public static void main(String[] args)
    {
        int quarter=0;
        int dime=0;
        int nickle=0;
        int penny=0;
        int input=0;
        
        int total_coin=0;
        //Prase input
        if(args.length>0)
        {
            try
            {
                input=(int)(Float.parseFloat(args[0])*100);

            }
            catch(NumberFormatException e)
            {
                System.out.println("Please provide number as input!");
                System.exit(1);
            }           

        }
        System.out.println(input);
        //Perform convertions.
        while(input>=1)
        {
            if(input>=25)
            {
                quarter++;
                input-=25;
            }
            else if(input>=10)
            {
                dime++;
                input-=10;
                
               
            }
            else if(input>=5)
            {
                nickle++;
                input-=5;
            }
            else if(input>=1)
            {
                penny++;
                input-=1;
            }
            total_coin++;
        }
    
        //Printing output
        System.out.println("The minimum number of coin of this exhange is "+total_coin);
        System.out.println("Quater: "+quarter+" Dime: "+dime+" Nickle: "+nickle+" Penny: "+penny);

    }


}