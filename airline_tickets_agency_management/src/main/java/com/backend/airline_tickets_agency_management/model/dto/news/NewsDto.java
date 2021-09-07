package com.backend.airline_tickets_agency_management.model.dto.news;

import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import com.backend.airline_tickets_agency_management.model.entity.news.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {
    private Long newsId;
    @NotBlank(message = " Not Null")
    private String newsCode;
    @NotBlank(message = " Not Null")
    @Size(max = 120, min = 66)
    private String newsTitle;
    @NotBlank(message = " Not Null")
    private String newsImage;
    @NotBlank(message = " Not Null")
    @Size(max = 1200, min = 666)
    private String newsContent;
    @NotNull(message="Status date is a required field")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message="Invalid status date")
    private String newsWriteDay;
    @Min(value = 0)
    private Integer NewsViews;
    private boolean flag = true;
    private Employee employee;
    private Category category;
}
