package asrith4444.receiver;

import java.util.*;
import com.amazonaws.services.sqs.model.Message;

public class MailSender {

	public static void main(String[] args)
	{
		//Main Goal is to receive message from the Queue and send an email to the mail id listed in the message.
		Scanner scanner = new Scanner(System.in);
		
		//Ask for Queue Name to receive the message from Queue
		System.out.println("Enter Queue name to receive messages : ");
		String queueName=scanner.next();
		scanner.close();// we don't use it anymore.
		
		try {
			MessageReceiver mr= new MessageReceiver(queueName);
			/*
			 * I know that the message I receive will be in the form of mailID;Subject of Mail;Body of Mail.
			 * So, I'm split the message with ";" (you can seperate with your own special character)
			 * And storing the all mailIDs in To list and Subjects in Sub list and Bodys in Body list.
			 * 
			 */
			List<Message> messages=mr.receiveMessages();
			//I'm using the lists to store the data, you can use arrays too.
			List<String> To=new ArrayList<String>();		//List for To mail addresses
			List<String> Sub=new ArrayList<String>();		//List for Subjects of mails
			List<String> Body=new ArrayList<String>();		//List for body of mails
			
			//If the messages in the Queue are not empty then send mails.
			if(messages.size()>0) {
				System.out.println("\nMessages from Queue");
				for(Message m:messages) {
					String[] data=m.getBody().split(";");
					//Stores data into the list.
					To.add(data[0]);
					Sub.add(data[1]);
					Body.add(data[2]);
					System.out.println(m.getBody());
				}
				//Using SendEmail class to send mails.
				SendEmail se=new SendEmail();
				for(int i=0;i<To.size();i++) {
					se.sendMail(To.get(i),Sub.get(i),Body.get(i));
				}
			}
			else {
				System.out.println("No messages to send mail.");
			}
		}
		catch(Exception e) {
			System.out.println("Entered Queue name doesn't exist.");
		}
		System.out.println("\nEnd Of The Program.");
	}
}
