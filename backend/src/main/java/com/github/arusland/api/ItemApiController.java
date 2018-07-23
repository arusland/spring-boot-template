package com.github.arusland.api;

import com.github.arusland.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemApiController {
    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/item/{id}")
    public Item getItem(@PathVariable("id") long id) {
        log.info("getting item by id=" + id);

        return new Item(id, "Sample item - " + System.currentTimeMillis());
    }
}
