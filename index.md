## Welcome to SQS Demo Application

The purpose of this java application is to perform the Amazon AWS Simple Queue Service operations in Java application.
In this application my task is to send messages to queue from the java program and receiving the message from another java program(probably work in any device). 
Along with that, I'm sending mail to the mail IDs that I'm received from the queue.
What I'm doing is, 
I'm sending a message to queue in the form of asrithvejandla@gmail.com;Subject of the mail;Body of the mail.
While receiving this message from queue I'm spliting the message with ";" so that now I send mail to the asrithvejandla@gmail.com

### Objectives
By using this Java Application, One can create a queue, send a message to queue, receive a message from queue, delete a message in the queue and sending email.

### Requirements for this Application
- Eclipse IDE for Java Developers
- Amazon AWS Tool kit
- Java Mail dependency
- Turn On the less secure access in gmail
- Change the mailID and password in the details.txt

### 1.Eclipse IDE for Java Developers
Download it from [here](https://www.eclipse.org/downloads/packages/)

### 2.Amazon AWS Tool Kit
**Steps to Install Amazon AWS Tool Kit in Eclipse IDE**
- Open Eclipse IDE
- Go to HELP Section
- Click on Marketplace
- Search for Amazon AWS Tool Kit
- Install it
- Now you can see an Orange cube in the top-middle of the IDE
- Click on it, choose preferences
- Save your AWS Profile here.
- Apply and close

### 3.Java Mail Dependency
```markdown
Paste the below code in the POM.XML file

` <dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.2</version>
  </dependency>`

```
### 4.Turn On the Less secure app acess
You can click on this [link](https://myaccount.google.com/lesssecureapps) and turn it on.

### 5.Change the mailID and password in the details.txt
In **package asrith4444.receiver** there is a file named as details.txt which contains Email ID and its password. Replace those values with your details. Remeber, email ID is in 1st line and password in 2nd line.

#### By completing the above requirements you can start the project. Do not forget to read [**README.md**](https://github.com/asrith4444/SQSDemoApplication/)
