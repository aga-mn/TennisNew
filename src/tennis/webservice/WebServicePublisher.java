package tennis.webservice;

import javax.xml.ws.Endpoint;


public class WebServicePublisher{

	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8888/tennisWEB/dupa", new WebServiceImpl());
    }

}