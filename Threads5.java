package com.q1;

public class Threads5 {
	 public static void main (String[] args) {

	 new Thread(new Runnable() 
	 {
	 public void run() 
	 {
	System.out.print("bar");
	}}).start();

	}
}


//C. The code executes normally and prints “bar”.


