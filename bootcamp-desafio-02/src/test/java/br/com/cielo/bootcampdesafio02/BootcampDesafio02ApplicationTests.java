package br.com.cielo.bootcampdesafio02;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class BootcampDesafio02ApplicationTests {

	@Test
	public void testApplicationMain() {

		assertDoesNotThrow(() -> BootcampDesafio02Application.main(new String[]{}));
	}


}
