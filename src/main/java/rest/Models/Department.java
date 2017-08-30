package rest.Models;

/**
 * Created by miko0916 on 28.08.2017.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Department
{

    @Id private String id;
    @Indexed(unique=true) private String departmentName;

    public Department() {}

    public String getId()
    {
        return id;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    private Department(Builder builder) {
        this.departmentName = builder.departmentName;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void update(String departmentName)
    {
        this.departmentName = departmentName;
    }

    public static class Builder
    {
        private String departmentName;

        private Builder() {}

        public Builder departmentName(String departmentName)
        {
            this.departmentName = departmentName;
            return this;
        }

        public Department build()
        {
            Department build = new Department(this);
            return build;
        }
    }
}