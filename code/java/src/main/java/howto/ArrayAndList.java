package howto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayAndList {

    public static void main(String[] args) {

        //ex1();  // Array
        ex2();  // List
        //ex3();

    }

    private static void ex1() {
        // declare an array without initialization
        String[] string1 = new String[100]; // 100 nulls

        // declare an array with initialization
        String[] string2 = new String[]{"first-arg", "second-arg"};  // 2 strings
        String[] string3 = {"Hello", "World", "!!"};  // 3 strings

        String[] x = string2;  // try string1 , string2, string3

        System.out.println(x[0]);  // print lst element in the array

        // Print all elements in the array
        for (String s:x) {
            System.out.println(s);
        }
    }

    private static void ex2() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(49);
        integerList.add(76);
        integerList.add(33);
        integerList.add(1);
        integerList.remove(1);  // remove 2nd element, which is 76. index starts from 0.
        System.out.println(integerList.contains(1));  //true
        System.out.println(integerList.size());       // 3

        // go through each element in the list
        for (Integer i : integerList) {
            System.out.println(i);
        }

        // another way to go through each element in the list
        for(Iterator it = integerList.iterator(); it.hasNext();) {
          System.out.println(it.next());
        }
    }

    /*
    Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.AbstractList.add(AbstractList.java:153)
	at java.base/java.util.AbstractList.add(AbstractList.java:111)
	at howto.ArrayAndList.ex3(ArrayAndList.java:57)
	at howto.ArrayAndList.main(ArrayAndList.java:14)
     */
    private static void ex3() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.add(99);  // this will fail
    }

}
