package problems.various.pythagorean_triplets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PythagoreanTripletsTest {

	@Test
	void testTriplet() {
		PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets();
		int[] result = pythagoreanTriplets.findTriplet(new int[] { 3, 4, 5 });
		Assertions.assertArrayEquals(new int[] { 4, 3, 5 }, result);
	}

	@Test
	void testAdditionalNumbers() {
		PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets();
		int[] result = pythagoreanTriplets.findTriplet(new int[] { 1, 2, 3, 4, 5, 6 });
		Assertions.assertArrayEquals(new int[] { 4, 3, 5 }, result);
	}

	@Test
	void testEmptyInput() {
		PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets();
		int[] result = pythagoreanTriplets.findTriplet(new int[] {});
		Assertions.assertNull(result);
	}

	@Test
	void testThrowsIllegalArgumentOnZero() {
		PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> pythagoreanTriplets.findTriplet(new int[] { 0, 1, 2 }));
	}

	@Test
	void testThrowsIllegalArgumentOnDuplicate() {
		PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> pythagoreanTriplets.findTriplet(new int[] { 1, 1, 1 }));
	}
}
