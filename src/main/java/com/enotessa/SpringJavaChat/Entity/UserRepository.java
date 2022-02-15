package com.enotessa.SpringJavaChat.Entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserName(String name);
    List<UserEntity> findByRole(String role);
}
