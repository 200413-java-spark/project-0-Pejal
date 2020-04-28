README

# Money Exchange
- The function will take input from user as money and convert it to coin with a minimum number coin possible.

## How to build and run Exchange.java application
### Build Command
> mvn clean compile

### Run Command
> mvn exec:java

## How to build, run and kill Docker container

### Build Command
> sudo docker build -t exchangedb .

### Run Command
> sudo docker run --name exchangedb --rm -d -p 5432:5432 exchangedb

### Kill Command
> sudo docker kill exchangedb

## How to access SQL Database

>sudo docker exec -it exchangedb psql -U exchangedb
### Read all infomation in data table
>select * from data;

## Example of how to operate Exchange application


### Example Mode#1: User performes single operation.
#### Expected input:
    *****Exchange System*****
    Please select mode:
    1) User input
    2) File input to [console||output file]
    3) File input to [console||output file] and Store to SQL Database
    4) Read all data store inside SQL Database
    5) Quit
    $1
    *** Mode #1 ***
    Please enter the number of bill for exchange:$1.16

#### Expected output:
    The minimum number of coin of this exhange is 7
    Quater: 4 
    Dime: 1
    Nickle: 1
    Penny: 1
### Example Mode#2: Print output to console
##### Input.csv
    1
    2
    3
    4
    5
    66
    666
#### Expected input:
    *****Exchange System*****
    Please select mode:
    1) User input
    2) File input to [console||output file]
    3) File input to [console||output file] and Store to SQL Database
    4) Read all data store inside SQL Database
    5) Quit
    $2
    *** Mode #2 ***
    Please enter names of input file and [Option] output file: $input.csv
#### Expected output:
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0
### Example Mode#2: Print output to given ouput file
##### Input.csv
    1
    2
    3
    4
    5
    66
    666
#### Expected input:
    *****Exchange System*****
    Please select mode:
    1) User input
    2) File input to [console||output file]
    3) File input to [console||output file] and Store to SQL Database
    4) Read all data store inside SQL Database
    5) Quit
    $2
    *** Mode #2 ***
    Please enter names of input file and [Option] output file: $input.csv output.csv
#### Expected output:
##### Output.csv
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0


### Example Mode#3: Print output to console and store into SQL Database
##### Input.csv
    1
    2
    3
    4
    5
    66
    666
#### Expected input:
    *****Exchange System*****
    Please select mode:
    1) User input
    2) File input to [console||output file]
    3) File input to [console||output file] and Store to SQL Database
    4) Read all data store inside SQL Database
    5) Quit
    $3
    *** Mode #3 ***
    Please enter names of input file and [Option] output file: $input.csv
#### Expected output:
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0
##### SQL DataBase: "data" Table
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0

### Example Mode#3: Print output to given ouput file and store into SQL Database
##### Input.csv
    1
    2
    3
    4
    5
    66
    666
#### Expected input:
    *****Exchange System*****
    Please select mode:
    1) User input
    2) File input to [console||output file]
    3) File input to [console||output file] and Store to SQL Database
    4) Read all data store inside SQL Database
    5) Quit
    $3
    *** Mode #3 ***
    Please enter names of input file and [Option] output file: $input.csv output.csv
#### Expected output:
##### Output.csv
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0  
    

##### SQL DataBase: "data" Table
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0

### Example Mode#4:SQL Database is empty
#### Expected input:
    *****Exchange System*****
    Please select mode:
    1) User input
    2) File input to [console||output file]
    3) File input to [console||output file] and Store to SQL Database
    4) Read all data store inside SQL Database
    5) Quit
    $4
#### Expected output:
    >

### Example Mode#4:SQL Database not empty
##### SQL DataBase: "data" Table
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0

#### Expected input:
    *****Exchange System*****
    Please select mode:
    1) User input
    2) File input to [console||output file]
    3) File input to [console||output file] and Store to SQL Database
    4) Read all data store inside SQL Database
    5) Quit
    $4
#### Expected output:
    1 4 4 0 0 0

    2 8 8 0 0 0

    3 12 12 0 0 0

    4 16 16 0 0 0

    5 20 20 0 0 0

    66 264 264 0 0 0

    666 2664 2664 0 0 0

