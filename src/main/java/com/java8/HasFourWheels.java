package com.java8;

public interface HasFourWheels {

	public default void print() {
		System.out.println("I have four wheels.");
	}
}
