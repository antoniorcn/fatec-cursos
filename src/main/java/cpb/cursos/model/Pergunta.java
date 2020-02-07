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
@Table(name = "perguntas")
@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pergunta {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column
	private long indice;
	
	@Column(length=30)
	private String texto = "";
	
	@Column(length=30)
	private String valor = "";
	
	@Column(length=255)
	private String descricao = "";
	
	@Column(name = "espec_precisa")
	private boolean especialistaPrecisa;
	
	@Column(name = "espec_texto", length=100)
	private String especialistaTexto;
	
	@Column(name = "espec_variable", length=30)
	private String especialistaVariable;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@Column(name="criado_em")	
	private LocalDateTime criadoEm = LocalDateTime.now();
}
