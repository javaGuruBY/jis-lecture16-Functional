package by.jrr.functional;

import java.util.function.*;

public class Interfaces {
    static Runnable runnable = () -> System.out.println("hello");
    static Supplier<String> supplier;
    static Consumer<String> consumer = System.out::println;
    static Function<String, Long> function = Long::valueOf;
    static BiFunction<Integer, Integer, String> biFunction = (a, b) -> String.valueOf(a * b) ;
    static UnaryOperator<String> unaryOperator;
    static Predicate<String> predicate;

    public static void main(String[] args) {
        consumer.accept("Hello worrld");
        function.apply("43");
        consumer.accept(biFunction.apply(4, 5));
    }
}
