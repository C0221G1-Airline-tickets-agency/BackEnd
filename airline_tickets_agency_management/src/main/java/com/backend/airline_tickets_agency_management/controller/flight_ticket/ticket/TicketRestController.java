package com.backend.airline_tickets_agency_management.controller.flight_ticket.ticket;

import com.backend.airline_tickets_agency_management.model.dto.flight_ticket.TicketCustomerDto;
import com.backend.airline_tickets_agency_management.model.dto.flight_ticket.TicketMailDto;
import com.backend.airline_tickets_agency_management.model.dto.flight_ticket.TicketSendMailDto;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.backend.airline_tickets_agency_management.model.service.flight_ticket.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/tickets")
@EnableScheduling
public class TicketRestController {
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private JavaMailSender emailSender;

    @GetMapping(value = "/ticket-list")
    public ResponseEntity<Page<Ticket>> findTicketsByFilter(@RequestParam Optional<Integer> filterType,
                                                            @RequestParam Optional<String> keySearch,
                                                            @RequestParam Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        String[] keys = {"", "", "", ""};
        if (keySearch.isPresent()) {
            keys[filterType.orElse(0)] = keySearch.get();
        }
        Page<Ticket> ticketPage = this.ticketService.findAllByFilter(keys[0], keys[1], keys[2], keys[3], pageable);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

    @DeleteMapping(value = "ticket-delete/{id}")
    public ResponseEntity<Ticket> deleteTicketById(@PathVariable Long id) {
        Ticket ticket = this.ticketService.findById(id).orElse(null);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.ticketService.remove(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping(value = "/get-ticket-customer-book")
    public ResponseEntity<List<TicketCustomerDto>> getListTicketCustomerBook(@RequestParam Long id, @RequestParam Integer index) {
        List<TicketCustomerDto> ticketCustomerDtoList = this.ticketService.findAllTicketCustomerBook(id, index);
        if (ticketCustomerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ticketCustomerDtoList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get-ticket-customer-transaction")
    public ResponseEntity<List<TicketCustomerDto>> getListTicketCustomerTransaction(@RequestParam Long id, @RequestParam Integer index) {
        List<TicketCustomerDto> ticketCustomerDtoList = this.ticketService.findAllTicketCustomerTransaction(id, index);
        if (ticketCustomerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ticketCustomerDtoList, HttpStatus.OK);
        }
    }

    @DeleteMapping("/update-ticket-cancel")
    public ResponseEntity<Ticket> updateTicketCancel(@RequestParam Long id) {
        Optional<Ticket> ticket = this.ticketService.findById(id);
        if (!ticket.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.ticketService.updateTicketCancel(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/update-ticket-paid")
    public ResponseEntity<Ticket> updateTicketPaid(@RequestParam Long id) {
        Optional<Ticket> ticket = this.ticketService.findById(id);
        if (!ticket.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.ticketService.updateTicketPaid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/email/send")
    public void sendEmail(@RequestBody Optional<TicketSendMailDto> listTicket) throws MessagingException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String array = "ducdoan5695@gmail.com";
        Integer stt = 1;
        Double total = Double.valueOf(0);
        DecimalFormat format = new DecimalFormat("###,###,###");
        String info = "<h1>Thông tin thanh toán của bạn tại C0221G1 Airline</h1> <table border=1><tr><th style=\"width: 30px\">STT</th><th style=\"width: 100px\">Mã vé</th><th style=\"width: 100px\">Nơi đi</th>" +
                "<th style=\"width: 100px\">Nơi đến</th><th style=\"width: 100px\">Ngày đặt</th><th style=\"width: 100px\">Ngày bay</th><th style=\"width: 100px\">Giá</th>" +
                "</tr>";
        for (TicketMailDto ticketList : listTicket.get().getTicketMailDtoList()) {

            info += "<tr><td>" + (stt++) + "</td><td>" + ticketList.getTicketCode() + "</td>" +
                    "<td>" + ticketList.getPointOfDeparture() + "</td>" +
                    "<td>" + ticketList.getDestination() + "</td>" +
                    "<td>" + formatter.format(LocalDate.parse(ticketList.getBookingDate())) + "</td>" +
                    "<td>" + formatter.format(LocalDate.parse(ticketList.getFlightDate())) + "</td>" +
                    "<td>" + format.format(ticketList.getPriceSell()) + " VND" + "</td>";
            total += ticketList.getPriceSell();
        }
        info += "</table> <br> <h3>Tổng tiền: " + format.format(total) + " VND <h3>";

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(array);
        helper.setText(info, true);

        helper.setSubject("Đơn thanh toán tại C0221G1 Airline");
        emailSender.send(message);
    }

}
