package com.example.api.user;



import com.example.domain.user.Page;
import com.example.repository.user.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("pages")
public class PageRestController {
    @Autowired
    PageRepository pageRepository;

    //TODO: All operations - one, many, one/many-with-its-children,

    @RequestMapping(method = RequestMethod.POST)
    public List<Page> postPages(@RequestBody List<Page> pages) {
        List<Page> created = pageRepository.save(pages);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Page> getPages() {
        List<Page> pages = pageRepository.findAll();
        return pages;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Page putPage(@RequestBody Page page) {
        Page updated = pageRepository.save(page);
        return updated;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deletePages() {
        pageRepository.deleteAll();
    }
}
