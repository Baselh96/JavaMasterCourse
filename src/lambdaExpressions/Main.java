package lambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Erstes Beispiel
        // Lambda-Ausdruck mit vielen Codezeilen
        new Thread(() -> {
            System.out.println("Lambda Expressions");
            System.out.println("Line 2");
            System.out.format("This is the line %d\n", 3);
        }).start();

        // zweites Beispiel
        Employee basel = new Employee("Basel Hussein", 26);
        Employee eva = new Employee("Eva Yussuf", 20);
        Employee yussef = new Employee("Yussef Ali", 10);
        Employee ali = new Employee("Ali Hussein", 56);

        List<Employee> employees = new ArrayList<>();
        employees.add(basel);
        employees.add(eva);
        employees.add(yussef);
        employees.add(ali);

        employees.forEach(System.out::println);

        /*
        // Frist Way to sort
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/

        // Second way to sort
        //Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
        // 3 Way to sort
        //employees.sort(Comparator.comparing(Employee::getName));
        // 4 Way to sort
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        employees.forEach(System.out::println);

        // drittes Beispiel
        /*
        String result = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        }, "Hello", "Basel");
        */
        String result = doStringStuff(((s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase()), "Hello", "Basel");

        System.out.println(result);

        //viertes Beispiel
        AnotherClass anotherClass = new AnotherClass();
        System.out.println(anotherClass.doSomethings());


    }

    public static String doStringStuff( UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}


