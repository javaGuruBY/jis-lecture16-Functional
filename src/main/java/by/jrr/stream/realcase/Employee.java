package by.jrr.stream.realcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee{
    private int age;
    private String name;
    private String skill;
    private int level;
    private Department department;
}
