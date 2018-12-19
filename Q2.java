package com.q1;

public abstract class Q2 implements Runnable {

void doStuff(){	}

 new Thread() {
public void run() { doStuff(); }
 }

 new Thread() {
public void start() { doStuff(); }
 }


 new Thread() {
public void start() { doStuff(); }
} .run();

D. new Thread() {
public void run() { doStuff(); }
} .start();

 new Thread(new Runnable() {
public void run() { doStuff(); }
} ).run();

new Thread(new Runnable() {
public void run() { doStuff(); }
}).start();
}


	