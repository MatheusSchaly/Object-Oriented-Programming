package br.univali.kob.poo1.aula05;

import java.time.LocalDate;

/**
 * @author Matheus Schaly
 */

public class Student extends Person {
    
    /**
     * Student's enrollment number.
     */
    private int enrollmentNumber;
    
    /**
     * Student's first enrollment date.
     */
    private LocalDate enrollmentDate;
    
    /**
     * Student's last enrollment date.
     */
    private LocalDate dropDate;
    
    
    
    /**
     * Constructor.
     * @param name student's name
     * @param dateOfBirth student's birth date
     * @param enrollmentDate student's first enrollment date
     */
    public Student(String name, LocalDate dateOfBirth, LocalDate enrollmentDate) {
        super(name, dateOfBirth);
        this.enrollmentDate = enrollmentDate;
        this.dropDate = null;
        validateState();
    }
    
    /**
     * Constructor.
     * @param name student's name
     * @param dateOfBirth student's birth date
     * @param enrollmentDate student's first enrollment date
     */
    public Student(String name, String dateOfBirth, String enrollmentDate) {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), 
                LocalDate.parse(enrollmentDate, AppConfig.DATE_FORMAT));
    }
    
    /**
     * Validates Student state.
     */
    private void validateState() {
        validateEnrollmentDate();
    }
    
    /**
     * Validates enrollment date.
     */
    private void validateEnrollmentDate() {
        if (enrollmentDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Enrollment Date (" + enrollmentDate + ") is out of range [.." + LocalDate.now() + "]");
        }
    }
    
    /**
     * Informs if the student is enrolled or not.
     * 
     * @return current student's situation, registered or not
     */
    public boolean isEnrolled() {
        return dropDate == null;
    }
    
    /**
     * Getter.
     * 
     * @return Student's first enrollment date
     */
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    
    /**
     * Setter.
     * 
     * @param enrollmentDate student's first enrollment date
     */
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
    /**
     * Getter.
     * 
     * @return Student's last registration date, null if still enrolled
     */
    public LocalDate getDropDate() {
        return dropDate;
    }
    
    /**
     * Setter.
     * 
     * @param dropDate Student's last enrollment date
     */
    public void setDropDate(LocalDate dropDate) {
        this.dropDate = dropDate;
    }
    
    @Override
    protected String appendToString() {
        StringBuilder output = new StringBuilder();
        output.append(" // Student " + AppConfig.NEW_LINE);
        output.append(" enrollmentDate = " + enrollmentDate.format(AppConfig.DATE_FORMAT) + AppConfig.NEW_LINE);
        output.append(" dropDate = ");
        output.append(((dropDate == null) ? null : dropDate.format(AppConfig.DATE_FORMAT)) + AppConfig.NEW_LINE);
        return output.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Student student = (Student)obj;
        return
                (enrollmentDate == student.enrollmentDate || enrollmentDate.equals(student.enrollmentDate));
    }
    
    @Override
    public int hashCode() {
        return
                super.hashCode() ^
                enrollmentDate.hashCode();
    }
    
}
