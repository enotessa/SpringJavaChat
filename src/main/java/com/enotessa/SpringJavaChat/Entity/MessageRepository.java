package com.enotessa.SpringJavaChat.Entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
    List<MessageEntity> findAllByOrderByIdDesc();

}
