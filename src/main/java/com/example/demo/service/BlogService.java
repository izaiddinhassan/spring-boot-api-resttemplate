package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog update(int id, Blog blog) {
        Blog newBlog = blogRepository.findById(id).orElse(null);
        newBlog.setTitle(blog.getTitle());
        newBlog.setContent(blog.getContent());
        return blogRepository.save(newBlog);
    }

    public boolean delete(int id){
        blogRepository.deleteById(id);
        return true;
    }
}
