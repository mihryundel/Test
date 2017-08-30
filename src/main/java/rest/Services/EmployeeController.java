package rest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rest.DTO.EmployeeDTO;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by miko0916 on 28.08.2017.
 */
@RestController
@RequestMapping("/api/employees")
final class EmployeeController {

    private final EmployeeService service;

    @Autowired
    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDTO create(@RequestBody @Valid EmployeeDTO employeeEntry) {
        return service.create(employeeEntry);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    EmployeeDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    EmployeeDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "search/findByFirstName", method = RequestMethod.GET)
    List<EmployeeDTO> findByFirstName(@Param("firstName") String firstName) {
        return service.findByFirstName(firstName);
    }

    @RequestMapping(value = "search/findByLastName", method = RequestMethod.GET)
    List<EmployeeDTO> findByLastName(@Param("lastName") String lastName) {
        return service.findByLastName(lastName);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    EmployeeDTO update(@RequestBody @Valid EmployeeDTO employeeEntry) {
        return service.update(employeeEntry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(DepartmentNotFoundException ex) {
    }
}
