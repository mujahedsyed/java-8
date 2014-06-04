package org.mujahed.examples.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer Function Example
 * Created by mujahed on 04/06/2014.
 */
public class ConsumerFunEx {

    public static void main(String[] args){
        Consumer<Integer> consumer = (Integer i) -> System.out.println(i);

        forEach(Arrays.asList(1, 2, 3, 4, 5), consumer);
    }

    public static <T> void forEach(List<T> list, Consumer consumer){
        for(T t: list){
            consumer.accept(t);
        }
    }
}
