package com.laba1.Bean;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bean {
    private  String  message = "JavaBean компонент приветствует Вас!";
    SessionFactory sf =  new AnnotationConfiguration().configure().buildSessionFactory();
    Session s = sf.openSession();
}