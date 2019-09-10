package com.laba1.Entity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "users")
public class User  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 50 )
    private String login;

    @Column(length = 50)
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
