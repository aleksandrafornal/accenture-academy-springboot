package com.accenture.academy.parish;

import com.accenture.academy.cementary.CementaryDao;
import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.PriestDao;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ParishDto {
    private String name;
    private PriestDao priestDao;
    private ChurchDao churchDao;
    private Set<MemberDao> members;
    private CementaryDao cementaryDao;
}
