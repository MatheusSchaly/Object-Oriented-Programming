package br.univali.kob.poo1.aula04;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Matheus Schaly
 */

public class Employee extends Person {
    
    /**
     * Employee's identification number.
     */
    private int id;

    /**
     * Employees's hiring date.
     */
    private LocalDate hireDate;

    /**
     * Employees's resignation date.
     */
    private LocalDate terminationDate;

    /**
     * Employees's working hours per week.
     */
    private int hoursPerWorkWeek;

    /**
     * Employees's hourly payment rate.
     */
    private BigDecimal hourlyRate;
    
    
    
    /**
     * Constructor.
     * @param id employee's identification number
     * @param name employee's name
     * @param dateOfBirth employee's birth date
     * @param hireDate employee's Hiring date
     * @param hoursPerWorkWeek employees's working hours per week
     * @param hourlyRate employees's hourly payment rate
     */
    public Employee(int id, String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate) {
        super(name, dateOfBirth);
        this.id = id;
        this.terminationDate = null;
        this.hireDate = hireDate;
        this.hoursPerWorkWeek = hoursPerWorkWeek;
        this.hourlyRate = hourlyRate;
        validateState();
    }
    
    /**
     * Validates Professor state.
     */
    private void validateState() {
        validateId();
        validateHoursPerWorkWeek();
        validateHourlyRate();
        validateHireDate();
    }
    
    /**
     * Validates id.
     */
    private void validateId() {
        if (id < 0) {
            throw new IllegalArgumentException("Id (" + id + ") is out of range [1..]");
        }
    }
    
    /**
     * Validates hire date.
     */
    private void validateHireDate() {
        if (hireDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Hire Date (" + hireDate + ") is out of range [.." + LocalDate.now() + "]");
        }
    }
    
    /**
     * Validates hours per work week.
     */
    private void validateHoursPerWorkWeek() {
        if (hoursPerWorkWeek < 1 || hoursPerWorkWeek > 40) {
            throw new IllegalArgumentException("Hours per Work Week (" + hoursPerWorkWeek + ") is out of range [1..40]");
        }
    }
    
    /**
     * Validates hourly rate.
     */
    private void validateHourlyRate() {
        if (hourlyRate.compareTo(new BigDecimal("0.0")) < 0) {
            throw new IllegalArgumentException("Hourly Rate (" + hourlyRate + ") is out of range [0.0..]");
        }
    }

    /**
     * Informs if the employee is employed or not.
     * 
     * @return current employee's situation, employed or not
     */
    public boolean isEmployed() {
        return terminationDate == null;
    }

    /**
     * Calculates employee's years of service.
     * 
     * @return employee's years of service
     */
    public int getYearsOfService() {
        Period period = Period.between(hireDate, LocalDate.now());
        return period.getYears();
    }

    /**
     * Calculates the base employee's salary in R$, multiplying 
     * the working hours per week by hourly payment rate. It is not
     * affected by absent hours.
     * 
     * @return employee's week salary
     */
    public BigDecimal getRegularWeekSalary() {
        BigDecimal value = new BigDecimal(hoursPerWorkWeek);
        value = value.multiply(getHourlyRate());
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * Calculates the base employee's salary in R$, multiplying 
     * the working hours per week by hourly payment rate. It is
     * affected by absent hours.
     * 
     * @param absentHours employee's hours not worked
     * @return employee's week payment
     */
    public BigDecimal getWeekPayment(int absentHours) {
        BigDecimal value = new BigDecimal(hoursPerWorkWeek - absentHours);
        value = value.multiply(getHourlyRate());
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * Getter.
     * 
     * @return Employee's identification number
     */
    public int getId() {
        return id;
    }

    /**
     * Setter.
     * 
     * @param id Employee's identification number
     */
    public void setId(int id) {
        this.id = id;
        validateId();
    }

    /**
     * Getter.
     * 
     * @return Employee's Hiring date
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * Setter.
     * 
     * @param hireDate Employee's Hiring date
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * Getter.
     * 
     * @return Employees's resignation date.
     */
    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    /**
     * Setter.
     * 
     * @param terminationDate Employees's resignation date.
     */
    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    /**
     * Getter.
     * 
     * @return Employees's working hours per week.
     */
    public int getHoursPerWorkWeek() {
        return hoursPerWorkWeek;
    }

    /**
     * Setter.
     * 
     * @param hoursPerWorkWeek Employees's working hours per week.
     */
    public void setHoursPerWorkWeek(int hoursPerWorkWeek) {
        this.hoursPerWorkWeek = hoursPerWorkWeek;
        validateHoursPerWorkWeek();
    }

    /**
     * Getter.
     * 
     * @return Employees's hourly payment rate.
     */
    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Setter.
     * 
     * @param hourlyRate Employees's hourly payment rate.
     */
    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
}