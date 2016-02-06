package br.sp.saopaulo.view;

import java.io.IOException;

import br.sp.saopaulo.control.LogParser;
import br.sp.saopaulo.model.Partida;

public class Programa {

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("You need to pass the path of the file");
			return;
		}

		LogParser parser = new LogParser();
		try {
			String logFilePath = args[0];
			// String logFilePath = "log.txt";
			parser.parse(logFilePath);
		} catch (IOException ioException) {
			System.out.println("File cannot be read. Exception:" + ioException);
		}
		System.out.println("==================================");
		System.out.println("INÍCIO DA CONTAGEM");

		for (Partida p : parser.getListaDePartidas()) {
			System.out.println("***************************");
			System.out.println("Partida de número " + p.getNumeroDaPartida());

			System.out.println("---------------------------");
			System.out.println("Jogadores matadores: ");
			System.out.println("---------------------------");
			p.showRankingMatadores();
			System.out.println("---------------------------");
			System.out.println("Jogadores mortos: ");
			System.out.println("---------------------------");
			p.showRankingMortos();
			System.out.println("Fim da partida de número "
					+ p.getNumeroDaPartida());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Jogador Campeão: " + p.getCampeao().getNome());
			System.out.println("Número de vezes que matou: "
					+ p.getCampeao().getNumeroDeMortesProvocadas());
			System.out.println("Arma com a qual mais matou: "
					+ p.getCampeao().armaComAQualOJogadorMaisMatou().getNome());
			System.out.println("Número de vezes que matou com essa arma: "
					+ p.getCampeao().armaComAQualOJogadorMaisMatou()
							.getNumeroDeMortesComEstaArma());
		}

	}
}
