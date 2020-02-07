package cpb.cursos.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Questionario {
	
	private long id;
	private Contato contato = new Contato();
	
	private List<Resposta> respostas = new ArrayList<>();
	
	
	public Questionario(List<Pergunta> perguntas) { 
		for (Pergunta p : perguntas) {
			respostas.add(new Resposta());
		}
	}
}
