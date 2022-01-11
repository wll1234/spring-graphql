package com.example.springgraphql.repository;

import com.example.springgraphql.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Role findByMemberId(int memberId);
}
