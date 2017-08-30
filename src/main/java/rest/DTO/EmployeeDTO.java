package rest.DTO;

import javafx.scene.chart.ChartBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import rest.Models.Department;

import java.util.Date;

/**
 * Created by miko0916 on 28.08.2017.
 */
public class EmployeeDTO
{
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfStartWork;
    private String employeeCode;
    private Department employeeDepartment;

    public EmployeeDTO()
    {
    }

    public String getId()
    {
        return id;
    }

    public EmployeeDTO setId(String id)
    {
        this.id = id;
        return this;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public EmployeeDTO setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public String getLastName()
    {
        return lastName;
    }

    public EmployeeDTO setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public EmployeeDTO setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Date getDateOfStartWork()
    {
        return dateOfStartWork;
    }

    public EmployeeDTO setDateOfStartWork(Date dateOfStartWork)
    {
        this.dateOfStartWork = dateOfStartWork;
        return this;
    }

    public String getEmployeeCode()
    {
        return employeeCode;
    }

    public EmployeeDTO setEmployeeCode(String employeeCode)
    {
        this.employeeCode = employeeCode;
        return this;
    }

    public Department getEmployeeDepartment()
    {
        return employeeDepartment;
    }

    public EmployeeDTO setEmployeeDepartment(Department employeeDepartment)
    {
        this.employeeDepartment = employeeDepartment;
        return this;
    }
}
