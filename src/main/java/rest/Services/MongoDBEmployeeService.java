package rest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import rest.DBRepos.EmployeeRepository;
import rest.DTO.EmployeeDTO;
import rest.Models.Employee;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by miko0916 on 28.08.2017.
 */

@Service
public class MongoDBEmployeeService implements EmployeeService
{
    private final EmployeeRepository repository;

    @Autowired
    MongoDBEmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employee) {
        Employee persisted = Employee.getBuilder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .dateOfBirth(employee.getDateOfBirth())
                .dateOfStartWork(employee.getDateOfStartWork())
                .employeeCode()
                .employeeDepartment(employee.getEmployeeDepartment())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public EmployeeDTO delete(String id) {
        Employee deleted = findEmployeeById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> EmployeeEntries = repository.findAll();
        return convertToDTOs(EmployeeEntries);
    }

    private List<EmployeeDTO> convertToDTOs(List<Employee> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public EmployeeDTO findById(String id) {
        Employee found = findEmployeeById(id);
        return convertToDTO(found);
    }


    @Override
    public EmployeeDTO update(EmployeeDTO employee) {
        Employee updated = findEmployeeById(employee.getId());
        updated.update(employee.getFirstName(), employee.getLastName(), employee.getDateOfBirth(), employee.getDateOfStartWork(), employee.getEmployeeCode(), employee.getEmployeeDepartment());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    @Override
    public List<EmployeeDTO> findByFirstName(String firstName)
    {
        List<Employee> found = findEmployeeByFirstName(firstName);
        return convertToDTOs(found);
    }

    @Override
    public List<EmployeeDTO> findByLastName(String lastName)
    {
        List<Employee> found = findEmployeeByLastName(lastName);
        return convertToDTOs(found);
    }

    private Employee findEmployeeById(String id) {
        Employee result = repository.findOne(id);
        if (result == null)
        {
            try
            {
                throw new EmployeeNotFoundException(id);
            }
            catch (EmployeeNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            return result;
        }
        return result;
    }

    private List<Employee> findEmployeeByFirstName(String firstName) {
        List<Employee> result = repository.findByFirstName(firstName);
        if (result == null)
        {
            try
            {
                throw new EmployeeNotFoundException(firstName);
            }
            catch (EmployeeNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            return result;
        }
        return result;
    }

    private List<Employee> findEmployeeByLastName(String lastName) {
        List<Employee> result = repository.findByLastName(lastName);
        if (result == null)
        {
            try
            {
                throw new EmployeeNotFoundException(lastName);
            }
            catch (EmployeeNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            return result;
        }
        return result;
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setDateOfBirth(employee.getDateOfBirth());
        dto.setDateOfStartWork(employee.getDateOfStartWork());
        dto.setEmployeeCode(employee.getEmployeeCode());
        dto.setEmployeeDepartment(employee.getEmployeeDepartment());

        return dto;
    }
}
