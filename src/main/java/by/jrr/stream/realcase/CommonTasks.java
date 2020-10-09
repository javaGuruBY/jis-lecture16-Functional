package by.jrr.stream.realcase;

import by.jrr.stream.StreamSytax;

import java.util.*;
import java.util.stream.Collectors;

public class CommonTasks {

    public List<String> collectNamesIntoList(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public Set<String> collectNamesOrderedDistinct(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Double computeSumOfSalaries(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
    }

    public String getNames(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
    }

    public Map<Department, List<Employee>> groupByDepartments(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<Department, Double> groupByDepartmentsAndComputeSalaries(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
    }

    public Map<Boolean, List<Employee>> divideJuneNonJune(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getLevel() > 1));
    }

    public void getSkillsWithL3(List<TShapeEmployee> employeeList) {
        List<String> result = employeeList.stream()
                .map(e -> e.getSkillMap().entrySet())
                .peek(e -> StreamSytax.logInfo("1 map get matrix: " + e))
                .flatMap(set -> set.stream())
                .peek(e -> StreamSytax.logInfo("2 flatMap stream: " + e))
                .filter(s -> s.getValue() > 2)
                .peek(e -> StreamSytax.logInfo("3 filter >2: " + e))
                .map(s -> s.getKey())
                .peek(e -> StreamSytax.logInfo("4 map get Names: " + e))
                .distinct()
                .peek(e -> StreamSytax.logInfo("5 distinct leave non duplicates: " + e + "\n"))
                .collect(Collectors.toList());
    }


}
