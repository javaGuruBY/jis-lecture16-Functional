package by.jrr.collector;

public class PersonService {

    //decision on duplicates when collect to map

    public static int saveYoungest(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static int saveOldest(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static Person saveYoungest(Person a, Person b) {
        if (a.getAge() < b.getAge()) {
            return a;
        } else {
            return b;
        }
    }

    public static Person saveOldest(Person a, Person b) {
        if (a.getAge() > b.getAge()) {
            return a;
        } else {
            return b;
        }
    }


}
