package rest.Services;

/**
 * Created by miko0916 on 28.08.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import rest.DTO.DepartmentDTO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
final class DepartmentController {

    private final DepartmentService service;

    @Autowired
    DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    DepartmentDTO create(@RequestBody @Valid DepartmentDTO departmentEntry) {
        return service.create(departmentEntry);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    DepartmentDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<DepartmentDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    DepartmentDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "search/findByName", method = RequestMethod.GET)
    DepartmentDTO findByName(@Param("name") String name) {
        return service.findByName(name);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    DepartmentDTO update(@RequestBody @Valid DepartmentDTO departmentEntry) {
        return service.update(departmentEntry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(DepartmentNotFoundException ex) {
    }
}
