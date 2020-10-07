package by.jrr.stream.realcase;

import java.util.List;

public class EmployeFabric {

    public static List<Employee> getEmploye() {
        Department financialDep = new Department("Finance department");
        Department developDep = new Department("Developers department");
        Department juniorDepartment = new Department("Laboratory");

        return List.of(
                new Employee(19, "Vasja", "Java", 1, financialDep),
                new Employee(20, "Petya", ",Net", 3, financialDep),
                new Employee(38, "Iohan", "delfi", 5, developDep),
                new Employee(23, "Oleg", "java", 1, juniorDepartment),
                new Employee(25, "Andrei", "Python", 1, juniorDepartment),
                new Employee(35, "Maks", "Java", 2, developDep));
    }
}
