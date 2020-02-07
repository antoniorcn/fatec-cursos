package cpb.cursos.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "respostas")
@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Resposta {
	
	public Resposta(Pergunta p) {
		this.pergunta = p;
		this.setEspecialistaPergunta(p.getEspecialistaTexto());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	@ManyToOne
	@JoinColumn(name = "pergunta_id")
	private Pergunta pergunta;
	
	@Column(name="pergunta_espec", length=255)
	private String especialistaPergunta;

	@Column(name="criado_em")	
	private LocalDateTime criadoEm = LocalDateTime.now();
}
