package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int iduser;

    @Column(name = "nameuser")
    private String nameuser;

    @Column(name = "emailuser")
    private String emailuser;

    @Column(name = "passworduser")
    private String passworduser;

}
