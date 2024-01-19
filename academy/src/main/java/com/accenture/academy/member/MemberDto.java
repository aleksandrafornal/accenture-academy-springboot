package com.accenture.academy.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
}
