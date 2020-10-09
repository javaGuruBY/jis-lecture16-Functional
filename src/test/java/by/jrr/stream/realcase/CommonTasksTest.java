package by.jrr.stream.realcase;

import by.jrr.stream.StreamSytax;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.jrr.stream.StreamSytax.logInfo;
import static org.junit.Assert.*;

public class CommonTasksTest {

    CommonTasks commonTasks;

    @Before
    public void setup() {
        commonTasks = new CommonTasks();
    }

    @Test
    public void collectNamesIntoList() {

    }

    @Test
    public void collectNamesOrderedDistinct() {
        Set<String> result = commonTasks
                .collectNamesOrderedDistinct(EmployeFabric.getEmploye());
        logInfo(result);
    }

    @Test
    public void computeSumOfSalaries() {
        Double result = commonTasks
                .computeSumOfSalaries(EmployeFabric.getEmploye());
        logInfo(result);
    }

    @Test
    public void groupByDepartments() {
        Map<Department, List<Employee>> result = commonTasks
                .groupByDepartments(EmployeFabric.getEmploye());
        logInfo(result);
    }


    @Test
    public void groupByDepartmentsAndComputeSalaries() {
        Map<Department, Double> result = commonTasks
                .groupByDepartmentsAndComputeSalaries(EmployeFabric.getEmploye());
        logInfo(result);
    }

    @Test
    public void divideJuneNonJune() {
        Map<Boolean, List<Employee>> result = commonTasks
                .divideJuneNonJune(EmployeFabric.getEmploye());
        logInfo(result);
    }


    @Test
    public void getSkillsWithL3() {
        commonTasks
                .getSkillsWithL3(EmployeFabric.getTShapeEmploys());

    }

    @Test
    public void peekExcample() {
        Stream.of("one", "two", "three", "four")
                         .filter(e -> e.length() > 3)
                         .peek(e -> System.out.println("Filtered value: " + e))
                         .map(String::toUpperCase)
                         .peek(e -> System.out.println("Mapped value: " + e))
                         .collect(Collectors.toList());
    }
}
