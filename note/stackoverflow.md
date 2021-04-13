# What is a stack

The execution of a computer program is basically a sequence of program instruction and data

For example, instruction x starts instruction y, and instruction y then starts instruction z and provide it with a string parameter of "http://www.google.com/"

This sequence of instruction and data is stored in the stack.

The stack is part of the OS memory, and is limited in size.  e.g. 1GB

We can look at something called a stack trace to get a sense of what the stack looks like.

For example, this link contains a few stack trace examples: https://developer.android.com/studio/debug/stacktraces

# What is a stack overflow?

Since the stack is a limited memory space, when it is full and filled up with execution instructions, it can't store any execution any more.
When it is full and a new execution is added to the stack, it results in an overflow known as stack overflow.


# Stack Overflow Examples

## A method repeatedly calling itself infinitely.

In this example, when an instance of SpaceShip calls its accelerate(), accelerate() will call its own accelerate().
This results in this.accelerate() calling this.accelerate() repeatedly, resulting in an endless loop.
The stack will be filled up with a long trace of repeated this.accelerate() calls very quickly.

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
// The following falcon.accelerate() will end up calling falcon.accelerate() again based on the definition above.
// Every call generates another new call to itself, resulting in an infinite loop.
falcon.accelerate();

```

## Circular Reference

Like Ying and Yang, complementing each other infinitely in a circle.

Let's say method A is defined to call method B, and method B is defined to call method A.
When method A is executed, method A and method B will end up calling each other repeatedly.
This is like two mirrors facing and looking at each other (i.e. [infinite reflection](https://www.google.com/search?q=mirror+infinite+reflection&tbm=isch)) or two players doing an endless ping pong rally.  ヽ(^o^)ρ┳┻┳°σ(^o^)/ 

# Real-life Examples

- [A real stackoverflow bug in JDK](https://bugs.openjdk.java.net/browse/JDK-8214129)

# Reference

[java.lang.StackOverflowError – How to solve StackOverflowError](https://www.youtube.com/watch?v=kYAyEQEcTVI)
