package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "answers")
//@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Answer implements Serializable{

	@Serial
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id_answer", unique=true, nullable=false)
	private Long idAnswer;


	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_question")
	@ToString.Exclude
    private Question question;


	@Column(name = "body_answer")
	private String bodyAnswer;

	@Column(name = "right")
	private boolean right;



}
