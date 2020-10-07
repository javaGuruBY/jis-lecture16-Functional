package by.jrr.functional.factoryservice;

import java.util.function.Supplier;

public class FactorySuplier {
    public static void main(String[] args) {
        Supplier<String> stringMyFactory = () -> "Maxim";
        Supplier<Double> doubleMyFactory = () -> 42.0;

        String result = stringMyFactory.get();
        Double resultD = doubleMyFactory.get();
    }
}
