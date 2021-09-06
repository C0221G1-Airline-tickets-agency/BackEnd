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

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(String newsCode) {
        this.newsCode = newsCode;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsWriteDay() {
        return newsWriteDay;
    }

    public void setNewsWriteDay(String newsWriteDay) {
        this.newsWriteDay = newsWriteDay;
    }

    public Integer getNewsViews() {
        return NewsViews;
    }

    public void setNewsViews(Integer newsViews) {
        NewsViews = newsViews;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
