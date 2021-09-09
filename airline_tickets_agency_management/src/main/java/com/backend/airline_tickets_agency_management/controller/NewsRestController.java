package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.entity.news.Category;
import com.backend.airline_tickets_agency_management.model.entity.news.News;
import com.backend.airline_tickets_agency_management.model.service.employee.IEmployeeService;
import com.backend.airline_tickets_agency_management.model.service.news.INewsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/news")
public class NewsRestController {
   private final IEmployeeService employeeService;
    private final INewsService newsService;
    public NewsRestController(IEmployeeService employeeService, INewsService newsService) {
        this.employeeService = employeeService;
        this.newsService = newsService;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<News> getNews(@PathVariable Long id) {
        Optional<News> news = newsService.findById(id);
        return news.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> getCategories() {
            List<Category> categories = newsService.getAllCategory();
       return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Optional<Category> category = newsService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
