package rest.Services;
;
import rest.DTO.EmployeeDTO;

import java.util.List;

/**
 * Created by miko0916 on 28.08.2017.
 */

interface EmployeeService
{

    EmployeeDTO create(EmployeeDTO todo);

    EmployeeDTO delete(String id);

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(String id);

    EmployeeDTO update(EmployeeDTO employee);

    List<EmployeeDTO> findByFirstName(String firstName);

    List<EmployeeDTO> findByLastName(String lastName);
}
