package com.giancarlo.serveur_avec_bd;

import com.giancarlo.serveur_avec_bd.service.CalculService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculApplicationTests {

	@Autowired
	private CalculService calculService;

	@Test
	void contextLoads() {
		assertNotNull(calculService);
	}

	@Test
	void testFibonacciSmallValues() {
		// Cas de base
		assertEquals(BigInteger.ZERO, calculService.fibonacci(0));
		assertEquals(BigInteger.ONE, calculService.fibonacci(1));
		assertEquals(BigInteger.ONE, calculService.fibonacci(2));
		assertEquals(BigInteger.valueOf(2), calculService.fibonacci(3));
		assertEquals(BigInteger.valueOf(3), calculService.fibonacci(4));
	}

	@Test
	void testFibonacciLargeValues() {
		// Vérifie que la méthode fonctionne pour de grandes valeurs
		assertDoesNotThrow(() -> {
			BigInteger result = calculService.fibonacci(1000);
			assertNotNull(result);
		});

		assertDoesNotThrow(() -> {
			BigInteger result = calculService.fibonacci(2000);
			assertNotNull(result);
		});
	}

	@Test
	void testFibonacciNegativeValue() {
		// Vérifie que la méthode lève une exception pour une valeur négative
		assertThrows(IllegalArgumentException.class, () -> calculService.fibonacci(-1));
	}
}