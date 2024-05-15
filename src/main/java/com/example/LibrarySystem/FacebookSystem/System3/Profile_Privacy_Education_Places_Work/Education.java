package com.example.LibrarySystem.FacebookSystem.System3.Profile_Privacy_Education_Places_Work;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Education {
    private String school;
    private String degree;
    private String description;
    private Date startDate;
    private Date endDate;
}
