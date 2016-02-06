package br.sp.saopaulo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.sp.saopaulo.model.JogadorMatador;
import br.sp.saopaulo.model.JogadorMorto;

public class JogadorMortoTest {

	@Test
	public final void testConstructor() {
		JogadorMorto jm = new JogadorMorto();
		assertTrue(jm.getNumeroDeVezesQueMorreu() == 1);
	}

}
