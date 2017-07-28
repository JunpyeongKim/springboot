package com.example.api;


import com.example.domain.Resource;
import com.example.repository.ResourceRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "resources", description = "Resources")
@RestController
@CrossOrigin
@RequestMapping("resources")
public class ResourceRestController {
    @Autowired
    ResourceRepository resourceRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Resource> postResources(@RequestBody List<Resource> resources) {
        List<Resource> created = resourceRepository.save(resources);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Resource> getResources() {
        List<Resource> resources = resourceRepository.findAll();
        return resources;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Resource getResource(@PathVariable Long id) {
        Resource resource = resourceRepository.findOne(id);
        return resource;
    }

    /*
    @RequestMapping(method = RequestMethod.PUT)
    public List<Resource> putResources(@RequestBody List<Resource> resources) {
        List<Resource> updated = resourceRepository.save(resources);
        return updated;
    }
    */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Resource putResource(@PathVariable Long id,
                                @RequestBody Resource resource) {
        Resource found = resourceRepository.findOne(id);
        Resource updated = null;

        if (found != null) {
            updated = resourceRepository.save(resource);
        }

        return updated;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResources() {
        resourceRepository.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteResource(@PathVariable Long id) {
        //TODO: handling unfound id


        // and then delete a specific id
        resourceRepository.delete(id);
    }
}
