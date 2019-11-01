package com.example.demo.controller;

import com.example.demo.repository.BlogRepository;
import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.mysql.cj.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    Logger log = LoggerFactory.getLogger(BlogController.class);


    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public List<Blog> index() {
        return blogService.findAll();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable int id) {
        return blogService.findById(id);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Blog blog) {
        return blogService.create(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable int id, @RequestBody Blog blog) {
        return blogService.update(id, blog);
    }

    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable int id) {
        return blogService.delete(id);
    }
}