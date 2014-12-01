package mytwitterapi;

import mytwitterapi.auth.Authorization;
import mytwitterapi.auth.AuthorizationFactory;
import mytwitterapi.conf.Configuration;
import mytwitterapi.conf.ConfigurationFactory;
import mytwitterapi.conf.PropertyConfiguration;
import mytwitterapi.conf.PropertyConfigurationFactory;

public class App {
	public static void main(String[] args){
		System.out.println("App...");
		ConfigurationFactory configurationFactory = new PropertyConfigurationFactory();
		Configuration conf = configurationFactory.getInstance();
		System.out.println(conf.isDebugEnabled());
		
		Authorization  authorization = AuthorizationFactory.getInstance(conf);
		
		TwitterFactory factory = new TwitterFactory();
		
		Twitter twitter = factory.getInstance();
		
		try {
			System.out.println("Screen name: " + twitter.getScreenName());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int foo = 0;
	}
}
