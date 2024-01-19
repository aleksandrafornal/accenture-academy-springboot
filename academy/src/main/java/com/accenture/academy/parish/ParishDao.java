package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.PriestDao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "PARICH")
@NoArgsConstructor
public class ParishDao {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private PriestDao priestDao;
    @OneToOne
    private ChurchDao churchDao;
    @OneToMany
    @JoinColumn(name = "parish_id")
    private Set<MemberDao> members;

    public ParishDao(PriestDao priestDao, ChurchDao churchDao, Set<MemberDao> members) {
        this.priestDao = priestDao;
        this.churchDao = churchDao;
        this.members = members;
    }
}
