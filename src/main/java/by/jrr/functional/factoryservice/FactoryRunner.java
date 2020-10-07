package by.jrr.functional.factoryservice;

import by.jrr.functional.threading.MyRunnable;

public class FactoryRunner {
    public static void main(String[] args) {
        MyFactory<String> stringMyFactory = () -> "Maxim";
        MyFactory<Double> doubleMyFactory = () -> 42.0;

        String result = stringMyFactory.make();
        Double resultD = doubleMyFactory.make();
    }


}
