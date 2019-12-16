package com.laba1.Entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Maks
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    @NotNull
    private Integer id;

    @Column(length = 50)
    private String login;

    @Column(length = 50)
    private String password;

    @Column(name = "youNumber")
    private String youNumber;


    @OneToOne(mappedBy = "users", fetch = FetchType.LAZY)
    private Rating rating;

    public User(String login, String password, String youNumber) {
        this.login = login;
        this.password = password;
        this.youNumber = youNumber;
    }


}
