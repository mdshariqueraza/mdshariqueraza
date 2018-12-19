package com.q1;

public class NamedCounter {
private final String name;
private int count;
public NamedCounter(String name) 
{ this.name = name; 
}

public String getName() 
{ return name; 
}
public void increment()
 { count++;
 }
public int getCount() 
{ return count; }
public void reset() 
{ count = 0; }

}
