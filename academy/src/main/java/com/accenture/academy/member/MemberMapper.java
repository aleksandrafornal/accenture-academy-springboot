package com.accenture.academy.member;

import com.accenture.academy.parish.ParishDao;
import com.accenture.academy.parish.ParishDto;

public class MemberMapper {
    public static MemberDao mapDtoToDao(MemberDto memberDto){
        return new MemberDao(
                memberDto.getFirstName(),
                memberDto.getLastName(),
                memberDto.getDateOfBirth()
        );
    }
}
