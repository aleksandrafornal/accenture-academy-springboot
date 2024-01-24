package com.accenture.academy.parish;

import com.accenture.academy.cementary.CementaryDao;
import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.PriestDao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "PARISH")
@NoArgsConstructor
public class ParishDao {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private PriestDao priestDao;
    @OneToOne(cascade = CascadeType.ALL)
    private ChurchDao churchDao;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parish_id")
    private Set<MemberDao> members;

    @OneToOne(cascade = CascadeType.ALL)
    private CementaryDao cementaryDao;

    public ParishDao(String name, PriestDao priestDao, ChurchDao churchDao, Set<MemberDao> members, CementaryDao cementaryDao) {
        this.name = name;
        this.priestDao = priestDao;
        this.churchDao = churchDao;
        this.members = members;
        this.cementaryDao = cementaryDao;
    }
}
