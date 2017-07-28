package com.example.api;



import com.example.domain.user.Group;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("cors")
public class CorsRestController {
    @RequestMapping(method = RequestMethod.POST)
    public Group postCors() {
        Group groupCode = new Group();
        return groupCode;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Group> getCors() {
        List<Group> groupCodes = new ArrayList<Group>();    //groupCodeRepository.findAll();
        return groupCodes;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Group putCors() {
        Group groupCode = new Group();
        return groupCode;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Group deleteCors() {
        Group groupCode = new Group();
        return groupCode;
    }
}
