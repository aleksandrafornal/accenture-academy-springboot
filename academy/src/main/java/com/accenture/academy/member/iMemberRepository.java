package com.accenture.academy.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface iMemberRepository extends JpaRepository<MemberDao, Long> {
}
