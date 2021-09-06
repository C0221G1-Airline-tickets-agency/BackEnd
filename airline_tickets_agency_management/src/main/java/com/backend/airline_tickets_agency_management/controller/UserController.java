package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.dto.password.Message;
import com.backend.airline_tickets_agency_management.model.dto.password.PasswordDto;
import com.backend.airline_tickets_agency_management.model.entity.user.User;
import com.backend.airline_tickets_agency_management.model.service.user.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/admin")
public class UserController {
    private static String REGEX = "^\\w{5,}$";
    private Matcher matcher;
    private Pattern pattern;


    @Autowired
    private IUserService iUserService;

    @GetMapping("/findAdminById")
    public ResponseEntity<User> getAdminById(@RequestParam(value = "id") Long id) {
        User user = this.iUserService.findById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/changePassword")
    public ResponseEntity<Message> updatePasswordAdmin1(@RequestParam(value = "id") Long id, @RequestBody PasswordDto passwordDto) {
        User user = this.iUserService.findById(id);
            if (user != null) {
                if(!checkRegex(passwordDto)){
                    return new ResponseEntity<>(new Message("Mật khẩu không đúng định dạng"),HttpStatus.BAD_REQUEST);
                }else {
                    if (user.getPassword().matches(passwordDto.getOldPassword())) {
                        Boolean check = checkPassword(passwordDto.getNewPassword(), user.getPassword());
                        if (check) {
                            return new ResponseEntity<>(new Message("Mật khẩu mới trùng với mật khẩu cũ"), HttpStatus.BAD_REQUEST);
                        } else {
                            user.setPassword(passwordDto.getNewPassword());
                            this.iUserService.save(user);
                            return new ResponseEntity<>(new Message("Đổi mật khẩu thành công"), HttpStatus.OK);
                        }
                    } else {
                        return new ResponseEntity<>(new Message("Sai mật khẩu"), HttpStatus.BAD_REQUEST);
                    }
                }
            } else {
                return new ResponseEntity<>(new Message("không tìm thấy tài khoản"), HttpStatus.NOT_FOUND);
            }
    }

    Boolean checkPassword(String a, String b) {
        return a.equals(b);
    }
    Boolean checkRegex(PasswordDto passwordDto) {
        return Pattern.compile(REGEX).matcher(passwordDto.getOldPassword()).matches() && Pattern.compile(REGEX).matcher(passwordDto.getNewPassword()).matches() && Pattern.compile(REGEX).matcher(passwordDto.getConfirmNewPassword()).matches();
    }

}
