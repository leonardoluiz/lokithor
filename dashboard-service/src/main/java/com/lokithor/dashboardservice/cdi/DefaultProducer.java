package com.lokithor.dashboardservice.cdi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped	
public class DefaultProducer {
	
	@Produces
	public Properties provideServerProperties() {
	    Properties p = readProperties("dashboard.properties");
	    return p;
	}
	
	private Properties readProperties(String fileInClasspath) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileInClasspath);
        
        try {
            Properties properties = new Properties();
            properties.load(is);
            return properties;
        } catch (IOException e) {
            System.err.println("Could not read properties from file " + fileInClasspath + " in classpath. " + e);
        }
        
        return null;
    }

}
