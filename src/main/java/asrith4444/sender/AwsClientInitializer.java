package asrith4444.sender;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
public class AwsClientInitializer {
	private AWSCredentials credentials = null;
	protected Region region;
    
    public AwsClientInitializer() {
    	try {
    		//Get the AWS credentials from C:\Users\DELL\.aws\credentials for windows or ~/.aws/credentials for linux
            credentials = new ProfileCredentialsProvider("default").getCredentials();
			region = Region.getRegion(Regions.US_WEST_2); //Set the region
        } catch (Exception e) {
        	System.out.println(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials[linux] or C:\\Users\\DELL\\.aws\\credentials[windows] ), and is in valid format."+e);
        }
    }
    //Get the credentials
    protected AWSCredentials getCredentials() {
		return credentials;
	}
    //set the credentials if any.
    protected void setCredentials(AWSCredentials credentials) {
		this.credentials = credentials;
	}
    //Seperator from various functions
    protected void seperator(String featureName) {
		System.out.println("+++++++++++++++++++++");
		System.out.println(featureName);
		System.out.println("+++++++++++++++++++++");
	}
}
