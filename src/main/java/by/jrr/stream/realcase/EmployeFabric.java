package by.jrr.stream.realcase;

import by.jrr.functional.service.MailJob;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeFabric {

    public static List<Employee> getEmploye() {
        Department financialDep = new Department("Finance department");
        Department developDep = new Department("Developers department");
        Department juniorDepartment = new Department("Laboratory");

        return List.of(
                new Employee(19, "Vasja", "Java", 1, financialDep, 100.0),
                new Employee(20, "Petya", ",Net", 3, financialDep, 2200.0),
                new Employee(38, "Iohan", "delfi", 5, developDep, 3345.89),
                new Employee(23, "Oleg", "java", 1, juniorDepartment, 100.0),
                new Employee(25, "Andrei", "Python", 1, juniorDepartment, 50.0),
                new Employee(35, "Maks", "Java", 2, developDep, 330.0));
    }

    public static List<TShapeEmployee> getTShapeEmploys() {
        Map<String, Integer> skillMap = new HashMap<>();
        skillMap.put("Java", 3);
        skillMap.put("Python", 5);
        skillMap.put("Kotlin", 1);
        skillMap.put("C", 1);
        skillMap.put("Ruby", 3);
        skillMap.put("Assembler", 7);
        skillMap.put("Pascal", 4);

        Map<String, Integer> skillMap2 = new HashMap<>();
        skillMap2.put("Java", 2);
        skillMap2.put("Python", 4);
        skillMap2.put("Kotlin", 1);
        skillMap2.put("C", 5);
        skillMap2.put("Assembler", 5);
        skillMap2.put("Pascal", 6);

        return List.of(
                new TShapeEmployee("Vasja",skillMap),
                new TShapeEmployee("Petya",skillMap2));
    }
}
