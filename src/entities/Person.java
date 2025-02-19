package entities;

import java.time.LocalDate;

public class Person {

    private String name;

    private LocalDate dateBirth;

    public Person(String name, LocalDate dateBirth) {
        this.name = name;
        this.dateBirth = dateBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return "Person " +
                "name = '" + name + '\'' +
                ", dateBirth = " + dateBirth
                ;
    }
}

