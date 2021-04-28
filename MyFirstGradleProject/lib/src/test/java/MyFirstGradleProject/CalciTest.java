package MyFirstGradleProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalciTest {

	static Calculator calc;

	@BeforeAll
	static void initAll() {
		System.out.println("BeforeAll");
		calc = new Calculator();
	}

	@BeforeEach
	void init() {
		System.out.println("BeforeEach");
		calc = new Calculator();
	}

	@Test
	void addTest() {
		// Calculator calci = new Calculator();
		System.out.println("Test");
		assertEquals(40, calc.add(20, 20));
	}

	@Test
	void subTest() {
		// Calculator calci = new Calculator();
		System.out.println("Test");
		assertEquals(0, calc.sub(20, 20));
	}

	@Test
	// @Disabled will dissable the specified test
	void mulTest() {
		// Calculator calci = new Calculator();
		System.out.println("Test");
		assertEquals(400, calc.mul(20, 20));
	}

	@Test
	void isEvenTest() {
		System.out.println("Test");
		assertTrue(calc.isEven(5));
	}

	@AfterEach
	void tearDown() {
		System.out.println("AfterEach");
		calc = new Calculator();
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("AfterAll");
		calc = null;
		// if your using afterAll then you can remove Calculator calci = new
		// Calculator(); from every line so that the heap memory wont be filled with
		// multiple objects.
		// and this also provides link between the connections
		// Its a clean up activity

	}

}
