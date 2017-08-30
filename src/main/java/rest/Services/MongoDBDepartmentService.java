package rest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rest.DBRepos.DepartmentRepository;
import rest.DTO.DepartmentDTO;
import rest.Models.Department;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by miko0916 on 28.08.2017.
 */

@Service
public class MongoDBDepartmentService implements DepartmentService
{
    private final DepartmentRepository repository;

    @Autowired
    MongoDBDepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentDTO create(DepartmentDTO department) {
        Department persisted = Department.getBuilder()
                .departmentName(department.getDepartmentName())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }


    @Override
    public DepartmentDTO delete(String id) {
        Department deleted = findDepartmentById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> departmentEntries = repository.findAll();
        return convertToDTOs(departmentEntries);
    }

    private List<DepartmentDTO> convertToDTOs(List<Department> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public DepartmentDTO findById(String id) {
        Department found = findDepartmentById(id);
        return convertToDTO(found);
    }


    @Override
    public DepartmentDTO update(DepartmentDTO department) {
        Department updated = findDepartmentById(department.getId());
        updated.update(department.getDepartmentName());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    @Override
    public DepartmentDTO findByName(String name)
    {
        Department found = findDepartmentByName(name);
        return convertToDTO(found);
    }

    private Department findDepartmentById(String id) {
        Department result = repository.findOne(id);
        if (result == null)
        {
            try
            {
                throw new DepartmentNotFoundException(id);
            }
            catch (DepartmentNotFoundException e)
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

    private Department findDepartmentByName(String name) {
        Department result = repository.findByDepartmentName(name);
        if (result == null)
        {
            try
            {
                throw new DepartmentNotFoundException(name);
            }
            catch (DepartmentNotFoundException e)
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

    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();

        dto.setId(department.getId());
        dto.setDepartmentName(department.getDepartmentName());
        return dto;
    }
}
