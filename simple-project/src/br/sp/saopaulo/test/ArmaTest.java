package br.sp.saopaulo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.sp.saopaulo.model.Arma;

public class ArmaTest {

	@Test
	public final void testaNomeDaArma() {
		Arma arma = new Arma();
		arma.setNome("Nome");
		assertTrue(arma.getNome().equals("Nome"));
	}

}
