package br.sp.saopaulo.model;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Partida {

	private boolean iniciada;
	private int numeroDaPartida;
	private int quantidadeDeAssassinatos;
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public List<JogadorMatador> getRankingAssassinatosJogador() {
		if(jogadores == null ) return null;
		
		List<JogadorMatador> matadores = new ArrayList<JogadorMatador>();

		for (Jogador matador : jogadores) {
			if (matador instanceof JogadorMatador) {
				matadores.add((JogadorMatador) matador);
			}
		}

		Collections.sort(matadores);

		return matadores;
	}
	
	public JogadorMatador getCampeao(){
		List<JogadorMatador> list = getRankingAssassinatosJogador();
		return list.get(list.size() - 1);
	}

	public List<JogadorMorto> getRankingJogadoresMortos() {
		List<JogadorMorto> mortos = new ArrayList<JogadorMorto>();

		for (Jogador morto : jogadores) {
			if (morto instanceof JogadorMorto) {
				mortos.add((JogadorMorto) morto);
			}
		}

		Collections.sort(mortos);

		return mortos;
	}

	public Jogador getJogador(int index) {
		return jogadores.get(index);
	}

	public void addJogador(Jogador jogador) {
		
		JogadorMatador jmatador = new JogadorMatador();
		JogadorMorto jmorto = new JogadorMorto();
		
		for(int i=0; i<jogadores.size(); i++){
			if(jogadores.get(i).getNome().equalsIgnoreCase(jogador.getNome())){
				if(jogadores.get(i) instanceof JogadorMatador){
					jmatador = (JogadorMatador) jogadores.get(i);
					jmatador.setNumeroDeMortesProvocadas();
					return;
				}
				if(jogadores.get(i) instanceof JogadorMorto){
					jmorto = (JogadorMorto) jogadores.get(i);
					jmorto.setNumeroDeVezesQueMorreu();
					return;
				}
			}
		}
		jogadores.add(jogador);
	}

	public Jogador removeJogador(int index) {
		return jogadores.remove(index);
	}

	public Iterator<Jogador> iteratorJogador() {
		return jogadores.iterator();
	}

	public int findIndexJogadorPeloNome(String nome) {
		for (Jogador j : jogadores) {
			if (j.getNome().equals(nome))
				return jogadores.indexOf(j);
		}
		return -1;
	}

	public Jogador findJogadorPeloNome(String nome) {
		for (Jogador j : jogadores) {
			if (j.getNome().equals(nome))
				return j;
		}
		return null;
	}

	public int getNumeroDaPartida() {
		return numeroDaPartida;
	}

	public boolean isIniciada() {
		return iniciada;
	}

	public void inicia(int numeroDaPartida) {
		this.iniciada = true;
		this.numeroDaPartida = numeroDaPartida;
	}

	public void encerra() {
		this.iniciada = false;
	}

	public int getQuantidadeDeAssassinatos() {
		return quantidadeDeAssassinatos;
	}

	public void setQuantidadeDeAssassinatos(int quantidadeDeAssassinatos) {
		this.quantidadeDeAssassinatos = quantidadeDeAssassinatos;
	}

	public void showRankingMatadores() {
		for (Jogador j : this.getRankingAssassinatosJogador()) {
			System.out.print("Nome: ");
			System.out.println(j.getNome());
			System.out.print("Número de assassinatos: ");
			System.out.println(((JogadorMatador) j)
					.getNumeroDeMortesProvocadas());
		}
	}

	public void showRankingMortos() {
		for (Jogador j : this.getRankingJogadoresMortos()) {
			System.out.print("Nome: ");
			System.out.println(j.getNome());
			System.out.print("Número de vezes que morreu: ");
			System.out.println(((JogadorMorto) j).getNumeroDeVezesQueMorreu());
		}
	}

	public static void main(String[] args) {
		Partida p = new Partida();
		JogadorMatador jmat = new JogadorMatador();
		JogadorMorto jmorto = new JogadorMorto();
		jmat.setNome("João");
		jmat.setNumeroDeMortesProvocadas();
		System.out.println("Jogador:");
		System.out.println("nome: " + jmat.getNome());
		System.out.println("mortes provocadas: "
				+ jmat.getNumeroDeMortesProvocadas());
		jmorto.setNome("Maurício");
		jmorto.setNumeroDeVezesQueMorreu();
		System.out.println("Jogador:");
		System.out.println("nome: " + jmorto.getNome());
		System.out.println("mortes provocadas: "
				+ jmorto.getNumeroDeVezesQueMorreu());
		p.addJogador(jmorto);
		p.addJogador(jmat);

		System.out.println("Jogadores adicionados...");
		for (Jogador j : p.jogadores) {
			System.out.print(j.getNome() + ": ");
			if (j instanceof JogadorMorto)
				System.out.println("morto");
			else
				System.out.println("matador");
		}

		System.out.println("Jogadores matadores: ");
		for (Jogador j : p.getRankingAssassinatosJogador()) {
			System.out.println("=======================");
			System.out.print("Nome: ");
			System.out.println(j.getNome());
			System.out.print("Número de assassinatos: ");
			System.out.println(((JogadorMatador) j)
					.getNumeroDeMortesProvocadas());
			System.out.println("=======================");
		}

		System.out.println("Jogadores mortos: ");
		for (Jogador j : p.getRankingJogadoresMortos()) {
			System.out.println("=======================");
			System.out.print("Nome: ");
			System.out.println(j.getNome());
			System.out.print("Número de assassinatos: ");
			System.out.println(((JogadorMorto) j).getNumeroDeVezesQueMorreu());
			System.out.println("=======================");
		}
		
		System.out.println("O jogador campeão foi: " + p.getCampeao().getNome());
		System.out.println("A arma com a qual mais matou foi:");
		System.out.println(p.getCampeao().armaComAQualOJogadorMaisMatou());
		
	}

}
