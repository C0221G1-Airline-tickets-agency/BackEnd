package com.backend.airline_tickets_agency_management.model.entity.news;
import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



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
    private long newsViews;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(columnDefinition = "boolean default true")
    private boolean flag = true;
}
