package com.example.trafficsystem.bean;

public class Bus extends Car {

	
	private int peopleNumber;
	private float distanceTo1;
	private float distanceTo2;
	
	

	public Bus(int id) {
		super(id);
	}
	



	public int getPeopleNumber() {
		return peopleNumber;
	}


	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}


	public float getDistanceTo1() {
		return distanceTo1;
	}


	public void setDistanceTo1(float distanceTo1) {
		this.distanceTo1 = distanceTo1;
	}


	public float getDistanceTo2() {
		return distanceTo2;
	}


	public void setDistanceTo2(float distanceTo2) {
		this.distanceTo2 = distanceTo2;
	}



	
}
