package rest.DBRepos;

/**
 * Created by miko0916 on 28.08.2017.
 */
import java.util.List;

import rest.Models.Department;
import rest.Models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByLastName(@Param("lastName") String lastName);

    List<Employee> findByFirstName(@Param("firstName") String firstName);

    void delete(Employee deleted);

    List<Employee> findAll();

    Employee findOne(String id);

    Employee save(Employee saved);

    //Employee update(Employee employee);
}
