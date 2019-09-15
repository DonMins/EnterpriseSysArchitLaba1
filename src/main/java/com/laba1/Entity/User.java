package com.laba1.Entity;
import com.sun.istack.internal.NotNull;
import lombok.*;
import org.jboss.logging.Field;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator( name = "player_sequence", sequenceName = "player_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "player_sequence" )
    @Column(unique = true)
    @NotNull
    private Integer id;

    @Column(length = 50)
    private String login;

    @Column(length = 50)
    private String password;

    @Column(name = "youNumber")
    private String youNumber;

    @Transient
    @OneToOne(mappedBy = "users", fetch=FetchType.LAZY)
    private Rating rating;

    public User(String login, String password, String youNumber) {
        this.login = login;
        this.password = password;
        this.youNumber = youNumber;
    }
}
