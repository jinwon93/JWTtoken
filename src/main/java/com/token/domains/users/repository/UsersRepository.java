package com.token.domains.users.repository;

import com.token.domains.users.domain.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Long> {
    Optional<UsersEntity> findByUserId(String userId);
    boolean existsByUserId(String userId);
}
