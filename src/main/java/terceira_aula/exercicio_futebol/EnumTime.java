package terceira_aula.exercicio_futebol;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumTime {
		
	FLAMENGO(1, "Flamengo"),
	VASCO(2, "Vasco"),
	CORINTHIANS(3, "Corinthians"),
	SAOPAULO(4, "São Paulo"),
	PALMEIRAS(5, "Palmeiras");
	
	
	private int codigo;
	private String descricao;
	
	
	public static EnumTime findById(int codigo) {
		for (EnumTime nomeTime : EnumTime.values()) {
			if(codigo == nomeTime.codigo) {
				return nomeTime;
			}
		}
		return null;
	}

}
