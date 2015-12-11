package com.noah.manage.util;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;

public class InitES{
	private static JestClient client;
	 
    private InitES() {
    }
 
    public  static JestClient getClient() {
        if (client == null) {
        	synchronized(InitES.class){
        		if(client==null){
        			// Construct a new Jest client according to configuration via factory
        	    	String connectionUrl = "http://localhost:9200/";
        	    	JestClientFactory factory = new JestClientFactory();
        	    	factory.setHttpClientConfig(new HttpClientConfig
        	    	       .Builder(connectionUrl)
        	    	       .multiThreaded(true)
        	    	       .build());
        	    	client = factory.getObject();
        		}
        	}
        }
        return client;
    }
 
}