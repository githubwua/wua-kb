package howto;

// How to make trouble, stress out a system

public class TroubleMaker {
    public static void main(String[] args) {
        //raiseStackOverflowError();
        //raiseOutOfMemoryError();
    }

    /*
    Exception in thread "main" java.lang.StackOverflowError
	at howto.TroubleMaker.raiseStackOverflowError(TroubleMaker.java:12)
	at howto.TroubleMaker.raiseStackOverflowError(TroubleMaker.java:12)
	...
	at howto.TroubleMaker.raiseStackOverflowError(TroubleMaker.java:12)
     */
    public static void raiseStackOverflowError() {
        raiseStackOverflowError();
    }

    /*
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at howto.TroubleMaker.raiseOutOfMemoryError(TroubleMaker.java:15)
	at howto.TroubleMaker.main(TroubleMaker.java:7)
     */
    public static void raiseOutOfMemoryError() {
        int[] a = new int[1024 * 1024 * 1024];
    }

}
