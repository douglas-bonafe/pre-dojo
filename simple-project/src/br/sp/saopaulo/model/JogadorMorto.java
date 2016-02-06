package br.sp.saopaulo.model;

public class JogadorMorto extends Jogador implements Comparable<JogadorMorto> {

	private Integer numeroDeVezesQueMorreu = 0;

	public JogadorMorto() {
		this.numeroDeVezesQueMorreu++;
	}

	public Integer getNumeroDeVezesQueMorreu() {
		return numeroDeVezesQueMorreu;
	}

	public void setNumeroDeVezesQueMorreu() {
		numeroDeVezesQueMorreu++;
	}

	@Override
	public int compareTo(JogadorMorto outro) {
		if (this.numeroDeVezesQueMorreu < outro.getNumeroDeVezesQueMorreu())
			return -1;
		if (this.numeroDeVezesQueMorreu > outro.getNumeroDeVezesQueMorreu())
			return 1;
		else
			return 0;
	}

}
