package org.mujahed.examples.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by mujahed on 04/06/2014.
 */
public class FunctionFunEx {

    public static void main(String args[]){
        map(Arrays.asList("Lambda", "in", "Action"), (String s)-> s.length());
    }
    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> f) {
        List<R> returnList = new ArrayList<>();
        for(T t:list){
           returnList.add(f.apply(t));
        }

        return returnList;
    }
}
