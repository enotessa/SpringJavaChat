package com.enotessa.SpringJavaChat.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGES")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", length = 1000, nullable = false)
    private Long id;
    @Column(name = "user_name", length = 20, nullable = false)
    private String userName;
    @Column(name = "message", length = 1000)
    private String message;
    @Column(name = "time", length = 30)
    private Date time;

    public MessageEntity(){}


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString(){
        return this.getUserName()+' '+this.getMessage();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
