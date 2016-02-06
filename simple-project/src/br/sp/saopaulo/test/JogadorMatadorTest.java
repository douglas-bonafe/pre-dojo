package br.sp.saopaulo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.sp.saopaulo.model.Arma;
import br.sp.saopaulo.model.JogadorMatador;

public class JogadorMatadorTest {

	@Test
	public final void testaAdicionarArma() {
		Arma arma = new Arma();
		arma.setNome("B42");
		JogadorMatador jogador = new JogadorMatador();
		jogador.addArma(arma);
		assertTrue(jogador.contemArma(arma));
	}

	@Test
	public final void testaRemoverArmaInexistente() {
		JogadorMatador j = new JogadorMatador();
		assertTrue(j.removeArma(1) == null);
	}

	@Test
	public final void testaRemoverArmaExistente() {
		Arma arma = new Arma();
		arma.setNome("B42");
		JogadorMatador jogador = new JogadorMatador();
		jogador.addArma(arma);
		assertTrue(jogador.removeArma(0) == arma);
	}

	@Test
	public final void testaEncontrarArmaExistente() {
		Arma arma = new Arma("G120");
		arma.setNumeroDeMortesComEstaArma();
		JogadorMatador jm = new JogadorMatador();
		jm.addArma(arma);
		assertSame(arma, jm.findArmaPeloNome("G120"));
	}

	@Test
	public final void testaArmaComAQualMaisMatou() {
		Arma arma = new Arma("G120");
		Arma arma2 = new Arma("PO20");
		arma.setNumeroDeMortesComEstaArma();
		arma.setNumeroDeMortesComEstaArma();
		arma2.setNumeroDeMortesComEstaArma();
		JogadorMatador jm = new JogadorMatador();
		jm.addArma(arma);
		jm.addArma(arma2);
		assertSame(arma, jm.armaComAQualOJogadorMaisMatou());
	}

	@Test
	public final void testNumeroDeMortesProvocadas() {
		JogadorMatador jm = new JogadorMatador();
		assertTrue(0 == jm.getNumeroDeMortesProvocadas());
	}

}
