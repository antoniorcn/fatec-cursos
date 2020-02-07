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
@Table(name = "horarios")
@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;
		
	@Column(length=30)
	private String horario;
	
	@Column(name="criado_em")	
	private LocalDateTime criadoEm = LocalDateTime.now();
}
