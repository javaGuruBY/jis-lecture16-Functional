package by.jrr.stream;

import by.jrr.stream.realcase.Department;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.List.of;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

public class StreamSyntaxTest {

    List<String> names = of("maXim", "tatjana", "olga", "Tolja");

    @Test
    public void collectionIteration() {

        for(int i = 0; i < names.size(); i++) {
            StreamSytax.logInfo(names.get(i));
        }

        for (String name : names) {
            StreamSytax.logInfo(name);
        }

        names.forEach(a -> StreamSytax.logInfo(a));
        names.forEach(StreamSytax::logInfo);

        names.stream().forEach(a -> StreamSytax.logInfo(a));
        names.stream().forEach(StreamSytax::logInfo);
    }

    @Test
    public void streamsBaseSyntax() {
        List<String> result = names;
        result = toLowerCase(names);
        result = filterT(result);
        logResult(result);

        names.stream()
                .map(String::toLowerCase)
                .filter(name -> !name.contains("t"))
                .forEach(StreamSytax::logInfo);

        List<String> collected = names.stream()
                .map(String::toLowerCase)
                .filter(name -> !name.contains("t"))
                .collect(toList());
    }

    private List<String> toLowerCase(List<String> names) {
        List<String> modifiedNames = new ArrayList<>();
        for (String name : names) {
            modifiedNames.add(name.toLowerCase());
        }
        return modifiedNames;
    }

    private List<String> filterT(List<String> names) {
        List<String> modifiedNames = new ArrayList<>();
        for (String name : names) {
            if (name.contains("t")) {
                continue;
            }
            modifiedNames.add(name);
        }
        return modifiedNames;
    }

    private void logResult(List<String> names) {
        for (String name : names) {
            StreamSytax.logInfo(name);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void streamLifeCycle() {
        Stream<Integer> ints = of(1,2,3,4,5,6,7)
                .stream()
                .filter(a -> a > 2 && a < 5)
                .map(e -> 1);
        // stream should be terminated here!

        System.out.println(ints.count());  //antipattern!!!
        ints.forEach(StreamSytax::logInfo); //antipattern!!! eXCEPTION
    }

    @Test
    public void streamGenerate() {
        IntStream.iterate(10, i -> i < 50, i -> i + 3)
                .forEach((e) -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    StreamSytax.logInfo(e);
                });

        IntStream.rangeClosed(4, 10)
                .forEach(StreamSytax::logInfo);
        IntStream.range(4, 10)
                .forEach(StreamSytax::logInfo);
    }

    @Test
    public void boxed() {
        Stream<Double> result = IntStream.rangeClosed(4, 10)
                .mapToDouble(Double::valueOf)
                .boxed();
    }

    @Test
    public void order() {
        Set<Integer> numbers = new LinkedHashSet<>(of(4, 3, 1, 2));
        List<Integer> sameOrder = numbers
                .stream()
                .collect(toList());

        sameOrder.forEach(StreamSytax::logInfo);

        List<Integer> ordered = numbers
                .stream()
                .sorted(Comparator.comparing(Object::hashCode))
                .collect(toList());

        ordered.forEach(StreamSytax::logInfo);
    }
}
