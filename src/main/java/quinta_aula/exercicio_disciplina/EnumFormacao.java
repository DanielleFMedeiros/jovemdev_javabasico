package quinta_aula.exercicio_disciplina;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumFormacao {
	GRADUACAO,
    ESPECIALIZACAO,
    POS_GRADUACAO;
    
	private int codigo;
	private String descricao;

	public static EnumFormacao findById(int codigo) {
		for (EnumFormacao formacao : EnumFormacao.values()) {
			if (codigo == formacao.codigo) {
				return formacao;
			}
		}
		return null;
	}

}
