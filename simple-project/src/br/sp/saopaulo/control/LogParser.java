package br.sp.saopaulo.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.sp.saopaulo.model.Arma;
import br.sp.saopaulo.model.JogadorMatador;
import br.sp.saopaulo.model.JogadorMorto;
import br.sp.saopaulo.model.Partida;

public class LogParser {

	private List<Partida> partidas = new ArrayList<Partida>();
	private Integer numeroDaPartida = new Integer(0);

	public boolean parse(String logFilePath) throws IOException {

		File file = new File(logFilePath);
		// Creates a FileReader Object
		FileReader input = new FileReader(file);
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;
		Partida partida = null;

		while ((myLine = bufRead.readLine()) != null) {
			String[] array = myLine.split(" - ");

			for (String s : array) {
				String[] fraseComNumeroDaPartida = null;
				if (s.contains("started")) {
					partida = new Partida();
					fraseComNumeroDaPartida = s.split("New match ");
					String aux = (fraseComNumeroDaPartida[1].split(" ")[0]);
					numeroDaPartida = Integer.parseInt(aux);
				}
				if (partida == null)
					continue;

				if (s.contains("killed")) {

					String nomeJogadorMatador = s.split(" ")[0];
					String nomeJogadorMorto = s.split(" ")[2];
					String armaUtilizada = s.split(" ")[4];

					if (nomeJogadorMatador.equals("<WORLD>"))
						continue;

					JogadorMatador jogadorMatador = new JogadorMatador();
					jogadorMatador.setNome(nomeJogadorMatador);
					jogadorMatador.setNumeroDeMortesProvocadas();
					Arma arma = new Arma(armaUtilizada);
					jogadorMatador.addArma(arma);

					JogadorMorto jogadorMorto = new JogadorMorto();
					jogadorMorto.setNome(nomeJogadorMorto);
					jogadorMorto.setNumeroDeVezesQueMorreu();

					arma.setNome(armaUtilizada);
					jogadorMatador.addArma(arma);

					partida.inicia(this.numeroDaPartida);
					partida.addJogador(jogadorMatador);
					partida.addJogador(jogadorMorto);

				}
				if (s.contains(numeroDaPartida.toString())
						&& s.contains("ended")) {
					partidas.add(partida);
				}
			}
		}

		input.close();
		return true;
	}

	public void addPartida(Partida p) {
		partidas.add(p);
	}

	public Partida removePartida(int index) {
		return partidas.remove(index);
	}

	public List<Partida> getListaDePartidas() {
		return partidas;
	}

	public Integer getNumeroDaPartida() {
		return numeroDaPartida;
	}

	public void setNumeroDaPartida(Integer numeroDaPartida) {
		this.numeroDaPartida = numeroDaPartida;
	}

	public static void main(String[] args) {
		//
		// if (args.length < 1) {
		// System.out.println("You need to pass the path of the file");
		// return;
		// }

		LogParser parser = new LogParser();
		try {
			// String logFilePath = args[0];
			String logFilePath = "log.txt";
			parser.parse(logFilePath);
		} catch (IOException ioException) {
			System.out.println("File cannot be read. Exception:" + ioException);
		}
		System.out.println("==================================");

		for (Partida p : parser.getListaDePartidas()) {
			p.showRankingMatadores();
			p.showRankingMortos();
		}

	}
}
