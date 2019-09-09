package com.laba1.Entity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "users")
public class User  implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;
    @Basic
    @Column(length = 50)
    private String login;
    @Basic
    @Column(length = 50)
    private String password;
}
