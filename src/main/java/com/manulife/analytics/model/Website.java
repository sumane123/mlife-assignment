package com.manulife.analytics.model;

import java.math.BigInteger;
import java.util.Date;

public class Website {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getVisits() {
		return visits;
	}
	public void setVisits(BigInteger visits) {
		this.visits = visits;
	}
	private String name; 
    private BigInteger visits;
   
}
