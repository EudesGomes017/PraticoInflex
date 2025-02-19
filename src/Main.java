import entities.Employee;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

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

        // Filtrando os funcionários que fazem aniversário em Outubro (10) ou Dezembro (12)
        List<Employee> employeesWithBirthdaysInOctDec = employees.stream()
                .filter(employee -> {
                    int month = employee.getDateBirth().getMonthValue();
                    return month == 10 || month == 12;
                })
                .collect(Collectors.toList());

        // Imprimindo os funcionários encontrados
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

        // Encontrando o funcionário com a maior idade
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getDateBirth().until(LocalDate.now()).getYears()))
                .orElse(null);

        // Imprimindo o funcionário com a maior idade, caso exista
        if (oldestEmployee != null) {
            int age = oldestEmployee.getDateBirth().until(LocalDate.now()).getYears();
            System.out.println("Funcionário com a maior idade:");
            System.out.println("Nome: " + oldestEmployee.getName() + " | Idade: " + age + " anos");
        } else {
            System.out.println("Não há funcionários cadastrados.");
        }

        System.out.println();

        System.out.println("Imprimindo os funcionários ordenados");

        // Ordenando os funcionários por nome em ordem alfabética
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        // Imprimindo os funcionários ordenados
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

            // Imprimindo o total dos salários
        System.out.println("Total dos salários dos funcionários: R$ " + moneyFormatter.format(totalSalary));


        System.out.println();

        System.out.println("Imprimindo quantos salários mínimos cada funcionário ganha");

        // Definindo o valor do salário mínimo
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        // Imprimindo quantos salários mínimos cada funcionário ganha
        System.out.println("Quantidade de salários mínimos de cada funcionário:");

        for (Employee employee : employees) {
            BigDecimal salariosMinimos = employee.getSalary().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println("Nome: " + employee.getName() + " | " +
                    "Salários Mínimos: " + salariosMinimos);
        }


        sc.close();
    }
}