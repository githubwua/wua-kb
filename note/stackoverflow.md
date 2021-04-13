# What is a stack

The execution of a computer program is basically a sequence of program instruction and data

For example, instruction x starts instruction y, and instruction y then starts instruction z and provide it with a string parameter of "http://www.google.com/"

This sequence of instruction and data is stored in the stack.

The stack is part of the OS memory, and is limited in size.  e.g. 1GB

We can look at something called a stack trace to get a sense of the stack looks like.

This link contains a few stack trace examples: https://developer.android.com/studio/debug/stacktraces

# What is a stack overflow?

Since the stack is a limited memory space, when it is full and filled up with execution instructions, it can't store any execution any more.
When it is full and a new execution is added to the stack, it results in an overflow known as stack overflow.


# Stack Overflow Examples

## A method repeatedly calling itself infinitely.

In this example, when an instance of SpaceShip calls its accelerate(), accelerate() will call its own accelerate().
This results in this.accelerate() calls this.accelerate() repeatedly, resulting in an endless loop.
The stack will fill up with a long history of repeated this.accelerate()

```
// Source: https://stackoverflow.com/questions/3197708/what-causes-a-java-lang-stackoverflowerror

public class Vehicle {
    public void accelerate(float acceleration, float maxVelocity) {
        // set the acceleration
    }
}

public class SpaceShip extends Vehicle {
    @Override
    public void accelerate(float acceleration, float maxVelocity) {
        // update the flux capacitor and call super.accelerate
        // oops meant to call super.accelerate(acceleration, maxVelocity);
        // but accidentally wrote this instead. A StackOverflow is in our future.
        this.accelerate(acceleration, maxVelocity); 
    }
}

SpaceShip falcon = new SpaceShip();
falcon.accelerate();  // falcon.accelerate() calls falcon.accelerate().  Every call generates another new call, resulting in an infinite loop.

```

## Circular Reference

Method A is defined to call method B, and method B is defined to call method A.
When method A is executed, method A and method B will end up calling each other repeatedly.
This is like two mirrors looking at each other.  Or a perfect tennis rally that never ends.

Here is a real-life example:

https://bugs.openjdk.java.net/browse/JDK-8214129

