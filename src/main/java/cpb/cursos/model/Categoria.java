package cpb.cursos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categorias")
@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column
	private long indice;
	
	@Column(length=30)
	private String texto = "";
	
	public CategoriaDTO generateDTO() {
		CategoriaDTO cDto = new CategoriaDTO();
		cDto.setIndice(this.indice);
		cDto.setTexto(this.texto);
		List<Resposta> respostas = new ArrayList<>();
		cDto.setRespostas(respostas);
		return cDto;
	}
}
