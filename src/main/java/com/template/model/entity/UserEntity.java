package com.template.model.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Data
@Builder
public class UserEntity {

    @Id
    private Integer id;

    @Column("username")
    private String username;

    @Column("email")
    private String email;

    @Column("password")
    private String password;
    @Column("name")
    private String name;
    @Column("surname")
    private String surname;
    @Column("created_at")
    private Date createdAt;

}
