package br.sp.saopaulo.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.sp.saopaulo.control.LogParser;
import br.sp.saopaulo.model.Jogador;
import br.sp.saopaulo.model.JogadorMatador;
import br.sp.saopaulo.model.Partida;

public class PartidaTest {

	@Test
	public final void testaRankingAssassinatosJogador() {
		LogParser parser = new LogParser();
		try {
			String logFilePath = "log.txt";
			parser.parse(logFilePath);
		} catch (IOException ioException) {
		}

		for (Partida p : parser.getListaDePartidas()) {
			assertTrue(p.getRankingAssassinatosJogador() != null);
			for (JogadorMatador m : p.getRankingAssassinatosJogador()) {
				assertTrue(m instanceof JogadorMatador);
			}
			for (int i = 0; i < p.getRankingAssassinatosJogador().size() - 1; i++) {
				assertTrue(p.getRankingAssassinatosJogador().get(i)
						.getNumeroDeMortesProvocadas() <= p
						.getRankingAssassinatosJogador().get(i + 1)
						.getNumeroDeMortesProvocadas());
			}
		}

	}

	@Test
	public final void testaCampeao() {
		LogParser parser = new LogParser();

		try {
			String logFilePath = "log.txt";
			parser.parse(logFilePath);
		} catch (IOException ioException) {
		}

		for (Partida p : parser.getListaDePartidas()) {
			for (int i = 0; i < p.getRankingAssassinatosJogador().size() - 1; i++) {
				assertTrue(p.getRankingAssassinatosJogador().get(i)
						.getNumeroDeMortesProvocadas() <= p
						.getRankingAssassinatosJogador().get(i + 1)
						.getNumeroDeMortesProvocadas());
			}
		}
	}
	

}
