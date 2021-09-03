package com.backend.airline_tickets_agency_management.model.service.news;
import com.backend.airline_tickets_agency_management.model.entity.news.Category;
import com.backend.airline_tickets_agency_management.model.entity.news.News;
import com.backend.airline_tickets_agency_management.model.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface INewsService extends IGeneralService<News> {
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(Long id);
}
