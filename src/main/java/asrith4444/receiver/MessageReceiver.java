package asrith4444.receiver;

import com.amazonaws.services.sqs.*;
import com.amazonaws.services.sqs.model.*;
import java.util.*;

public class MessageReceiver extends AwsClientInitializer {
	//With the help of AmazonSQS object we perform actions on SQS Services.
	AmazonSQS amazonSQSClient;
	//To perform Queue operations we need Queue URL.
	String queueURL="";
	@SuppressWarnings("deprecation")
	public MessageReceiver(String queueName) {
		//Call base class consrtuctor to read the credentials in our .aws directory
		super();
		//get credentials from base class and assign it to AmazonSQS object
		amazonSQSClient = new AmazonSQSClient(getCredentials());
		amazonSQSClient.setRegion(region);
		queueURL=getQueueURL(queueName);
	}
	//Receive the Messages from Queue
	public List<Message> receiveMessages() {
		seperator("Receiving Messages from Queue");
		ReceiveMessageRequest request = new ReceiveMessageRequest(queueURL);
		request.withMaxNumberOfMessages(10);   //lets get the maximum of 10 messages from the Queue
		ReceiveMessageResult response = amazonSQSClient.receiveMessage(request);
		List<Message> messages = response.getMessages();
		//I want to delete the messages after I received them.
		//If you don't want to delete you can comment below 3 lines
		for (Message message : messages) {
			deleteMessage(message);
		}
		return messages; // returns a list of messages, the list size is between 0 and 10.
	}
	//Delete the message
	private void deleteMessage(Message message) 
	{
		String receiptHandle = message.getReceiptHandle();
		DeleteMessageRequest deleteMessageRequest = new DeleteMessageRequest(queueURL, receiptHandle);
		amazonSQSClient.deleteMessage(deleteMessageRequest);
	}
	//Get the Queue URL.
	private String getQueueURL(String queueName) {
		GetQueueUrlResult response = amazonSQSClient.getQueueUrl(queueName);
		return response.getQueueUrl();
	}
	
}
