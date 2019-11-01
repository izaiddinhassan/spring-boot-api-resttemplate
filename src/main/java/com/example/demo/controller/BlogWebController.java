package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/template")
public class BlogWebController {

    @Autowired
    private BlogWebService blogWebService;

    @GetMapping("/blog")
    public List<Blog> getAllBlog() {
        return blogWebService.getAllBlog();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable int id) {
        return blogWebService.show(id);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Blog blog) {
        return blogWebService.create(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable int id, @RequestBody Blog blog) {
        return blogWebService.update(id, blog);
    }

    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable int id) {
        return blogWebService.delete(id);
    }
}
