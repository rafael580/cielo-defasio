package br.com.cielo.bootcampdesafio01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class BootcampDesafio01ApplicationTests {

	@Test
	public void testApplicationMain() {
		// Este teste verifica se a classe principal pode ser executada sem lançar exceções.
		assertDoesNotThrow(() -> BootcampDesafio01Application.main(new String[]{}));
	}

}
