package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {

    private BigDecimal salary;

    private String function;

    public Employee(String name, LocalDate dateBirth, BigDecimal salary, String function) {
        super(name, dateBirth);
        this.salary = salary;
        this.function = function;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void applySalaryIncrease() {
        this.salary = this.salary.multiply(new BigDecimal("1.10")); // Aumento de 10%
    }

    @Override
    public String toString() {
        return super.toString() + ", Salário=" + salary + ", Cargo='" + function + "'";
    }

}
