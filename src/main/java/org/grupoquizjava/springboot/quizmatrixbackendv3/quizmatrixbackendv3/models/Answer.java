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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @Column(name = "idAnswer", unique=true, nullable=false)
	private Long idAnswer;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idQuestion")
    private Question question;

	@Column(name = "bodyAnswer")
	private String bodyAnswer;

	@Column(name = "right")
	private boolean right;



}
