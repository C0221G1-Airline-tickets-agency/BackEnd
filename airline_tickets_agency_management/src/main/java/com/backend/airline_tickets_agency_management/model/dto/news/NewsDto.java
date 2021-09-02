package com.backend.airline_tickets_agency_management.model.dto.news;
import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import com.backend.airline_tickets_agency_management.model.entity.news.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {
    private Long newsId;
    @NotBlank(message = " Not Null")
    private String newsCode;
    @NotBlank(message = " Not Null")
    private String newsTitle;
    @NotBlank(message = " Not Null")
    private String newsImage;
    @NotBlank(message = " Not Null")
    private String newsContent;
    @NotBlank(message = " Not Null")
    private String newsWriteDay;
    private Integer NewsViews;
    private boolean flag = true;
    private Employee employee;
    private Category category;
}
