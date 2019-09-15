package com.laba1.Entity;

import lombok.*;
import javax.persistence.*;

/**
 * A simple JavaBean , представляющий рейтинг игр разных пользователей
 *
 * @author Zdornov Maxim
 * @version 1.0
 */


@Table(name = "rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "countgame")
    private Integer countgame;

    @Column(name = "allAttempt")
    private Integer allAttempt;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User users;

    public Rating(Integer countgame, Integer allAttempt, User user) {
        this.countgame = countgame;
        this.allAttempt = allAttempt;
        this.users = user;
    }
}
