package com.backend.airline_tickets_agency_management.model.repository.news;
import com.backend.airline_tickets_agency_management.model.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsRepository extends JpaRepository<News,Long> {
}
