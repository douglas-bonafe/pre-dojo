package br.sp.saopaulo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JogadorMatador extends Jogador implements
		Comparable<JogadorMatador> {

	private Integer numeroDeMortesProvocadas = 0;
	private List<Arma> armas = new ArrayList<Arma>();

	public void addArma(Arma a) {
		for (Arma arma : armas) {
			if (a.getNome().equals(arma.getNome())) {
				arma.setNumeroDeMortesComEstaArma();
				return;
			}
		}
		armas.add(a);
	}

	public Arma removeArma(int index) {
		if(!armas.isEmpty() && index < armas.size())
			return armas.remove(index);
		return null;
	}

	public Iterator<Arma> iteratorArmas() {
		return armas.iterator();
	}

	public Arma findArmaPeloNome(String nome) {
		for (Arma a : armas) {
			if (a.getNome().equalsIgnoreCase(nome)) {
				return a;
			}
		}
		return null;
	}

	public List<Arma> ordena() {
		Collections.sort(armas);
		return armas;
	}

	public Arma armaComAQualOJogadorMaisMatou() {
		if (armas != null) {
			List<Arma> armas = ordena();
			return armas.get(armas.size() - 1);
		} else
			return null;
	}

	public Integer getNumeroDeMortesProvocadas() {
		return numeroDeMortesProvocadas;
	}

	public void setNumeroDeMortesProvocadas() {
		numeroDeMortesProvocadas++;
	}

	@Override
	public int compareTo(JogadorMatador outro) {
		if (this.numeroDeMortesProvocadas < outro.getNumeroDeMortesProvocadas())
			return -1;
		if (this.numeroDeMortesProvocadas > outro.getNumeroDeMortesProvocadas())
			return 1;
		else
			return 0;
	}

	public static void main(String args[]) {
		JogadorMatador jm = new JogadorMatador();
		jm.setNome("João");
		jm.setNumeroDeMortesProvocadas();
		System.out.println("Jogador:");
		System.out.println("nome: " + jm.getNome());
		System.out.println("mortes provocadas: "
				+ jm.getNumeroDeMortesProvocadas());
		Arma arma = new Arma("B12");
		arma.setNumeroDeMortesComEstaArma();
		Arma arma2 = new Arma("A12");
		arma2.setNumeroDeMortesComEstaArma();
		arma.setNumeroDeMortesComEstaArma();
		Arma arma3 = new Arma("B15");
		arma.setNumeroDeMortesComEstaArma();
		arma2.setNumeroDeMortesComEstaArma();
		arma3.setNumeroDeMortesComEstaArma();
		arma3.setNumeroDeMortesComEstaArma();
		arma3.setNumeroDeMortesComEstaArma();
		arma3.setNumeroDeMortesComEstaArma();

		jm.addArma(arma);
		jm.addArma(arma3);
		jm.addArma(arma2);

		System.out.println("------------------\nArmas:");
		for (Arma a : jm.armas) {
			System.out.print(a.getNome() + ": ");
			System.out.println(a.getNumeroDeMortesComEstaArma());

		}

		System.out.println("------------------\nArmas:");
		for (Arma a : jm.ordena()) {
			System.out.print(a.getNome() + ": ");
			System.out.println(a.getNumeroDeMortesComEstaArma());

		}

		System.out
				.println("----------------------\nA arma que mais matou foi:");
		Arma armaQueMaisMatou = jm.armaComAQualOJogadorMaisMatou();
		System.out.println("Nome: " + armaQueMaisMatou.getNome());
		System.out.println("Quantidade de mortes: "
				+ armaQueMaisMatou.getNumeroDeMortesComEstaArma());

	}

	public boolean contemArma(Arma arma) {
		if (armas.contains(arma))
			return true;
		return false;
	}
}
