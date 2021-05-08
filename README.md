# SQSDemoApplication
In this application my task is to send messages to queue from the java program and receiving the message from another java program(probably work in any device). 
Along with that, I'm sending mail to the mail IDs that I'm received from the queue.
What I'm doing is, 
I'm sending a message to queue in the form of "asrithvejandla@gmail.com;Subject of the mail;Body of the mail."
While receiving this message from queue I'm spliting the message with ";" so that now I send mail to the asrithvejandla@gmail.com

### Understand the Application
Actually this type of application can be done on two different desktops, but I provided the code in two packages one is asrith4444.sender and another one is asrith4444.receiver
In this application we need to access the AWS SQS Services. So, that we need to provide the AWS account credentials to perfom any actions regarding to the AmazonSQS.
Most of the methods are be like creating a request object and provding the request object to the AmazonAWSClient methods and storing the response in the result object.<br/><br/>

#### package asrith4444.sender
In this package it contains two files namely AwsClientInitializer.java and SQSQueue.java.
- AwsClientInitializer.java we provide our account credentials and set the region. It also contains a seperator method.
- SQSQueue.java extends the AwsClientInitializer Class to get the credentials, by using the credentials we perform create queue, add permissions, send message and get queueURL.
- Follow the comments in the code to understand clearly.<br/><br/>

#### package asrith4444.receiver
In this package it contains files like AwsClientInitalizer.java, MessageReceiver.java, MailSender.java, SendEmail.java, Details.java and details.txt.
- We simply copy the AwsClientInitializer from sender package.
- Message reciver extends the AwsClientInitializer class ann perform actions like receive messages from queue, delete the messages from the queue, and get the queueURL.
- I'm used Details class to get the mailID and password from details.txt file. I did this because it contains password, but you can simply ignore this class and directly enter your mailID and password in SendEmail class.
- SendEmail class is used to send the mail to the mailIDs received from the Queue. This class contains just a single method, if you want you can directly include this method in MailSender class.
- MailSender is the Main class of the Receiver package. This class takes Queue name as input and displays the messages of that queue and send emails.
- Follow the comments in the code to understand clearly.<br/><br/>

### Order of execution

#### asrith4444.sender
- AwsClientInitializer.java
- SQSQueue.java<br/><br/>

#### asrith4444.receiver
- AwsClientInitializer.java<br/>
- MessageReceiver.java<br/>
- Add you mail ID and password in details.txt(In 1st line Mail ID and in 2nd line password)<br/>
- Details.java<br/>
- SendEmail.java<br/>
- MailSender.java<br/><br/>

#### Note:
- If you miss reading the requirements you can read here htpps://asrith4444.github.io/SQSDemoApplication.<br/>
- Use Gmail to send the emails. Because I'm used the google as host.<br/>
- Do not forget to Turn On the Less Secure Apps Access. You can change it here https://myaccount.google.com/lesssecureapps<br/>
- You will understand the code clearly with the help of comments. Still having any problem rise an issue.
