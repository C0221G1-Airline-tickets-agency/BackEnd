package com.backend.airline_tickets_agency_management.model.repository.report;

import com.backend.airline_tickets_agency_management.model.dto.report.IReportDto;
import com.backend.airline_tickets_agency_management.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportRepository extends JpaRepository<User, Long> {

    @Query(value = "select f.flight_date as flightDate," +
            "a.airline_name as airlineName,c.customer_name as " +
            "customerName,e.employee_name as employeeName," +
            "sum(t.ticket_price+t.ticket_price*t.tax-t.ticket_price*t.passenger_type_price) as totalMoney\n" +
            "from flight as f\n" +
            "inner join airline as a\n" +
            "on f.airline_id=a.airline_id\n" +
            "inner join ticket as t\n" +
            "on f.flight_id =t.flight_id\n" +
            "inner join customer as c\n" +
            "on t.customer_id =c.customer_id\n" +
            "inner join user as u\n" +
            "on c.customer_id=u.customer_id\n" +
            "inner join employee as e\n" +
            "on e.employee_id=u.employee_id\n" +
            "group by f.flight_date order by f.flight_date", nativeQuery = true)
    List<IReportDto> getAll();

    @Query(value = "select f.flight_date as flightDate," +
            "a.airline_name as airlineName,c.customer_name as " +
            "customerName,e.employee_name as employeeName," +
            "sum(t.ticket_price+t.ticket_price*t.tax-t.ticket_price*t.passenger_type_price) as totalMoney\n" +
            "from flight as f\n" +
            "inner join airline as a\n" +
            "on f.airline_id=a.airline_id\n" +
            "inner join ticket as t\n" +
            "on f.flight_id =t.flight_id\n" +
            "inner join customer as c\n" +
            "on t.customer_id =c.customer_id\n" +
            "inner join `user` as u\n" +
            "on c.customer_id=u.customer_id\n" +
            "inner join employee as e\n" +
            "on e.employee_id=u.employee_id\n" +
            "where f.flight_date between ? and ?\n" +
            "group by f.flight_date\n" +
            "order by f.flight_date;", nativeQuery = true)
    List<IReportDto> getListStatisticalOneDate(String startDate, String endDate);

    @Query(value = "select f.flight_date as flightDate," +
            "a.airline_name as airlineName,c.customer_name as " +
            "customerName,e.employee_name as employeeName," +
            "sum(t.ticket_price+t.ticket_price*t.tax-t.ticket_price*t.passenger_type_price) as totalMoney,count(e.employee_name) as quantity\n" +
            "from flight as f\n" +
            "inner join airline as a\n" +
            "on f.airline_id=a.airline_id\n" +
            "inner join ticket as t\n" +
            "on f.flight_id =t.flight_id\n" +
            "inner join customer as c\n" +
            "on t.customer_id =c.customer_id\n" +
            "inner join `user` as u\n" +
            "on c.customer_id=u.customer_id\n" +
            "inner join employee as e\n" +
            "on e.employee_id=u.employee_id\n" +
            "where f.flight_date between ? and ?\n" +
            "group by e.employee_name\n" +
            "order by quantity desc,totalMoney desc\n" +
            "limit 5", nativeQuery = true)
    List<IReportDto> getTop5Employee(String startDate, String endDate);

    @Query(value = "select  f.flight_date as flightDate,a.airline_name as airlineName,c.customer_name as customerName,e.employee_name as employeeName,sum(t.ticket_price+t.ticket_price*t.tax-t.ticket_price*t.passenger_type_price) as totalMoney,count(e.employee_name) as quantity\n" +
            "from flight as f\n" +
            "inner join airline as a\n" +
            "on f.airline_id=a.airline_id\n" +
            "inner join ticket as t\n" +
            "on f.flight_id =t.flight_id\n" +
            "inner join customer as c\n" +
            "on t.customer_id =c.customer_id\n" +
            "inner join `user` as u\n" +
            "on c.customer_id=u.customer_id\n" +
            "inner join employee as e\n" +
            "on e.employee_id=u.employee_id\n" +
            "where f.flight_date between ? and ?\n" +
            "group by a.airline_name\n" +
            "order by quantity desc,totalMoney desc\n" +
            "limit 5", nativeQuery = true)
    List<IReportDto> getTop5Airline(String startDate, String endDate);
}
