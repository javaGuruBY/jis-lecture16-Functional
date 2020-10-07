package by.jrr.stream.realcase;

import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.Comparator.comparing;

public class EmployeService {

    public static final Comparator<Employee> BY_NAME = comparing(Employee::getName);
    public static final Comparator<Employee> BY_LEVEL = comparing(Employee::getLevel);
    public static final Comparator<Employee> BY_AGE = comparing(Employee::getAge);
    public static final Comparator<Employee> BY_SKILL = comparing(Employee::getSkill);

    static List<Department> getDepartmentsWhereNoJuniors(List<Employee> employees) {
        return employees.stream()
                .filter(EmployeService::byAge) //employees
                .map(Employee::getDepartment)
                .distinct()
                .sorted(comparing(Department::getName))
                .collect(Collectors.toList());
    }

    static Double getAverageAge(final List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .getAsDouble();
    }

    static IntSummaryStatistics getStatistic(final List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getAge)
                .summaryStatistics();
    }

    private static boolean byAge(final Employee employee) {
        return employee.getLevel() > 1;
    }

    public static List<Employee> sort(final List<Employee> employees) {
        return employees.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Employee> sortByName(final List<Employee> employees) {
        return employees.stream()
                .sorted(comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public static List<Employee> sortByAge(final List<Employee> employees) {
        return employees.stream()
                .sorted(BY_AGE)
                .collect(Collectors.toList());
    }

    public static List<Employee> sortByAll(final List<Employee> employees) {
        return employees.stream()
                .sorted(
                        BY_AGE
                    .thenComparing(BY_NAME
                    .thenComparing(BY_LEVEL
                    .thenComparing(BY_SKILL)))
                )
                .collect(Collectors.toList());
    }
}
