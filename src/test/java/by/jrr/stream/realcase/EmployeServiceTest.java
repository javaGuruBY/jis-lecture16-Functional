package by.jrr.stream.realcase;

import by.jrr.stream.StreamSytax;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static by.jrr.stream.StreamSytax.logInfo;
import static by.jrr.stream.realcase.EmployeFabric.getEmploye;
import static java.util.Comparator.comparing;

public class EmployeServiceTest {


    @Test
    public void getDepartmentsWhereNoJuniors() {
        EmployeService
                .getDepartmentsWhereNoJuniors(getEmploye())
                .forEach(StreamSytax::logInfo);
    }

    @Test
    public void getAverageAge() {
        logInfo(EmployeService.getAverageAge(getEmploye()));
    }

    @Test
    public void getStatistic() {
        logInfo(EmployeService.getStatistic(getEmploye()));
    }

    @Test(expected = ClassCastException.class) //compareToNotImplemented (not Comparable)
    public void sort() {
        logInfo(EmployeService.sort(getEmploye()));
    }

    @Test(expected = ClassCastException.class) //compareToNotImplemented (not Comparable)
    public void sortByName() {
        logInfo(EmployeService.sortByName(getEmploye()));
    }

    @Test
    public void sortByAll() {
        logInfo(EmployeService.sortByAll(getEmploye()));
    }

    @Test
    public void sortWithCollections() {
        List<Employee> employees = new ArrayList<>(EmployeFabric.getEmploye());

        employees.stream().mapToInt(Employee::getAge).forEach(StreamSytax::logInfo);
        System.out.println();
        Collections.sort(employees, comparing(Employee::getAge));
        employees.stream().mapToInt(Employee::getAge).forEach(StreamSytax::logInfo);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void sortWithCollectionsEx() {
        List<Employee> employees = EmployeFabric.getEmploye();

        employees.stream().mapToInt(Employee::getAge).forEach(StreamSytax::logInfo);
        System.out.println();
        Collections.sort(employees, comparing(Employee::getAge));
        employees.stream().mapToInt(Employee::getAge).forEach(StreamSytax::logInfo);
    }
}
