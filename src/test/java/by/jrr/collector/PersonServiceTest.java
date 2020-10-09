package by.jrr.collector;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.jrr.stream.StreamSytax.logInfo;
import static org.junit.Assert.*;

public class PersonServiceTest {

    List<Person> persons;


    @Before
    public void setup() {
        persons = Arrays.asList(
                new Person("vlad", 23),
                new Person("max", 32),
                new Person("dima", 23),
                new Person("bob", 54),
                new Person("bob", 60)
        );
    }


    @Test
    public void mapToCollection() {
        List<String> result1 = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        List<String> result2 = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(LinkedList::new));

        Set<String> result3 = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Test
    public void mapToString() {
        String result1 = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining());
        logInfo(result1);
        assertEquals("vladmaxdimabobbob", result1);

        String result2 = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        logInfo(result2);
        assertEquals("vlad, max, dima, bob, bob", result2);

        String result3 = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "{", "}"));
        logInfo(result3);
        assertEquals("{vlad, max, dima, bob, bob}", result3);
    }

    @Test(expected = IllegalStateException.class) //Duplicate key bob (attempted merging values 54 and 60)
    public void mapToMapEx() {
        Map<String, Integer> result1 = persons.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
    }

    @Test
    public void mapToMapWithDuplicate1() {
        Map<String, Integer> result1 = persons.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        (existing, replacement) -> existing));
        Map<String, Integer> actual = new HashMap<>();
        actual.put("vlad", 23);
        actual.put("max", 32);
        actual.put("dima", 23);
        actual.put("bob", 54);

        assertEquals(actual, result1);
        logInfo(result1);
    }

    @Test
    public void mapToMapWithDuplicate2() {
        Map<String, Integer> result1 = persons.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        (existing, replacement) -> replacement));
        Map<String, Integer> actual = new HashMap<>();
        actual.put("vlad", 23);
        actual.put("max", 32);
        actual.put("dima", 23);
        actual.put("bob", 60);

        assertEquals(actual, result1);
        logInfo(result1);
    }

    @Test
    public void mapToMapWithDuplicate3() {
        Map<String, Integer> actual = new HashMap<>();
        actual.put("vlad", 23);
        actual.put("max", 32);
        actual.put("dima", 23);
        actual.put("bob", 60);

        Map<String, Integer> result1 = persons.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        (existing, replacement) -> replacement));


        assertEquals(actual, result1);
        logInfo(result1);
    }

    @Test
    public void mapToMapWithDuplicateAndSpecifyMap() {
        Map<String, Integer> result1 = persons.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        PersonService::saveYoungest,
                        TreeMap::new));
        Map<String, Integer> actual = new HashMap<>();
        actual.put("vlad", 23);
        actual.put("max", 32);
        actual.put("dima", 23);
        actual.put("bob", 54);

        assertEquals(actual, result1);
        logInfo(result1);
    }

    @Test
    public void mapToMapWithEntities() {
        Map<String, Person> actual = new HashMap<>();
        actual.put("vlad", new Person("vlad", 23));
        actual.put("max", new Person("max", 32));
        actual.put("dima", new Person("dima", 23));
        actual.put("bob", new Person("bob", 54));

        Object result1 = persons.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Function.identity(),
                        PersonService::saveYoungest,
                        TreeMap::new));

        assertEquals(actual, result1);
        logInfo(result1);
    }

    @Test
    public void findMaxComparingByAge() {
        var oldest = new Person("bob", 60);

        Optional<Person> result = persons.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));

        assertEquals(oldest, result.get());
    }

    @Test
    public void statistic() {
        double expectedAverageAge = 38.4;
        int expectedSumOfAges = 192;

        Double result1 = persons.stream()
                .collect(Collectors.averagingInt(Person::getAge));

        int result2 = persons.stream()
                .collect(Collectors.summingInt(Person::getAge));

        IntSummaryStatistics result3 = persons.stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        assertEquals(expectedAverageAge, result1, 0);
        assertEquals(expectedSumOfAges, result2);
        logInfo(result1);
        logInfo(result2);
        logInfo(result3);
        logInfo(result3.getCount());
    }

    @Test
    public void grouping() {
        Map<Boolean, List<Person>> result = persons.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 35));
        logInfo(result);

        Map<Boolean, List<Person>> result1 = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getAge() > 35));
        assertEquals(result, result1);
        logInfo(result1);

        Map<String, Long> result2 = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        logInfo(result2);

        Map<String, Long> result3 = Calculate.wordStatistic("max max bob strem");
        logInfo(result3);

        Map<String, List<String>> result4 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.mapping(
                                p -> String.format("%s %s", p.getAge(), p.getName()),
                                Collectors.toList())));
        logInfo(result4);

        Map<String, IntSummaryStatistics> result5 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.summarizingInt(
                                Person::getAge)));
        logInfo(result5);
    }


    @Test
    public void parallelStream() {
        Stream<Person> singlePersons = Arrays.asList(
                new Person("vlad", 23),
                new Person("max", 32),
                new Person("dima", 12),
                new Person("bob", 54),
                new Person("bob", 54)
        ).stream();

        assertFalse(singlePersons.isParallel());
        singlePersons.parallel();
        assertTrue(singlePersons.isParallel());

        Stream<Person> parallelPersons = Arrays.asList(
                new Person("vlad", 23),
                new Person("max", 32),
                new Person("dima", 12),
                new Person("bob", 54),
                new Person("bob", 54)
        ).parallelStream();

        assertTrue(parallelPersons.isParallel());
    }
}
