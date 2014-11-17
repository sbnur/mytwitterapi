package org.mytwitterapi;

import org.mytwitterapi.auth.Authorization;
import org.mytwitterapi.auth.AuthorizationFactory;
import org.mytwitterapi.conf.Configuration;
import org.mytwitterapi.conf.ConfigurationFactory;
import org.mytwitterapi.conf.PropertyConfiguration;
import org.mytwitterapi.conf.PropertyConfigurationFactory;

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
