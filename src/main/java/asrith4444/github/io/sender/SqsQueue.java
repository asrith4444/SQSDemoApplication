package asrith4444.github.io.sender;

import com.amazonaws.services.sqs.*;
import com.amazonaws.services.sqs.model.*;
import java.util.*;

public class SqsQueue extends AwsClientInitializer {
	String awsUserID="";			//We need this for providing permissions to Queue
	AmazonSQS amazonSQSClient;		//With the help of AmazonSQS object we perform actions on SQS Services.
	@SuppressWarnings("deprecation")
	public SqsQueue(String awsUserID) {
		//Call base class consrtuctor to read the credentials in our .aws directory
		super();
		//get credentials from base class and assign it to AmazonSQS object
		amazonSQSClient = new AmazonSQSClient(getCredentials());
		amazonSQSClient.setRegion(region); //Set the region
		this.awsUserID=awsUserID;
	}
	 
	//Create a queue with queue name
	public String createQueue(String queueName) {
		CreateQueueRequest request = new CreateQueueRequest(queueName);
		CreateQueueResult response = amazonSQSClient.createQueue(request);
		seperator("Queue Created");
		return response.getQueueUrl();
	}
	//To add the permissions to our queue
	public void addPermission(String queueUrl) {
		AddPermissionRequest request = new AddPermissionRequest();
		request.setQueueUrl(queueUrl);
		//Set the actions to perform
		request.setActions(getActions());
		//Set the AWS User IDs to this Queue
		request.setAWSAccountIds(getAWSAccountIds());
		//Set a label for this permissions
		request.setLabel("SQSPermissionfromSDK");
		amazonSQSClient.addPermission(request);
	}
	//Get the AWS account IDs through this method.
	private List<String> getAWSAccountIds() {
		List<String> awsAccountIdsList = new ArrayList<String>();
		//In my case I'm adding only one Account ID/User ID
		awsAccountIdsList.add(awsUserID);
		return awsAccountIdsList;
	}
	//Get the actions to apply on our Queue.
	private List<String> getActions() {
		List<String> actionsList = new ArrayList<String>();
		//I'm specifying all the actions by *
		actionsList.add("*");
		/*
		 * 	You can specify particular actions if you want
		 * 	actionsList.add("SendMessage");
			actionsList.add("ReceiveMessage");
			actionsList.add("DeleteMessage");
			actionsList.add("ChangeMessageVisibility");
			actionsList.add("GetQueueAttributes");
			actionsList.add("GetQueueUrl");
		 * */
		return actionsList;
	}
	//Sending Message 
	private void sendMessage(String queueURL, String msgBody) {
		seperator("Message Sending");
		amazonSQSClient.sendMessage(queueURL, msgBody);
	}
	//Get the Queue URL by using the Queue Name
	private String getQueueURL(String queueName) {
		seperator("Getting QueueURL");
		GetQueueUrlResult response = amazonSQSClient.getQueueUrl(queueName);
		return response.getQueueUrl();
	}
	
	public static void main(String[] args) 
	{
		//Our Goal is to send messages to our queue
		String queueURL="",queueName="";
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter your AWS Account ID :  ");
		String id=s.nextLine();  //529897170680
		
		//Now we have AWS Account ID. So, lets create an object to our class, to access its methods. 
		SqsQueue q=new SqsQueue(id);
		
		//We need Queue URL to send message. So we either create a Queue or Enter the previous Queue Name for Queue URL
		System.out.println("Do you want to Create a new Queue? \n Enter (y/n) : ");
		String choice=s.nextLine();
		//If "y" create a new Queue else: ask existing Queue Name
		if(choice.toLowerCase().equals("y")) {
			System.out.println("Enter Queue Name ");
			queueName=s.nextLine();
			queueURL=q.createQueue(queueName);
		}
		else {
			System.out.println("Enter the existing Queue Name : ");
			queueName=s.nextLine();
			queueURL=q.getQueueURL(queueName);
		}
		//Now we know the Queue URL, Lets ask for the message body
		System.out.println("Enter your message to send : ");
		String msg=s.nextLine();
		s.close();
		
		//Call sendMessage() to send message to the Queue 
		q.sendMessage(queueURL, msg);
		System.out.println("Message Sent Successfully. ");
	}

}
