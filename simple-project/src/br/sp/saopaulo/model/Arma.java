package br.sp.saopaulo.model;

public class Arma implements Comparable<Arma> {

	private String nome;
	private int numeroDeMortesComEstaArma;

	public Arma() {
	}

	public Arma(String nomeDaArma) {
		this.nome = nomeDaArma;
	}

	public int getNumeroDeMortesComEstaArma() {
		return numeroDeMortesComEstaArma;
	}

	public void setNumeroDeMortesComEstaArma() {
		this.numeroDeMortesComEstaArma++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Arma other) {
		if (this.numeroDeMortesComEstaArma < other.numeroDeMortesComEstaArma)
			return -1;
		if (this.numeroDeMortesComEstaArma > other.numeroDeMortesComEstaArma)
			return 1;
		else
			return 0;
	}

}
