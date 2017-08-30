package rest.DTO;

/**
 * Created by miko0916 on 28.08.2017.
 */
public class DepartmentDTO
{
    private String id;
    private String departmentName;

    public DepartmentDTO()
    {
    }

    public String getId()
    {
        return id;
    }

    public DepartmentDTO setId(String departmentId)
    {
        this.id = departmentId;
        return this;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public DepartmentDTO setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
        return this;
    }
}
