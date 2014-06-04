package org.mujahed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        app.process(() -> System.out.println("Lambda World!"));

        String oneLine = app.processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println("First Line: " + oneLine);

        List<String> list = new ArrayList<>();
        list.add("Mujahed");
        list.add("Syed");
        list.add("");
        list.add("Ali");
        // use of test method in predicate example
        Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();
        List<String> nonEmptyList = filter(list, nonEmptyString);

        System.out.println("Size of the list: "+nonEmptyList.size()+", Contents of the string:");
        for(String s: nonEmptyList){
            System.out.println(s);
        }
    }

    public void process(Runnable r) {
        r.run();
    }

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("pom.xml"))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}