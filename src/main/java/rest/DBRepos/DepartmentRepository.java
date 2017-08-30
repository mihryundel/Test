package rest.DBRepos;

/**
 * Created by miko0916 on 28.08.2017.
 */
import java.util.List;

import rest.Models.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "departments", path = "departments")
public interface DepartmentRepository extends MongoRepository<Department, String> {

    Department findByDepartmentName(@Param("departmentName") String departmentName);

    void delete(Department deleted);

    List<Department> findAll();

    Department findOne(String id);

    Department save(Department saved);

}
