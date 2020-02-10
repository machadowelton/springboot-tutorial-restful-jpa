package br.com.tutorial.domain.enums;

public enum ETipoTelefone {
	
	MOVEL("MOVEL"), FIXO("FIXO");
	
	
	private final String valueStr;
	
	private ETipoTelefone(String valueStr) {
		this.valueStr = valueStr;
	}

	public String getValueStr() {
		return valueStr;
	}		
	
}
