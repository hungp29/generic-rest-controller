package org.example.generic.controller.rest.book;

import org.example.generic.controller.support.generic.GenericRestController;
import org.example.generic.controller.support.generic.annotation.GenericController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Book Controller.
 *
 * @author hungp
 */
@RequestMapping("/api/v1/book")
@GenericController(readResponse = BookInfo.class, createRequest = BookInfo.class, updateRequest = BookInfo.class)
//@GenericDisabled(readAll = false)
public class BookController extends GenericRestController<Book> {

    @GetMapping("/test")
    public String test() {
        return "Hello Book";
    }
}
