package com.bcserafim.homologacaoFornecedor.entities.enums;

public enum RegimeTributario {

	SIMPLES_NACIONAL(1),
	LUCRO_PRESUMIDO(2),
	LUCRO_REAL(3);
	
	private int code;
	
	private RegimeTributario(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static RegimeTributario valueOF(int code) {
		for (RegimeTributario value : RegimeTributario.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		 throw new IllegalArgumentException("Invalid RegimeTributario code");
	}
	
}
