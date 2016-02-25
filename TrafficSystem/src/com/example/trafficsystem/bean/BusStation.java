package com.example.trafficsystem.bean;

public class BusStation {
	
	
	private Environment envir;
	private Bus bus1;
	private Bus bus2;
	
	
	
	
	public BusStation(Bus bus1, Bus bus2) {
		super();
		this.bus1 = bus1;
		this.bus2 = bus2;
	}

	public Bus getBus1() {
		return bus1;
	}
	
	public Bus getBus2() {
		return bus2;
	}

	public Environment getEnvir() {
		return envir;
	}

	public void setEnvir(Environment envir) {
		this.envir = envir;
	}
	
	
	
}
