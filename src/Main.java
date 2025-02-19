import entities.Employee;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        employees.add(new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        employees.add(new Employee("Caio", LocalDate.of(1961, 5, 14), new BigDecimal("9836.14"), "Coordenador"));
        employees.add(new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        employees.add(new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        employees.add(new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        employees.add(new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        employees.add(new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        employees.add(new Employee("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        employees.add(new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat moneyFormatter = new DecimalFormat("#,##0.00");

        employees.removeIf(employee -> employee.getName().equals("João"));

        // Aplicando aumento de 10% nos salários
        for (Employee employee : employees) {
            employee.applySalaryIncrease();
        }

        System.out.println();

        Map<String, List<Employee>> employeesByFunction = employees.stream()
                .collect(Collectors.groupingBy(Employee::getFunction));

        List<Employee> employeesWithBirthdaysInOctDec = employees.stream()
                .filter(employee -> {
                    int month = employee.getDateBirth().getMonthValue();
                    return month == 10 || month == 12;
                })
                .collect(Collectors.toList());

        
        if (!employeesWithBirthdaysInOctDec.isEmpty()) {
            System.out.println("Funcionários com aniversário em Outubro ou Dezembro:");
            for (Employee employee : employeesWithBirthdaysInOctDec) {
                System.out.println(
                        "Nome: " + employee.getName() + " | " +
                                "Data de Nascimento: " + employee.getDateBirth().format(dateFormatter) + " | " +
                                "Salário: R$ " + moneyFormatter.format(employee.getSalary()) + " | " +
                                "Função: " + employee.getFunction()
                );
            }
        } else {
            System.out.println("Nenhum funcionário com aniversário em Outubro ou Dezembro.");
        }

        System.out.println();

        for (Map.Entry<String, List<Employee>> entry : employeesByFunction.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Employee employee : entry.getValue()) {
                System.out.println(
                        "Nome: " + employee.getName() + " | " +
                                "Data de Nascimento: " + employee.getDateBirth().format(dateFormatter) + " | " +
                                "Salário: R$ " + moneyFormatter.format(employee.getSalary()) + " | " +
                                "Função: " + employee.getFunction()
                );
            }
            System.out.println();
        }

        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getDateBirth().until(LocalDate.now()).getYears()))
                .orElse(null);

        if (oldestEmployee != null) {
            int age = oldestEmployee.getDateBirth().until(LocalDate.now()).getYears();
            System.out.println("Funcionário com a maior idade:");
            System.out.println("Nome: " + oldestEmployee.getName() + " | Idade: " + age + " anos");
        } else {
            System.out.println("Não há funcionários cadastrados.");
        }

        System.out.println();

        System.out.println("Imprimindo os funcionários ordenados");

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        System.out.println("Funcionários em ordem alfabética:");
        for (Employee employee : sortedEmployees) {
            System.out.println(
                    "Nome: " + employee.getName() + " | " +
                            "Data de Nascimento: " + employee.getDateBirth().format(dateFormatter) + " | " +
                            "Salário: R$ " + moneyFormatter.format(employee.getSalary()) + " | " +
                            "Função: " + employee.getFunction()
            );
        }

        System.out.println();

        System.out.println("Imprimindo o total dos salários");
        // Calculando o total dos salários
        BigDecimal totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total dos salários dos funcionários: R$ " + moneyFormatter.format(totalSalary));

        System.out.println();

        System.out.println("Imprimindo quantos salários mínimos cada funcionário ganha");

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.println("Quantidade de salários mínimos de cada funcionário:");

        for (Employee employee : employees) {
            BigDecimal salariosMinimos = employee.getSalary().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println("Nome: " + employee.getName() + " | " +
                    "Salários Mínimos: " + salariosMinimos);
        }

    }
}
