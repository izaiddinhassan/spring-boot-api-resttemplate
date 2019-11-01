package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BlogWebService {
    @Autowired
    private RestTemplate restTemplate;

    public List<Blog> getAllBlog() {
        ResponseEntity<List<Blog>> responseEntity =
                restTemplate.exchange("http://localhost:8080/api/v1/blog",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        });
        return responseEntity.getBody();
    }

    public Blog show(int id){
        String path = "http://localhost:8080/api/v1/blog/" + id;
        System.out.println(path);
        ResponseEntity<Blog> responseEntity =
                restTemplate.exchange(path, HttpMethod.GET, null, Blog.class);
        return responseEntity.getBody();
    }

    public Blog create(Blog blog) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Blog> requestEntity = new HttpEntity<>(blog, requestHeaders);

        ResponseEntity<Blog> responseEntity =
                restTemplate.exchange("http://localhost:8080/api/v1/blog",
                        HttpMethod.POST,
                        requestEntity,
                        Blog.class);
        return responseEntity.getBody();
    }

    public Blog update(int id, Blog blog) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Blog> requestEntity = new HttpEntity<>(blog, requestHeaders);

        ResponseEntity<Blog> responseEntity =
                restTemplate.exchange("http://localhost:8080/api/v1/blog/" + id,
                        HttpMethod.PUT,
                        requestEntity,
                        Blog.class);
        return responseEntity.getBody();
    }

    public boolean delete(int id) {
        restTemplate.delete("http://localhost:8080/api/v1/blog/" + id);
        return true;
    }
}
