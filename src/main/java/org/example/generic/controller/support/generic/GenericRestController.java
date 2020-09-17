package org.example.generic.controller.support.generic;

import org.example.generic.controller.rest.Audit;
import org.example.generic.controller.support.generic.annotation.APICreate;
import org.example.generic.controller.support.generic.annotation.APIDelete;
import org.example.generic.controller.support.generic.annotation.APIReadAll;
import org.example.generic.controller.support.generic.annotation.APIReadOne;
import org.example.generic.controller.support.generic.annotation.APIUpdateAll;
import org.example.generic.controller.support.generic.annotation.APIUpdatePart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Generic Controller.
 *
 * @author hungp
 */
public class GenericRestController<T extends Audit> {

    /**
     * API create.
     *
     * @param createDTO data to creating entity
     * @return result after create
     */
    @APICreate
    public ResponseEntity<Object> create(@RequestBody Object createDTO) {
        return ResponseEntity.ok("Create");
    }

    /**
     * API Read one.
     *
     * @param id id of entity
     * @return result after read data by id
     */
    @APIReadOne("/{id}")
    public <ID> ResponseEntity<Object> readOne(@PathVariable ID id, FilterData filterData) {
        return ResponseEntity.ok("Read One");
    }

    /**
     * API Read all.
     *
     * @return result after read all data
     */
    @APIReadAll
    public ResponseEntity<Object> readAll(FilterData filterData, Pagination pagination) {
        return ResponseEntity.ok("Read All");
    }

    /**
     * API update all.
     *
     * @param id        id of entity
     * @param updateDTO data to update entity
     * @return data after update entity
     */
    @APIUpdateAll("/{id}")
    public <ID> ResponseEntity<Object> updateAll(@PathVariable ID id, @RequestBody Object updateDTO) {
        return ResponseEntity.ok("Update All");
    }

    /**
     * API update a part.
     *
     * @param id        id of entity
     * @param updateDTO data to update entity
     * @return data after update entity
     */
    @APIUpdatePart("/{id}")
    public <ID> ResponseEntity<Object> updatePart(@PathVariable ID id, @RequestBody Object updateDTO) {
        return ResponseEntity.ok("Update Part");
    }

    /**
     * API delete.
     *
     * @param id id of entity
     * @return result after delete entity
     */
    @APIDelete("/{id}")
    public <ID> ResponseEntity<Boolean> delete(@PathVariable ID id) {
        return ResponseEntity.ok(true);
    }
}
