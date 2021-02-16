package com.myBatis.EmployeeCrud.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employees {
    @Id
    private int emp_id;
    private String first_name;
    private String last_name;
    private String gender;
    private Date dob;
    private String pan_num;
    private String aadhaar_num;
    private String mobile_num;
    private String email_id;
    private String office_mail;
    private String permanent_address;
    private String present_address;
    private String blood_group;
    private String profile_pict;
    private Date doj;
    private int emp_level;
    private String post_name;
    private int basic_pay;
    private int house_allowance;

}
