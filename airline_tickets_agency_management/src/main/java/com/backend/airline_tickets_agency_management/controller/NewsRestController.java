package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.dto.news.NewsDto;
import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import com.backend.airline_tickets_agency_management.model.entity.news.Category;

import com.backend.airline_tickets_agency_management.model.entity.news.News;
import com.backend.airline_tickets_agency_management.model.service.employee.IEmployeeService;
import com.backend.airline_tickets_agency_management.model.service.news.INewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value = "")
    public ResponseEntity<News> create(@Valid @RequestBody NewsDto newsDto) {
        Optional<Employee> employee = employeeService.findById(newsDto.getEmployee().getEmployeeId());
        if (employee.isPresent()) {
            News news = new News();
            BeanUtils.copyProperties(newsDto, news);
            this.newsService.save(news);
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<News> getNews(@PathVariable Long id) {
        Optional<News> news = newsService.findById(id);
        return news.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = newsService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Optional<Category> category = newsService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    //màn hình danh sách và xóa tin tức


    @GetMapping(value = "/update-views/{id}")
    public ResponseEntity<News> updateViews(@PathVariable Long id ) {
        News newsOptional = this.newsService.findById(id).orElse(null);
        if (newsOptional== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        newsOptional.setNewsViews(newsOptional.getNewsViews() + 1);
        newsService.save(newsOptional);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/news-list")
    public ResponseEntity<Page<News>> listNews(@RequestParam Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<News> newsPage = this.newsService.getAllNews(pageable);
        if (newsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }

    @GetMapping(value = "/hot-news")
    public ResponseEntity<List<News>> hotNews() {
        List<News> newsPage = this.newsService.hotNews();
        if (newsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }

    @DeleteMapping("/news-delete/{id}")
    public ResponseEntity<News> deleteNews(@PathVariable Long id) {
        News news = this.newsService.findById(id).orElse(null);
        if (news == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(news.isFlag()==false){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        news.setFlag(false);
        this.newsService.save(news);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }


}
