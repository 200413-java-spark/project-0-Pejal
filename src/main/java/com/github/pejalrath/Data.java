package com.github.pejalrath;

public class Data {
        private int quarter=0;
        private int dime=0;
        private int nickle=0;
        private int penny=0;
        private int input=0;
        private int total_coin=0;
        //Constructor 
        public Data(){}
        
        public Data(String args) 
        {
            if(args!="")
            {
                try
                {
                    this.input=(int)(Float.parseFloat(args)*100);
                    convertToCoin();

                }
                catch(NumberFormatException e)
                {
                    System.out.println("Please provide number as input!");
                    System.exit(1);
                }           

            }
        }
        private void convertToCoin()
        {
            int temp_input=this.input;
            while(temp_input>=1)
            {
                if(temp_input>=25)
                {
                    this.quarter++;
                    temp_input-=25;
                }
                else if(temp_input>=10)
                {
                    this.dime++;
                    temp_input-=10;
                }
                else if(temp_input>=5)
                {
                    this.nickle++;
                    temp_input-=5;
                }
                else if(temp_input>=1)
                {
                    this.penny++;
                    temp_input-=1;
                }
                this.total_coin++;
            }

        }
        //Getter
        public double getInput()
        {
            return this.input/100.0;
            
        }
        public int getTotal()
        {
            return this.total_coin;
        }
        public int getQuarter()
        {
            return this.quarter;
        }
        public int getDime()
        {
            return this.dime;
        }
        public int getNickle()
        {
            return this.nickle;
        }
        public int getPenny()
        {
            return this.penny;
        }
        //Setter
        public void setInput(double num)
        {
            this.input=(int)(num*100);
            
            
        }
        public void setTotal(int num)
        {
            this.total_coin=num;
        }
        public void setQuarter(int num)
        {
            this.quarter=num;
        }
        public void setDime(int num)
        {
            this.dime=num;
        }
        public void setNickle(int num)
        {
            this.nickle=num;
        }
        public void setPenny(int num)
        {
            this.penny=num;
        }
        //
        public void output()
        {
            System.out.println("The minimum number of coin of this exhange is "+this.total_coin);
            System.out.println("Quater: "+this.quarter+" \nDime: "+this.dime+" \nNickle: "+this.nickle+" \nPenny: "+this.penny+"\n");
        }
        @Override
        public String toString()
        {
            return (input/100)+" "+total_coin+" "+ quarter+" "+dime+" "+nickle+" "+penny+"\n";
        }

}