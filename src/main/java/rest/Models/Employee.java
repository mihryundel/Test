package rest.Models;

import org.springframework.data.annotation.Id;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by miko0916 on 28.08.2017.
 */
public class Employee
{
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfStartWork;
    private String employeeCode;
    private Department employeeDepartment;

    public Employee() {}

    public String getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public Date getDateOfStartWork()
    {
        return dateOfStartWork;
    }

    public String getEmployeeCode()
    {
        return employeeCode;
    }

    public Department getEmployeeDepartment()
    {
        return employeeDepartment;
    }

    private Employee(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.dateOfStartWork = builder.dateOfStartWork;
        this.employeeCode = builder.employeeCode;
        this.employeeDepartment = builder.employeeDepartment;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void update(String firstName, String lastName, Date dateOfBirth, Date dateOfStartWork, String employeeCode, Department employeeDepartment)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfStartWork = dateOfStartWork;
        this.employeeCode = employeeCode;
        this.employeeDepartment = employeeDepartment;
    }

    public static class Builder
    {
        private String firstName;
        private String lastName;
        private Date dateOfBirth;
        private Date dateOfStartWork;
        private String employeeCode;
        private Department employeeDepartment;

        private Builder() {}

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth)
        {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder dateOfStartWork(Date dateOfStartWork)
        {
            this.dateOfStartWork = dateOfStartWork;
            return this;
        }

        public Builder employeeCode()
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateOfStartWork);
            this.employeeCode = firstName.substring(0,2) + lastName.substring(0,2) + cal.get(Calendar.MONTH) + cal.get(Calendar.YEAR);
            return this;
        }

        public Builder employeeDepartment(Department employeeDepartment)
        {
            this.employeeDepartment = employeeDepartment;
            return this;
        }

        public Employee build()
        {
            Employee build = new Employee(this);
            return build;
        }
    }
}
