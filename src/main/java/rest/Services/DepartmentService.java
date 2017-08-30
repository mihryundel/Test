package rest.Services;

import rest.DTO.DepartmentDTO;

import java.util.List;

/**
 * Created by miko0916 on 28.08.2017.
 */


interface DepartmentService
{

    DepartmentDTO create(DepartmentDTO todo);

    DepartmentDTO delete(String id);

    List<DepartmentDTO> findAll();

    DepartmentDTO findById(String id);

    DepartmentDTO findByName(String name);

    DepartmentDTO update(DepartmentDTO todo);
}
