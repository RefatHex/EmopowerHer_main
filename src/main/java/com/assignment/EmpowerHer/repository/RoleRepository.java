package com.assignment.EmpowerHer.repository;

import java.util.Optional;

import com.assignment.EmpowerHer.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.EmpowerHer.models.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}