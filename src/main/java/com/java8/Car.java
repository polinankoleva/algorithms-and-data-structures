package com.java8;

public interface Car {

	// default implementation of methods
	public default void print() {
		System.out.println("I am a car");
	}
	
	// static methods of an interface
	public static void car() {
		System.out.println("Static method I am a car!");
	}
}
