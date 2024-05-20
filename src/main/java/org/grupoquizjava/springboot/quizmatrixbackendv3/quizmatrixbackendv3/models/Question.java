package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "id_question", unique=true, nullable=false)
	private Long idQuestion;

	@Column(name = "question_class")
    //@Size(max=100, message="Campo clasePregunta admite hasta 100 caracteres")
	private String questionClass;

	@Column(name = "body_question")
    //@Size(max=250, message="Campo clasePregunta admite hasta 250 caracteres")
	private String bodyQuestion;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	@ToString.Exclude
	List<Answer> answers;


}
