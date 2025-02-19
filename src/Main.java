import entities.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        // Criando um funcionário
        LocalDate maria = LocalDate.of(2000, 10, 18);
        LocalDate joao = LocalDate.of(1990, 5, 12);
        LocalDate caio = LocalDate.of(1961, 5, 14);
        LocalDate miguel = LocalDate.of(1988, 10, 14);
        LocalDate alice = LocalDate.of(1995, 1, 5);
        LocalDate heitor = LocalDate.of(1999, 11, 19);
        LocalDate arthur = LocalDate.of(1993, 3, 31);
        LocalDate laura = LocalDate.of(1994, 7, 8);
        LocalDate heloisa = LocalDate.of(2003, 5, 24);
        LocalDate helena = LocalDate.of(1996, 9, 2);

        BigDecimal salarioMaria = new BigDecimal("2009.44");
        BigDecimal salarioJoao = new BigDecimal("2284.38");
        BigDecimal salarioCaio = new BigDecimal("9836.14");
        BigDecimal salarioMiguel = new BigDecimal("19119.88");
        BigDecimal salarioAlice = new BigDecimal("2234.68");
        BigDecimal salarioHeitor = new BigDecimal("1582.72");
        BigDecimal salarioArthur = new BigDecimal("4071.84");
        BigDecimal salarioLaura = new BigDecimal("3017.45");
        BigDecimal salarioHeloisa = new BigDecimal("1606.85");
        BigDecimal salarioHelena = new BigDecimal("2799.93");


        Employee employeeMaria = new Employee("Maria", maria, salarioMaria, "Operador");
        Employee employeeJoao = new Employee("João", joao, salarioJoao, "Operador");
        Employee employeeCaio = new Employee("Caio", caio, salarioCaio, "Coordenador");
        Employee employeeMiguel = new Employee("Miguel", miguel, salarioMiguel, "Diretor");
        Employee employeeAlice = new Employee("Alice", alice, salarioAlice, "Recepcionista");
        Employee employeeHeitor = new Employee("Heitor", heitor, salarioHeitor, "Operador");
        Employee employeeArthur = new Employee("Customize Toolbar…", arthur, salarioArthur, "Contador");
        Employee employeeLaura = new Employee("laura", laura, salarioLaura, "Gerente");
        Employee employeeHeloisa = new Employee("Heloisa", heloisa, salarioHeloisa, "Eletricista");
        Employee employeeHelena = new Employee("Helena", helena, salarioHelena, "Gerente");

        // Adicionando à lista
        employees.add(employeeMaria);
        employees.add(employeeJoao);
        employees.add(employeeCaio);
        employees.add(employeeMiguel);
        employees.add(employeeAlice);
        employees.add(employeeHeitor);
        employees.add(employeeArthur);
        employees.add(employeeLaura);
        employees.add(employeeHeloisa);
        employees.add(employeeHelena);

        // Percorrendo e exibindo no log
        employees.forEach(System.out::println);


        sc.close();
    }
}