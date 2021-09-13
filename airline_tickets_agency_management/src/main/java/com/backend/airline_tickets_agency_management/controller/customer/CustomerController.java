package com.backend.airline_tickets_agency_management.controller.customer;

import com.backend.airline_tickets_agency_management.model.dto.password.Message;
import com.backend.airline_tickets_agency_management.model.dto.password.PasswordDto;
import com.backend.airline_tickets_agency_management.model.entity.user.User;
import com.backend.airline_tickets_agency_management.model.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/customer")
public class CustomerController {
    private static String REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$";


    @Autowired
    private IUserService userService;

    @GetMapping("/findCustomerById")
    public ResponseEntity<User> getAdminById(@RequestParam(value = "id") Long id) {
        User user = this.userService.findById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/changePassword")
    public ResponseEntity<Message> updatePasswordAdmin1(@RequestParam(value = "id") Long id, @RequestBody PasswordDto passwordDto) {
        User user = this.userService.findById(id);
        System.out.println(passwordDto.getNewPassword());
        System.out.println(passwordDto.getOldPassword());
        System.out.println(user.getPassword());
        System.out.println(passwordDto.getConfirmPassword());
        if (user != null) {
            if (!checkRegex(passwordDto)) {
                return new ResponseEntity<>(new Message("Mật khẩu không đúng định dạng"), HttpStatus.BAD_REQUEST);
            } else {
                Boolean comparePassword = compareRawPasswordAndEncoderPassword(passwordDto.getOldPassword(), user.getPassword());
                if (comparePassword) {
                    Boolean comparePassword1 = compareRawPasswordAndEncoderPassword(passwordDto.getNewPassword(), user.getPassword());
                    if (comparePassword1) {
                        return new ResponseEntity<>(new Message("Mật khẩu mới trùng với mật khẩu cũ"), HttpStatus.BAD_REQUEST);
                    } else {
                        String newPasswordEncoder =encoderPassword(passwordDto.getNewPassword());
                        user.setPassword(newPasswordEncoder);
                        this.userService.save(user);
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

    Boolean compareRawPasswordAndEncoderPassword(String rawPassword, String encoderPassword) {
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        return cryptPasswordEncoder.matches(rawPassword, encoderPassword);
    }

    Boolean checkRegex(PasswordDto passwordDto) {
        return Pattern.compile(REGEX_PASSWORD).matcher(passwordDto.getOldPassword()).matches() && Pattern.compile(REGEX_PASSWORD).matcher(passwordDto.getNewPassword()).matches() && Pattern.compile(REGEX_PASSWORD).matcher(passwordDto.getConfirmPassword()).matches();
    }

    String encoderPassword(String password) {
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        return cryptPasswordEncoder.encode(password);
    }

}