package com.q1;


public class TestOneQ9 implements Runnable {

public static void main (String[] args) throws Exception 
{
 Thread t = new Thread(new TestOneQ9());

 t.start();
 System.out.print("Started");

 t.join();
 System.out.print("Complete");

 }
 public void run() 
{
 for (int i= 0; i< 4; i++) {
System.out.print(i);
 }
 }

{

}
}


//E. The code executes and prints “Started0l23Complete”.