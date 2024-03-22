package org.jfree.data.junit;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {

	private Range lowerBoundJustBelowMaximumRange;
	private Range lowerBoundAtMinimumRange;
	private Range invalidLengthNaNRange;
	private Range invalidLengthNegativeInfinityRange;
	private Range invalidLengthPositiveInfinityRange;
	private Range invalidUpperBoundNaNRange;
	private Range invalidLengthAtMinimumRange;
	private Range invalidLengthAtMaximumRange;
	private Range invalidLowerBoundNaNRange;
	private Range lowerBoundJustAboveMinimumRange;
	private Range singlePointLengthRange;
	private Range validWithPositiveLengthRange;
	private Range validUpperBoundRange;
	private Range validLowerBoundRange;
	private Range upperBoundJustAboveMinimumRange;
	private Range upperBoundJustBelowMaximumRange;
	private Range upperBoundAtMaximumRange;
	private Range pointRangeAtZero;
	private Range maxSizeRange;
	private Range rangeZeroToFive;
	private Range rangeFiveToTen;
	private Range rangeTwoToEight;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() {
		lowerBoundJustBelowMaximumRange = new Range(Double.MAX_VALUE / 2, Double.MAX_VALUE);
		lowerBoundAtMinimumRange = new Range(-Double.MAX_VALUE, 10.0);
		invalidLengthNaNRange = new Range(Double.NaN, Double.NaN);
		invalidLengthNegativeInfinityRange = new Range(Double.NEGATIVE_INFINITY, 0.0);
		invalidLengthPositiveInfinityRange = new Range(0.0, Double.POSITIVE_INFINITY);
		invalidUpperBoundNaNRange = new Range(0.0, Double.NaN);
		invalidLengthAtMinimumRange = new Range(-Double.MAX_VALUE, 0.0);
		invalidLengthAtMaximumRange = new Range(0.0, Double.MAX_VALUE);
		invalidLowerBoundNaNRange = new Range(Double.NaN, 10.0);
		lowerBoundJustAboveMinimumRange = new Range(-Double.MAX_VALUE / 2, 10.0);
		singlePointLengthRange = new Range(3.0, 3.0);
		validWithPositiveLengthRange = new Range(0.0, 10.0);
		validUpperBoundRange = new Range(0.0, 10.0);
		validLowerBoundRange = new Range(0.0, 10.0);
		upperBoundJustAboveMinimumRange = new Range(-Double.MAX_VALUE, -Double.MAX_VALUE / 2);
		upperBoundJustBelowMaximumRange = new Range(0.0, Double.MAX_VALUE / 2);
		upperBoundAtMaximumRange = new Range(0.0, Double.MAX_VALUE);
		pointRangeAtZero = new Range(0, 0);
		maxSizeRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
		rangeZeroToFive = new Range(0, 5);
		rangeFiveToTen = new Range(5, 10);
		rangeTwoToEight = new Range(2, 8);
	}

	/**
	 * This method contains a JUnit test case for the `getLowerBound()` method in
	 * the `Range` class.
	 * It gets a lower bounds near the MAX_VALUE from a `Range` object.
	 */
	@Test
	public void testLowerBoundJustBelowMaximum() {
		// Test whether the lower bound of the Range object is equal to
		// Double.MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// MAX_VALUE.
		// Therefore, we divide the MAX_VALUE by two to give us a number close to the
		// MAX_VALUE.
		assertEquals(Double.MAX_VALUE / 2, lowerBoundJustBelowMaximumRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * It gets a lower bounds near the -MAX_VALUE from a `Range` object.
	 */
	@Test
	public void testLowerBoundAtMinimum() {
		// Test whether the lower bound of the Range object is equal to
		// -Double.MAX_VALUE.
		assertEquals(-Double.MAX_VALUE, lowerBoundAtMinimumRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a NaN lower and upper
	 * bound.
	 */
	@Test
	public void testInvalidRangeLengthNaN() {
		// Test whether the length of the Range object is NaN.
		assertTrue(Double.isNaN(invalidLengthNaNRange.getLength()));
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between NEGATIVE_INFINITY and
	 * normal value.
	 */
	@Test
	public void testInvalidRangeLengthNegativeInfinity() {
		// Test whether the length of the Range object is Double.POSITIVE_INFINITY.
		assertEquals(Double.POSITIVE_INFINITY, invalidLengthNegativeInfinityRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a normal value and
	 * POSITIVE_INFINITY.
	 */
	@Test
	public void testInvalidRangeLengthPositiveInfinityTest() {
		// Test whether the length of the Range object is Double.POSITIVE_INFINITY.
		assertEquals(Double.POSITIVE_INFINITY, invalidLengthPositiveInfinityRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of NaN upper bounds from a `Range` object.
	 */
	@Test
	public void testInvalidUpperBoundNaN() {
		// Test whether the upper bound of the Range object is NaN.
		assertEquals(Double.NaN, invalidUpperBoundNaNRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a -MAX_VALUE and normal
	 * value.
	 */
	@Test
	public void testInvalidRangeLengthAtMinimumTest() {
		// Test whether the length of the Range object is equal to Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, invalidLengthAtMinimumRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a normal values and
	 * MAX_VALUE.
	 */
	@Test
	public void testInvalidRangeLengthAtMaximumTest() {
		// Test whether the length of the Range object is equal to Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, invalidLengthAtMaximumRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a NaN lower bound in a `Range` object.
	 */
	@Test
	public void testInvalidLowerBoundNaN() {
		// Test whether the lower bound of the Range object is NaN as expected.
		assertEquals(Double.NaN, invalidLowerBoundNaNRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a value near the -MAX_VALUE in the `Range`
	 * object.
	 */
	@Test
	public void testLowerBoundJustAboveMinimum() {
		// Test whether the lower bound of the Range object is equal to -MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// -MAX_VALUE.
		// Therefore, we divide the -MAX_VALUE by two to give us a number close to the
		// -MAX_VALUE.
		assertEquals(-Double.MAX_VALUE / 2, lowerBoundJustAboveMinimumRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between two equal points in a
	 * `Range` object.
	 */
	@Test
	public void testSinglePointRangeLength() {
		// Test whether the length of the Range object is 0.0.
		assertEquals(0.0, singlePointLengthRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the length between two normal points in a `Range` object.
	 */
	@Test
	public void testValidRangeWithPositiveLength() {
		// Test whether the length of the Range object is equal to 10.0.
		assertEquals(10.0, validWithPositiveLengthRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a normal value in a `Range` object.
	 */
	@Test
	public void testValidUpperBound() {
		// Test whether the upper bound of the Range object is equal to 10.0.
		assertEquals(10.0, validUpperBoundRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a normal value in the `Range` object.
	 */
	@Test
	public void testValidLowerBound() {
		// Test whether the lower bound of the Range object is equal to 0.0.
		assertEquals(0.0, validLowerBoundRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of value near the -MAX_VALUE in the `Range`
	 * object.
	 */
	@Test
	public void testUpperBoundJustAboveMinimum() {
		// Test whether the upper bound of the Range object is equal to -MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// -MAX_VALUE.
		// Therefore, we divide the -MAX_VALUE by two to give us a number close to the
		// -MAX_VALUE.
		assertEquals(-Double.MAX_VALUE / 2, upperBoundJustAboveMinimumRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of value near the MAX_VALUE in the `Range`
	 * object.
	 */
	@Test
	public void testUpperBoundJustBelowMaximum() {
		// Test whether the upper bound of the Range object is equal to MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// MAX_VALUE.
		// Therefore, we divide the MAX_VALUE by two to give us a number close to the
		// MAX_VALUE.
		assertEquals(Double.MAX_VALUE / 2, upperBoundJustBelowMaximumRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of MAX_VALUE in the `Range` object.
	 */
	@Test
	public void testUpperBoundAtMaximum() {
		// Test whether the upper bound of the Range object is equal to
		// Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, upperBoundAtMaximumRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * This test tests the method with an input that is just above the lower bound
	 * in the 'Range' instance.
	 */
	@Test
	public void testContainsAboveLowerBound() {
		assertTrue(validWithPositiveLengthRange.contains(0.001)); // Value just above the Lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just above the upper bound in
	 * the 'Range' instance.
	 */
	@Test
	public void testContainsAboveUpperBound() {
		assertFalse(validWithPositiveLengthRange.contains(10.001)); // Value just above the upper bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the lower bound
	 * in the 'Range' instance.
	 */
	@Test
	public void testContainsAtLowerBound() {
		assertTrue(validWithPositiveLengthRange.contains(0)); // Value at the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the upper bound
	 * in the 'Range' instance.
	 */
	@Test
	public void testContainsAtUpperBound() {
		assertTrue(validWithPositiveLengthRange.contains(10)); // Value at the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just below the lower bound in
	 * the 'Range' instance.
	 */
	@Test
	public void testContainsBelowLowerBound() {
		assertFalse(validWithPositiveLengthRange.contains(-0.001)); // Value below the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just below the upper bound in
	 * the 'Range' instance.
	 */
	@Test
	public void testContainsBelowUpperBound() {
		assertTrue(validWithPositiveLengthRange.contains(9.999)); // Value below the upper bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just above the upper bound of
	 * the range, but where the lower and upper bounds are equivalent
	 */
	@Test
	public void testContainsInputAboveRangeOfZero() {
		assertFalse(pointRangeAtZero.contains(1)); // Value above the range
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the lower and
	 * upper bounds of the range, where the lower and upper bounds are equivalent
	 */

	@Test
	public void testContainsInputAtBoundOfZeroRange() {
		assertTrue(pointRangeAtZero.contains(0)); // Value at the point range
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just below the lower bound of
	 * the range, but where the lower and upper bounds are equivalent
	 */
	@Test
	public void testContainsInputBelowRangeOfZero() {
		assertFalse(pointRangeAtZero.contains(-1)); // Value below the range
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the upper
	 * bound, where both equal Double.MAX_VALUE
	 */
	@Test
	public void testContainsMaxRangeValueAtUpperBound() {
		assertTrue(upperBoundAtMaximumRange.contains(Double.MAX_VALUE)); // Value at the upper bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the upper
	 * bound, where both equal -Double.MAX_VALUE
	 */
	@Test
	public void testContainsMinRangeValueAtLowerBound() {
		assertTrue(lowerBoundAtMinimumRange.contains(Double.MAX_VALUE * -1)); // Value at the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is greater than the lower bound
	 * of the range and less than the upper bound of the range
	 */
	@Test
	public void testContainsWithinBounds() {
		assertTrue(validWithPositiveLengthRange.contains(5)); // Value within the bounds
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is greater than the lower bound
	 * of the range and less than the upper bound of the range,
	 * where the lower and upper bounds are -Double.MAX_VALUE and Double.MAX_VALUE
	 * respectively.
	 */

	@Test
	public void testContainsWithinBoundsMaxSizeRange() {
		assertTrue(maxSizeRange.contains(0)); // Value within the bounds
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that intersects the 'Range' instance
	 * only at the ranges lower bound.
	 */
	
	@Test
	public void testIntersectsCommonBoundaryLeft() {
		// Range intersects with input at 5
		assertTrue(rangeFiveToTen.intersects(0, 5));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that intersects the 'Range' instance
	 * only at the ranges upper bound.
	 */
	@Test
	public void testIntersectsCommonBoundaryRight() {
		// Range intersects with input at 5
		assertTrue(rangeZeroToFive.intersects(5, 10));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that is fully within a range that is
	 * the maximum size.
	 */
	@Test
	public void testIntersectsInputInsideMaxSizeRange() {
		// Input fully enclosed by bounds of range
		assertTrue(maxSizeRange.intersects(-100, 100));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that is fully within the 'Range'
	 * instance.
	 */
	@Test
	public void testIntersectsInputInsideRange() {
		// Input fully enclosed by bounds of range
		assertTrue(validWithPositiveLengthRange.intersects(2, 5));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input upper bound is
	 * less than the 'Range' instance lower bound.
	 */
	@Test
	public void testIntersectsMissLeft() {
		// Upper bound of input doesn't intersect with lower bound of range
		assertFalse(rangeFiveToTen.intersects(0, 4));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input lower bound is
	 * more than the 'Range' instances upper bound.
	 */

	@Test
	public void testIntersectsMissRight() {
		// Lower bound of input doesn't intersect with upper bound of range
		assertFalse(rangeZeroToFive.intersects(10, 20));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input upper bound is
	 * greater than the 'Range' instances lower bound,
	 * however the input lower bound is still less than the 'Range' instances lower
	 * bound, hence a partial overlap.
	 */

	@Test
	public void testIntersectsPartialOverlapLeft() {
		// Partial Overlap on the left side of the range with the input
		assertTrue(rangeZeroToFive.intersects(3, 7));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input lower bound is
	 * less than the 'Range' instances upper bound,
	 * however the input upper bound is still more than the 'Range' instances upper
	 * bound, hence a partial overlap.
	 */
	@Test
	public void testIntersectsPartialOverlapRight() {
		// Partial Overlap on the left side of the range with the input
		assertTrue(rangeFiveToTen.intersects(8, 12));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range that entirely encompasses the
	 * lower and upper bounds of the 'Range' instance,
	 * however the lower and upper bounds of the 'Range' instance are equivalent.
	 */
	@Test
	public void testIntersectsPointRangeInsideInput() {
		// Single point range enclosed by input
		assertTrue(pointRangeAtZero.intersects(-2, 2));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the lower and upper
	 * bounds for the input range are the same,
	 * which are equal to the lower and upper bounds of the 'Range' instance.
	 */
	@Test
	public void testIntersectsPointRangePointInputHit() {
		// Point range equivalent to input point range
		assertTrue(pointRangeAtZero.intersects(0, 0));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the lower and upper
	 * bounds for the input range are the same.
	 * The 'Range' instance is also a range where the lower and upper bounds are
	 * equivalent. In this case, the 'Range'
	 * instances lower and upper bounds are more than those input into the function.
	 */
	@Test
	public void testIntersectsPointRangePointInputMissLeft() {
		// Point range at 0 point range at -1 to the left
		assertFalse(pointRangeAtZero.intersects(-1, -1));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the lower and upper
	 * bounds for the input range are the same.
	 * The 'Range' instance is also a range where the lower and upper bounds are
	 * equivalent. In this case, the 'Range'
	 * instances lower and upper bounds are less than those input into the function.
	 */

	@Test
	public void testIntersectsPointRangePointInputMissRight() {
		// Point range at 0 misses point range at 1 to the right
		assertFalse(pointRangeAtZero.intersects(1, 1));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range that fully encloses the 'Range'
	 * instances
	 * lower and upper bounds.
	 */

	@Test
	public void testIntersectsRangeInsideInput() {
		// Input fully encompasses range
		assertTrue(rangeTwoToEight.intersects(0, 10));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range that is from the most negative
	 * to most positive number,
	 * where the 'Range' instances lower and upper bounds are fully within this
	 * input range.
	 */
	@Test
	public void testIntersectsRangeInsideMaxSizeInput() {
		// range intersects with largest possible input range
		assertTrue(validWithPositiveLengthRange.intersects(-1 * Double.MAX_VALUE, Double.MAX_VALUE));
	}
	
	@Test
    public void testConstrainWithinRange() {
        // Create a Range instance with lower bound 0 and upper bound 10
        Range range = new Range(0, 10);
        
        // Test when value is within the range
        double result = range.constrain(5);
        assertEquals(5.0, result, 0.0001); // Expected result is the same as the input value
    }

    @Test
    public void testConstrainAboveUpper() {
        // Create a Range instance with lower bound 0 and upper bound 10
        Range range = new Range(0, 10);
        
        // Test when value is above the upper bound
        double result = range.constrain(15);
        assertEquals(10.0, result, 0.0001); // Expected result is the upper bound
    }

    @Test
    public void testConstrainBelowLower() {
        // Create a Range instance with lower bound 0 and upper bound 10
        Range range = new Range(0, 10);
        
        // Test when value is below the lower bound
        double result = range.constrain(-5);
        assertEquals(0.0, result, 0.0001); // Expected result is the lower bound
    }

    @Test
    public void testConstrainLowerBound() {
        // Create a Range instance with lower bound 0 and upper bound 10
        Range range = new Range(0, 10);
        
        // Test when value is equal to the lower bound
        double result = range.constrain(0);
        assertEquals(0.0, result, 0.0001); // Expected result is the lower bound
    }

    @Test
    public void testConstrainUpperBound() {
        // Create a Range instance with lower bound 0 and upper bound 10
        Range range = new Range(0, 10);
        
        // Test when value is equal to the upper bound
        double result = range.constrain(10);
        assertEquals(10.0, result, 0.0001); // Expected result is the upper bound
    }
    
    @Test
    public void testCombineWithNullRange1() {
        // Create a Range instance with bounds 0 and 10
        Range range2 = new Range(5, 15);
        
        // Test when range1 is null
        Range result = Range.combine(null, range2);
        assertEquals(range2, result); // Expected result is range2
    }

    @Test
    public void testCombineWithNullRange2() {
        // Create a Range instance with bounds 0 and 10
        Range range1 = new Range(0, 10);
        
        // Test when range2 is null
        Range result = Range.combine(range1, null);
        assertEquals(range1, result); // Expected result is range1
    }

    @Test
    public void testCombineWithBothRangesNotNull() {
        // Create Range instances with bounds 0 and 10 and bounds 5 and 15 respectively
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 15);
        
        // Test when both range1 and range2 are not null
        Range result = Range.combine(range1, range2);
        assertEquals(0.0, result.getLowerBound(), 0.0001); // Expected lower bound is the minimum of range1 and range2
        assertEquals(15.0, result.getUpperBound(), 0.0001); // Expected upper bound is the maximum of range1 and range2
    }
    
    @Test
    public void testCombineIgnoringNaNWithBothRangesNull() {
        assertNull(Range.combineIgnoringNaN(null, null));
    }
    
    @Test
    public void testCombineIgnoringNaNWithFirstRangeNull() {
        Range range1 = new Range(0, 10);
        assertEquals(range1, Range.combineIgnoringNaN(null, range1));
    }

    @Test
    public void testCombineIgnoringNaNWithSecondRangeNull() {
        Range range1 = new Range(0, 10);
        assertEquals(range1, Range.combineIgnoringNaN(range1, null));
    }

    @Test
    public void testCombineIgnoringNaNWithFirstRangeNaN() {
        Range NaNRange = new Range(Double.NaN, Double.NaN);
        Range range1 = new Range(0, 10);
        assertEquals(range1, Range.combineIgnoringNaN(NaNRange, range1));
    }

    @Test
    public void testCombineIgnoringNaNWithSecondRangeNaN() {
        Range NaNRange = new Range(Double.NaN, Double.NaN);
        Range range1 = new Range(0, 10);
        assertEquals(range1, Range.combineIgnoringNaN(range1, NaNRange));
    }

    @Test
    public void testCombineIgnoringNaNWithValidRanges() {
        // Test when both ranges are valid and do not contain NaN
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 15);
        Range combinedRange = Range.combineIgnoringNaN(range1, range2);
        assertEquals(0.0, combinedRange.getLowerBound(), 0.0001);
        assertEquals(15.0, combinedRange.getUpperBound(), 0.0001);
    }

    @Test
    public void testCombineIgnoringNaNWithNaNInRange() {
        // Test when one range contains NaN and the other is valid
        Range range1 = new Range(0, 10);
        Range rangeWithNaN = new Range(Double.NaN, 10);
        Range combinedRange = Range.combineIgnoringNaN(range1, rangeWithNaN);
        assertEquals(0.0, combinedRange.getLowerBound(), 0.0001);
        assertEquals(10.0, combinedRange.getUpperBound(), 0.0001);
    }

    @Test
    public void testCombineIgnoringNaNWithBothNaNRanges() {
        // Test when both ranges contain NaN
        Range NaNRange1 = new Range(Double.NaN, Double.NaN);
        Range NaNRange2 = new Range(Double.NaN, Double.NaN);
        assertNull(Range.combineIgnoringNaN(NaNRange1, NaNRange2));
    }
    
 // Test when the lower and upper bounds are positive
    @Test
    public void testGetCentralValueWithPositiveBounds() {
        Range range = new Range(0, 10);
        assertEquals(5, range.getCentralValue(), 0.0001);
    }

    // Test when the lower bound is negative and the upper bound is positive
    @Test
    public void testGetCentralValueWithNegativeLowerBound() {
        Range range = new Range(-10, 10);
        assertEquals(0, range.getCentralValue(), 0.0001);
    }

    // Test when both lower and upper bounds are negative
    @Test
    public void testGetCentralValueWithNegativeBounds() {
        Range range = new Range(-10, -1);
        assertEquals(-5.5, range.getCentralValue(), 0.0001);
    }

    // Test when the lower bound is negative and the upper bound is zero
    @Test
    public void testGetCentralValueWithNegativeUpperBound() {
        Range range = new Range(-10, 0);
        assertEquals(-5, range.getCentralValue(), 0.0001);
    }

    // Test when both lower and upper bounds are zero
    @Test
    public void testGetCentralValueWithZeroBounds() {
        Range range = new Range(0, 0);
        assertEquals(0, range.getCentralValue(), 0.0001);
    }
    
    
    
    @Test
    public void testExpandToIncludeWithNullRange() {
        Range result = Range.expandToInclude(null, 5.0);
        assertEquals(5.0, result.getLowerBound(), 0.0);
        assertEquals(5.0, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithValueLowerThanLowerBound() {
        Range range = new Range(3.0, 7.0);
        Range result = Range.expandToInclude(range, 2.0);
        assertEquals(2.0, result.getLowerBound(), 0.0);
        assertEquals(7.0, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithValueGreaterThanUpperBound() {
        Range range = new Range(3.0, 7.0);
        Range result = Range.expandToInclude(range, 8.0);
        assertEquals(3.0, result.getLowerBound(), 0.0);
        assertEquals(8.0, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithValueWithinRange() {
        Range range = new Range(3.0, 7.0);
        Range result = Range.expandToInclude(range, 5.0);
        assertEquals(3.0, result.getLowerBound(), 0.0);
        assertEquals(7.0, result.getUpperBound(), 0.0);
    }
    
    @Test
    public void testExpandWithZeroMargins() {
        Range range = new Range(3.0, 7.0);
        Range result = Range.expand(range, 0.0, 0.0);
        assertEquals(3.0, result.getLowerBound(), 0.0);
        assertEquals(7.0, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandWithPositiveMargins() {
        Range range = new Range(3.0, 7.0);
        Range result = Range.expand(range, 0.1, 0.1);
        assertEquals(2.6, result.getLowerBound(), 0.01);
        assertEquals(7.4, result.getUpperBound(), 0.01);
    }

    @Test
    public void testExpandWithNegativeMargins() {
        Range range = new Range(3.0, 7.0);
        Range result = Range.expand(range, -0.1, -0.1);
        assertEquals(3.4, result.getLowerBound(), 0.01);
        assertEquals(6.6, result.getUpperBound(), 0.01);
    }
    
//	CHANGED
    @Test
    public void testExpandWithLowerMarginGreaterThanUpperMargin() {
        // Given a range from -1.0 to 1.0
        Range range = new Range(-1.0, 1.0);
        
        // When expanding the range with lower margin greater than upper margin
        Range result = Range.expand(range, 0.2, 0.1); // Lower margin 20%, upper margin 10%
        
        // Then the resulting range should have its bounds adjusted to ensure the lower bound is not greater than the upper bound
        assertEquals(-1.4, result.getLowerBound(), 0.01); // Lower bound should be adjusted to 0.0
        assertEquals(1.2, result.getUpperBound(), 0.01); // Upper bound should also be adjusted to 0.0
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidRange() {
        new Range(10.0, 0.0);
    }
    
    @Test
    public void testShiftWithoutZeroCrossing() {
        Range base = new Range(0, 5);
        double delta = 2.5;
        Range shiftedRange = Range.shift(base, delta);
        assertEquals(2.5, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(7.5, shiftedRange.getUpperBound(), 0.0001);
    }
    
    @Test
    public void testIntersectsWhenRangesIntersect() {
        Range range1 = new Range(0, 5);
        Range range2 = new Range(3, 8);
        assertTrue(range1.intersects(range2));
    }
    
    @Test
    public void testEqualsWithSameRange() {
        Range range1 = new Range(3.0, 7.0);
        assertTrue(range1.equals(range1));
    }

    @Test
    public void testEqualsWithEqualRanges() {
        Range range1 = new Range(3.0, 7.0);
        Range range2 = new Range(3.0, 7.0);
        assertTrue(range1.equals(range2));
    }

    @Test
    public void testEqualsWithDifferentObject() {
        Range range = new Range(3.0, 7.0);
        assertFalse(range.equals("not a range"));
    }

    @Test
    public void testEqualsWithDifferentLowerBound() {
        Range range1 = new Range(3.0, 7.0);
        Range range2 = new Range(4.0, 7.0);
        assertFalse(range1.equals(range2));
    }
    
    @Test
    public void testHashCode() {
        Range range1 = new Range(0, 5);
        Range range2 = new Range(0, 5);
        
        assertEquals(range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testEqualsWithDifferentUpperBound() {
        Range range1 = new Range(3.0, 7.0);
        Range range2 = new Range(3.0, 8.0);
        assertFalse(range1.equals(range2));
    }

    @Test
    public void testEqualsWithNullObject() {
        Range range = new Range(3.0, 7.0);
        assertFalse(range.equals(null));
    }
    
 // Test scaling a range with positive bounds
    @Test
    public void testScaleWithPositiveBounds() {
        Range range = new Range(0, 10);
        Range scaledRange = Range.scale(range, 2);
        assertEquals(0, scaledRange.getLowerBound(), 0.0001);
        assertEquals(20, scaledRange.getUpperBound(), 0.0001);
    }

    // Test scaling a range with negative lower bound
    @Test
    public void testScaleWithNegativeLowerBound() {
        Range range = new Range(-10, 10);
        Range scaledRange = Range.scale(range, 2);
        assertEquals(-20, scaledRange.getLowerBound(), 0.0001);
        assertEquals(20, scaledRange.getUpperBound(), 0.0001);
    }

    // Test scaling a range with both bounds as zero
    @Test
    public void testScaleWithZeroBounds() {
        Range range = new Range(0, 0);
        Range scaledRange = Range.scale(range, 2);
        assertEquals(0, scaledRange.getLowerBound(), 0.0001);
        assertEquals(0, scaledRange.getUpperBound(), 0.0001);
    }

    // Test scaling a range with a negative factor
    @Test(expected = IllegalArgumentException.class)
    public void testScaleWithNegativeFactor() {
        Range range = new Range(0, 10);
        Range scaledRange = Range.scale(range, -2);
    }

    // Test scaling a null range
    @Test(expected = IllegalArgumentException.class)
    public void testScaleWithNullRange() {
        Range scaledRange = Range.scale(null, 2);
    }
    
    @Test
    public void testIsNaNRangeWithBothNaN() {
        Range range = new Range(Double.NaN, Double.NaN);
        assertTrue(range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeWithLowerBoundNaN() {
        Range range = new Range(Double.NaN, 5.0);
        assertFalse(range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeWithUpperBoundNaN() {
        Range range = new Range(3.0, Double.NaN);
        assertFalse(range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeWithNoNaN() {
        Range range = new Range(3.0, 5.0);
        assertFalse(range.isNaNRange());
    }
    
    @Test
    public void testEqualsFalseWhenGreaterThanLower() {
    	Range range = new Range(-1, 1);
        assertFalse(range.equals(new Range(7, 8)));
    }

    @Test
    public void testEqualsFalseWhenLessThanLower() {
    	Range range = new Range(-1, 1);
        assertFalse(range.equals(new Range(3, 4)));
    }

    @Test
    public void testEqualsTrue() {
    	Range range = new Range(-1, 1);
        assertTrue(range.equals(range));
    }

    @Test
    public void testNaNRange() {
        Range nanRange = new Range(Double.NaN, Double.NaN);
        assertTrue(nanRange.isNaNRange());
    }
    
 // Test shifting a range with positive bounds without zero crossing
    @Test
    public void testShiftWithPositiveBoundsNoZeroCrossing() {
        Range range = new Range(0, 10);
        Range shiftedRange = Range.shift(range, 2, false);
        assertEquals(2, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(12, shiftedRange.getUpperBound(), 0.0001);
    }

    // Test shifting a range with negative lower bound without zero crossing
    @Test
    public void testShiftWithNegativeLowerBoundNoZeroCrossing() {
        Range range = new Range(-10, 10);
        Range shiftedRange = Range.shift(range, 2, false);
        assertEquals(-8, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(12, shiftedRange.getUpperBound(), 0.0001);
    }

    // Test shifting a range with both bounds as zero without zero crossing
    @Test
    public void testShiftWithZeroBoundsNoZeroCrossing() {
        Range range = new Range(0, 0);
        Range shiftedRange = Range.shift(range, 2, false);
        assertEquals(2, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(2, shiftedRange.getUpperBound(), 0.0001);
    }

    // Test shifting a range with positive bounds with zero crossing allowed
    @Test
    public void testShiftWithPositiveBoundsAllowZeroCrossing() {
        Range range = new Range(0, 10);
        Range shiftedRange = Range.shift(range, 2, true);
        assertEquals(2, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(12, shiftedRange.getUpperBound(), 0.0001);
    }

    // Test shifting a range with negative lower bound with zero crossing allowed
    @Test
    public void testShiftWithNegativeLowerBoundAllowZeroCrossing() {
        Range range = new Range(-10, 10);
        Range shiftedRange = Range.shift(range, 2, true);
        assertEquals(-8, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(12, shiftedRange.getUpperBound(), 0.0001);
    }

    // Test shifting a range with both bounds as zero with zero crossing allowed
    @Test
    public void testShiftWithZeroBoundsAllowZeroCrossing() {
        Range range = new Range(0, 0);
        Range shiftedRange = Range.shift(range, 2, true);
        assertEquals(2, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(2, shiftedRange.getUpperBound(), 0.0001);
    }

    // Test shifting a null range
    @Test(expected = IllegalArgumentException.class)
    public void testShiftWithNullRange() {
        Range shiftedRange = Range.shift(null, 2, false);
    }
    
    @Test
    public void testEqualBounds() {
        Range range = new Range(2.5, 2.5);
        assertEquals(2.5, range.getLowerBound(), 0.001);
        assertEquals(2.5, range.getUpperBound(), 0.001);
    }
    

    @Test
    public void testConstructorErrorInvalidValues() {
        Range range;
        try {
            range = new Range(6, 5);
            fail("Shouldn't be here");
        } catch(Exception e) {
            String expected = "Range(double, double): require lower (6.0) <= upper (5.0).";
            assertEquals(expected, e.getMessage());
        }
    }

    
    @Test
    public void testConstructorErrorInfinityLowerBound() {
        try {
            Range range = new Range(Double.POSITIVE_INFINITY, 5);
            fail("Shouldn't be here");
        } catch(Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("Range(double, double): require lower (Infinity) <= upper (5.0).", e.getMessage());
        }
    }
    
    @Test
    public void testConstructorErrorInfinityUpperBound() {
        try {
            Range range = new Range(5, Double.NEGATIVE_INFINITY);
            fail("Shouldn't be here");
        } catch(Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("Range(double, double): require lower (5.0) <= upper (-Infinity).", e.getMessage());
        }
    }

    @Test
    public void testConstructorErrorBothInfinity() {
        try {
            Range range = new Range(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            fail("Shouldn't be here");
        } catch(Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("Range(double, double): require lower (Infinity) <= upper (-Infinity).", e.getMessage());
        }
    }  

    @Test(expected = IllegalArgumentException.class)
    public void testGetLengthWithLowerGreaterThanUpper() {
        Range range = new Range(5, 1); 
        range.getLength(); 
    }

    @Test
    public void testGetLengthWithLowerEqualToUpper() {
        Range range = new Range(1, 1);
        assertEquals(0.0, range.getLength(), 0.000001);
    }

    @Test
    public void testGetLengthWithUpperEqualToLower() {
        Range range = new Range(1, 1);
        assertEquals(0.0, range.getLength(), 0.000001); 
    }

    @Test
    public void testGetLengthWithLowerLessThanUpper() {
        Range range = new Range(1, 2); 
        assertEquals(1.0, range.getLength(), 0.000001); 
    }
    
    @Test
    public void testEqualsFalseWhenUpperBoundIsGreater() {
    	Range range = new Range(-1, 1);
        assertFalse(range.equals(new Range(-1, 0)));
    }

    @Test
    public void testEqualsFalseWhenUpperBoundIsLess() {
    	Range range = new Range(-1, 1);
        assertFalse(range.equals(new Range(-1, 2)));
    }

    @Test
    public void testEqualsFalseWhenLowerBoundIsGreater() {
    	Range range = new Range(-1, 1);
        assertFalse(range.equals(new Range(-2, 1)));
    }

    @Test
    public void testEqualsFalseWhenLowerBoundIsLess() {
    	Range range = new Range(-1, 1);
        assertFalse(range.equals(new Range(0, 1)));
    }
    
    @Test
    public void testHashCodeConsistency() {
        Range range1 = new Range(1, 3);
        int hashCode1 = range1.hashCode();
        int hashCode2 = range1.hashCode(); // Calling hashCode again
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    public void testHashCodeEquality() {
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 3);
        assertEquals(range1, range2);
        assertEquals(range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testToString() {
        Range range = new Range(1, 3);
        assertEquals("Range[1.0,3.0]", range.toString());
    }

    @Test
    public void testToStringWithNaN() {
        Range range = new Range(Double.NaN, Double.NaN);
        assertEquals("Range[NaN,NaN]", range.toString());
        assertTrue(Double.isNaN(range.getLowerBound()));
        assertTrue(Double.isNaN(range.getUpperBound()));
    }

    @Test
    public void testToStringWithValidAndNaN() {
        Range range = new Range(1.5, Double.NaN);
        assertEquals("Range[1.5,NaN]", range.toString());
        assertEquals(1.5, range.getLowerBound(), 0.000001);
        assertTrue(Double.isNaN(range.getUpperBound()));
    }

    @Test
    public void testToStringWithNaNAndValid() {
        Range range = new Range(Double.NaN, 3.0);
        assertEquals("Range[NaN,3.0]", range.toString());
        assertTrue(Double.isNaN(range.getLowerBound()));
        assertEquals(3.0, range.getUpperBound(), 0.000001);
    }

    @Test
    public void testToStringWithInfinity() {
        Range range = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals("Range[-Infinity,Infinity]", range.toString());
        assertEquals(Double.NEGATIVE_INFINITY, range.getLowerBound(), 0.000001);
        assertEquals(Double.POSITIVE_INFINITY, range.getUpperBound(), 0.000001);
    }

    @Test
    public void testToStringWithPositiveInfinity() {
        Range range = new Range(5, Double.POSITIVE_INFINITY);
        assertEquals("Range[5.0,Infinity]", range.toString());
        assertEquals(5.0, range.getLowerBound(), 0.000001);
        assertEquals(Double.POSITIVE_INFINITY, range.getUpperBound(), 0.000001);
    }

    @Test
    public void testToStringWithNegativeInfinity() {
        Range range = new Range(Double.NEGATIVE_INFINITY, 10);
        assertEquals("Range[-Infinity,10.0]", range.toString());
        assertEquals(Double.NEGATIVE_INFINITY, range.getLowerBound(), 0.000001);
        assertEquals(10.0, range.getUpperBound(), 0.000001);
    }
    
    @Test
    public void testGetCentralValue_PositiveRange() {
        Range range = new Range(0, 10);
        assertEquals(5.0, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_NegativeRange() {
        Range range = new Range(-5, 5);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_NegativeToZeroRange() {
        Range range = new Range(-10, 0);
        assertEquals(-5.0, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_ZeroRange() {
        Range range = new Range(0, 0);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_SymmetricalRange() {
        Range range = new Range(-100, 100);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_InfiniteRange() {
        Range range = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals(Double.NaN, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_NaNRange() {
        Range range = new Range(Double.NaN, Double.NaN);
        assertEquals(Double.NaN, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_NegativeToPositiveRange() {
        Range range = new Range(-10, 10);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testGetCentralValue_LargeRange() {
        Range range = new Range(-1000000, 1000000);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }
 

	/**
	 * The tearDown method is typically employed to release resources such as
	 * closing database connections.
	 * However, in our scenario, where such connections are absent, we utilize it to
	 * nullify variables.
	 * While garbage collection handles this automatically, our intention here is to
	 * showcase its functionality.
	 */
	@After
	public void tearDown() {
		lowerBoundJustBelowMaximumRange = null;
		lowerBoundAtMinimumRange = null;
		invalidLengthNaNRange = null;
		invalidLengthNegativeInfinityRange = null;
		invalidLengthPositiveInfinityRange = null;
		invalidUpperBoundNaNRange = null;
		invalidLengthAtMinimumRange = null;
		invalidLengthAtMaximumRange = null;
		invalidLowerBoundNaNRange = null;
		lowerBoundJustAboveMinimumRange = null;
		singlePointLengthRange = null;
		validWithPositiveLengthRange = null;
		validUpperBoundRange = null;
		validLowerBoundRange = null;
		upperBoundJustAboveMinimumRange = null;
		upperBoundJustBelowMaximumRange = null;
		upperBoundAtMaximumRange = null;
		pointRangeAtZero = null;
		maxSizeRange = null;
		rangeZeroToFive = null;
		rangeFiveToTen = null;
		rangeTwoToEight = null;
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
	}
}
