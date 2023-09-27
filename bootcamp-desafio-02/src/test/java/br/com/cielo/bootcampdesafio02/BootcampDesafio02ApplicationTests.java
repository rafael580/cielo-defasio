package br.com.cielo.bootcampdesafio02;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class BootcampDesafio02ApplicationTests {

	@Test
	public void testApplicationMain() {
		// Este teste verifica se a classe principal pode ser executada sem lançar exceções.
		assertDoesNotThrow(() -> BootcampDesafio02Application.main(new String[]{}));
	}


}
