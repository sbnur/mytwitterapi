package org.mytwitterapi.conf;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PropertyConfigurationTest {
	
	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero() {

	   // MyClass is tested
	   PropertyConfiguration tester = new PropertyConfiguration();

	   // Tests
	   assertEquals("consumerKey-test", "consumerKey-test", tester.getOAuthConsumerKey());
	   assertEquals("consumerSecret-test", "consumerSecret-test", tester.getOAuthConsumerSecret());
	   assertEquals("accessToken-test", "accessToken-test", tester.getOAuthAccessToken());
	   assertEquals("accessTokenSecret-test", "accessTokenSecret-test", tester.getOAuthAccessTokenSecret());
	   
	   assertEquals("http.proxyHost", "http.proxyHost-test", tester.getHttpClientConfiguration().getHttpProxyHost());
	   assertEquals("http.proxyPort=9090", 8080, tester.getHttpClientConfiguration().getHttpProxyPort());
	  
	 } 

}

