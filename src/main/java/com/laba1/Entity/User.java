package com.laba1.Entity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Basic
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name ="login" ,length = 50)
    private String login;
    @Basic
    @Column(name = "password", length = 50)
    private String password;
}
