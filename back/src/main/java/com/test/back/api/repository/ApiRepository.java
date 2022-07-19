package com.test.back.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.test.back.api.entity.Member;

public interface ApiRepository extends JpaRepository<Member, Long>, ApiRepositoryTemplate {

}
