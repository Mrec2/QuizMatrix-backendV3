package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "questions")
//@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Question implements Serializable{

	@Serial
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "idQuestion", unique=true, nullable=false)
	private Long idQuestion;

	@Column(name = "questionClass")
    //@Size(max=100, message="Campo clasePregunta admite hasta 100 caracteres")
	private String questionClass;

	@Column(name = "bodyQuestion")
    //@Size(max=250, message="Campo clasePregunta admite hasta 250 caracteres")
	private String bodyQuestion;

	@OneToMany(fetch = FetchType.EAGER)
	List<Answer> answers;


}
