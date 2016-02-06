package br.sp.saopaulo.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.sp.saopaulo.control.LogParser;

public class LogParserTest {

	@Test
	public final void testaParser() {
		LogParser parser = new LogParser();

		try {
			String logFilePath = "log.txt";
			assertTrue(parser.parse(logFilePath));
		} catch (IOException ioException) {
		}
	}

}
