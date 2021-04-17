package howto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
基本的な流れ
1. コレクションからstreamを取得
2. streamに対して満足するまで「中間操作」を実行。コレクションの中身を都合よく変換
3. 「終端操作」で変換したコレクションの中身に対して処理を適用する

Ref: https://qiita.com/takumi-n/items/369dd3fcb9ccb8fcfa44
*/


public class StreamApi {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        //ex3();
        exFilter();
        //exMap();
        //exSort();
    }

    private static void ex1() {
        // Stream APIを使わない場合
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer i : integerList) {
            if (i % 2 == 0) {
                System.out.println(i);  // prints 2 4
            }
        }
    }

    private static void ex2() {
        // StreamAPIを使う場合
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream()                          // streamの取得 (始端)
                .filter(i -> i % 2 == 0)              // 中間操作 (２で割ったらあまりが0になるものだけほしい)
                .forEach(i -> System.out.println(i)); // 終端操作　(１つずつ画面に出力する) prints 2 4
    }

    private static void ex3() {
        // Same as ex2 above; more verbose
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);   // Turn a list into a stream
        Stream<Integer> stream = integerList.stream();              // streamの取得 Source (Extract)
        Stream<Integer> stream2 = stream.filter(i -> i % 2 == 0);   // 中間操作     Transform (Transform)
        stream2.forEach(i -> System.out.println(i));                // 終端操作     Sink (Load)
    }

    // Filter = Select elements that meet the filter condition
    // e.g. select even numbers only
    private static void exFilter() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream() // streamの取得
                .filter(i -> i % 2 == 0) // 中間操作
                .forEach(i -> System.out.println(i)); // 終端操作  prints 2 4
    }

    // Map = apply transform to elements in the upstream and send the element downstream
    // e.g. multiple each element by 2, then change it to a string
    private static void exMap() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream()                           // streamの取得
                .map(i -> i * 2)                       // 中間操作
                .map(i -> "要素は" + i + "です")         // 中間操作
                .forEach(i -> System.out.println(i));  // 終端操作

        Dog dog = new Dog();
        Cat cat = new Cat();
        Elephant elephant = new Elephant();
        List<Animal> animalList = Arrays.asList(dog, cat, elephant);
        animalList.stream()                               // Get stream of Animals
                .map(animal -> animal.getCry())           // Input=Stream of Animals, Output = Stream of Strings
                .forEach(cry -> System.out.println(cry)); // 終端操作 (print each string)
    }

    private static void exSort() {
        List<Integer> integerList = Arrays.asList(3, 2, 1, 4, 5);
        integerList.stream() // streamの取得
                .sorted((a, b) -> Integer.compare(a,b)) // 中間操作 sort dictionary order
                .forEach(i -> System.out.print(i)); // 終端操作 prints 12345

        System.out.println();
        integerList.stream() // streamの取得
                .sorted((a, b) -> Integer.compare(b,a)) // 中間操作 sort reverse dictionary order
                .forEach(i -> System.out.print(i)); // 終端操作 prints 54321

        System.out.println();
        integerList.stream() // streamの取得
                .sorted(Comparator.reverseOrder()) // 中間操作    sort reverse dictionary order
                .forEach(i -> System.out.print(i)); // 終端操作 prints 54321
    }

}

interface Animal {
    public String getCry();    // 鳴き声を取得  interface method does not have a body
}

class Dog implements Animal {
    public String getCry() {
        return "bow-wow";
    }
}

class Cat implements Animal {
    public String getCry() {
        return "meow";
    }
}

class Elephant implements Animal {
    public String getCry() {
        return "trumpet";
    }
}
