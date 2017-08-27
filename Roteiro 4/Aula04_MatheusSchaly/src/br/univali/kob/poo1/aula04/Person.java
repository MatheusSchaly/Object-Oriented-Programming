package br.univali.kob.poo1.aula04;

/**
 * @author Matheus Schaly
 */

import java.time.LocalDate;
import java.time.Period;

/**
 * Base class for hierarchy of people in the academic system.
 */
public abstract class Person {

    /**
     * Person's name.
     */
    private String name;

    /**
     * Person's birth date.
     */
    private LocalDate dateOfBirth;
    
    /**
     * Person's constructor to be reutilized by its subclasses.
     * Name and birth date are required.
     * 
     * @param name person's name
     * @param dateOfBirth person's date of birth
     */
    public Person(String name, LocalDate dateOfBirth) {
        setName(name);
        setDateOfBirth(dateOfBirth);
    }

    /**
     * Setter.
     * 
     * @param name the person's name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter.
     * 
     * @return the person's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter.
     * 
     * @param dataOfBirth the person's birth date
     */
    public void setDateOfBirth(LocalDate dataOfBirth) {
        this.dateOfBirth = dataOfBirth;
    }
    
    /**
     * Getter.
     * 
     * @return the person's birth date
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    /**
     * Calculates person's age based on date of birth
     * and current date.
     * 
     * @return the person's birth date
     */
    public int getAge() {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        return period.getYears();
    }
    
}
