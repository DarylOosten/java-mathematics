package problems.various.pythagorean_triplets;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * A Pythagorean triple consists of three positive integers a, b, and c, such
 * that a^2 + b^2 = c^2. A well-known example is (3, 4, 5).
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Pythagorean_triple">Wikipedia</a>
 * @author daryl
 *
 */
public class PythagoreanTriplets {

	/**
	 * Finds the first Pythagorean triplet found in the given candidates. It does so
	 * in O(n^2) time complexity and O(n) space complexity.
	 * 
	 * @param candidates from which to pick three numbers that form a triplet.
	 * @return the first triplet found, or null if no triplet is found.
	 */
	@Nullable
	public int[] findTriplet(@Nullable int[] candidates) {
		// Early out if it is not possible to find a triplet.
		if (candidates == null || candidates.length < 3) {
			return null;
		}

		// First we pre-compute the possible results for the right-hand side of the
		// equation, so we can reuse these while solving the left-hand side and quickly
		// retrieve the solution.
		// Also we take the opportunity for input validation.
		Map<Integer, Integer> squaredCandidates = new HashMap<>();
		for (int candidate : candidates) {
			if (candidate < 1) {
				throw new IllegalArgumentException(
						"Only positive numbers are allowed, but candidates contains " + candidate);
			}

			int candidateSquared = (int) Math.pow(candidate, 2);
			if (squaredCandidates.containsKey(candidateSquared)) {
				throw new IllegalArgumentException(
						"Duplicate values are not allowed, but " + candidate + " was found twice.");
			}
			squaredCandidates.put(candidateSquared, candidate);
		}

		// Then go through the possible unique combinations for the left-hand side of
		// the equation, and see if we can find a solution.
		for (int i = 0; i < candidates.length; i++) {
			int a = candidates[i];
			int aSquared = (int) Math.pow(a, 2);

			for (int j = 0; j < i; j++) {
				int b = candidates[j];
				int bSquared = (int) Math.pow(b, 2);

				int sumAbSquared = aSquared + bSquared;
				if (!squaredCandidates.containsKey(sumAbSquared)) {
					continue;
				}

				int c = squaredCandidates.get(sumAbSquared);
				return new int[] { a, b, c };
			}
		}

		// No solution found.
		return null;
	}
}
