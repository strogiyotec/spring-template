package com.template.model.entity;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
@Data
public class User {

    @Id
    private Integer id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;
    @Column("name")
    private String name;
    @Column("surname")
    private String surname;
    @Column("created_at")
    private Date createdAt;

}
