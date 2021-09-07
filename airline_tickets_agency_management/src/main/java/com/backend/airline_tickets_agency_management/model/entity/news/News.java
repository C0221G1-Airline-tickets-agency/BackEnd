package com.backend.airline_tickets_agency_management.model.entity.news;
import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;
    private String newsCode;
    private String newsTitle;
    private String newsImage;
    @Column(columnDefinition = "TEXT")
    private String newsContent;
    @Column(columnDefinition = "date")
    private String newsWriteDay;
    @Column(columnDefinition = "bigint default 0")
    private Long NewsViews;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(columnDefinition = "boolean default true")
    private boolean flag = true;
}
