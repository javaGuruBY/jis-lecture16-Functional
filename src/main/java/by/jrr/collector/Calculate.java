package by.jrr.collector;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculate {

    public static Map<String, Long> wordStatistic(String sentence) {
        String[] strings = sentence.split(" ");
        Map<String, Long> result = Arrays.stream(strings)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return result;
    }
}
