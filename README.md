# Floow

## Project

   This project is written with Maven for building tool, so is very simple import the 
   project inside a Eclipse. 
   
   I Used in my Notebook this 2 product :
          - Filezilla FTP server
          - MongoDB 

## Instruction 

 Some warning : 
 1) I decide to implements 2 way of execution :
      - Read file from local drive and i using conventional Path "C:/Floow/local/"
      - Read file from remote FTP connection with user (present inside arguments) and
        password equals of name of user
        
 2) For every execution i active a Thread with the name of Server. 
 
 
## Test Executed 
 1) First Test with a very small file with 3 line 
    Command i Doing :
    java -jar floow-0.0.1-SNAPSHOT-jar-with-dependencies.jar -source prova.txt -mongo localhost:27017 -id local localhost/user Daniele
    
       
 2) I Used, in local machine, the Dump file of wikipedia.
 
 I attached in the project 2 Jpg file with a Example of Execution and MongoDB Result.
 
### Create Jar Runnable 
   
   For create Runnable jar simple : click on file pom.xml select mvn build with goal : assembly:single 
   
### Command accepted for execution :
 java -jar floow-0.0.1-SNAPSHOT-jar-with-dependencies.jar -source nameFIle -mongo mogoHostname:mongoPort -id nameServer NomeHost/userName stringToSearch
 
 Where in my local Example : 
 -nameFile : prova.txt (with a 2 or 3 line with a right string to search)
 -mongoHostname : localhost (i have on notebook installed MongoDB
 -mongoPort : 27017 (Std port of mongo)
 -nameServer : local (to find file inside "C:/Floow/local/")  other name for connected in FTP with a serverFTP
 -NomeHost : localhost (in local) server IpAdress for connect in FTP
 -userName : user FTP valid with password = userName
 -stringToSearch : string to search inside file
  
  PS. Excuse me for many mistake i did with this note.... I'm Italian and sometime i using 
      italian grammatic for write the sentence!! :-)))