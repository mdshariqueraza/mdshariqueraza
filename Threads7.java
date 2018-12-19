package com.q1;

public class Threads7 extends Thread {
	
		public void run() 
		{
		System.out.println("run");

		 throw new RuntimeException("Problem");

		}

		 public static void main(String[] args) 
		{
		Thread t = new Thread(new Threads7());

		 t.start();
		System.out.println("End of method.");
		
		 }
		
}
