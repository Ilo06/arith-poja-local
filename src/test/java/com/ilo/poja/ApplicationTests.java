package com.ilo.poja;

import com.ilo.poja.service.AddService;
import com.ilo.poja.service.DivideService;
import com.ilo.poja.service.MultiplyService;
import com.ilo.poja.service.SubtractService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApplicationTests {
	@InjectMocks
	private AddService addService;

	@Test
	void add_two_positive_numbers_return_correct_sum(){
		assertEquals(BigInteger.valueOf(10),
				addService.sumTwoPositiveNumbers(BigInteger.valueOf(3), BigInteger.valueOf(7)));
	}

	@Test
	void add_with_zero_should_return_the_same_value(){
		assertEquals(BigInteger.valueOf(5),
				addService.sumTwoPositiveNumbers(BigInteger.valueOf(5), BigInteger.valueOf(0))
				);
		assertEquals(BigInteger.valueOf(6),
				addService.sumTwoPositiveNumbers(BigInteger.valueOf(0), BigInteger.valueOf(6))
		);
	}

	@Test
	void add_two_zeros_return_zero(){
		assertEquals(BigInteger.valueOf(0),
				addService.sumTwoPositiveNumbers(BigInteger.valueOf(0), BigInteger.valueOf(0))
		);
	}

	@Test
	void add_large_numbers_returns_correct_sum(){
		BigInteger a = new BigInteger("99999999999999999999");
		BigInteger b = new BigInteger("1");

		assertEquals(new BigInteger("100000000000000000000"),
				addService.sumTwoPositiveNumbers(a, b)
		);
	}

	@Test
	void add_nullA_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> addService.sumTwoPositiveNumbers(null, BigInteger.ONE));

	}

	@Test
	void add_nullB_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> addService.sumTwoPositiveNumbers(BigInteger.ONE, null));
	}

	@Test
	void add_negativeNumber_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> addService.sumTwoPositiveNumbers(BigInteger.valueOf(-1), BigInteger.ONE));
	}


//SUBTRACT

	@InjectMocks
	private SubtractService subtractService;

	@Test
	void subtract_largerMinusSmaller_returnsPositive() {
		assertEquals(BigInteger.valueOf(3), subtractService.subtractTwoNumbers(BigInteger.valueOf(7), BigInteger.valueOf(4)));
	}

	@Test
	void subtract_equalNumbers_returnsZero() {
		assertEquals(BigInteger.ZERO, subtractService.subtractTwoNumbers(BigInteger.valueOf(5), BigInteger.valueOf(5)));
	}

	@Test
	void subtract_smallerMinusLarger_returnsNegative() {
		assertEquals(BigInteger.valueOf(-3), subtractService.subtractTwoNumbers(BigInteger.valueOf(2), BigInteger.valueOf(5)));
	}

	@Test
	void subtract_withZero_returnsSameNumber() {
		assertEquals(BigInteger.valueOf(8), subtractService.subtractTwoNumbers(BigInteger.valueOf(8), BigInteger.ZERO));
	}

	@Test
	void subtract_nullA_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> subtractService.subtractTwoNumbers(null, BigInteger.ONE));
	}

	@Test
	void subtract_nullB_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> subtractService.subtractTwoNumbers(BigInteger.ONE, null));
	}


	//MULTIPLY


	@InjectMocks
	private MultiplyService multiplyService;

	@Test
	void multiply_twoPositiveNumbers_returnsCorrectProduct() {
		assertEquals(BigInteger.valueOf(12), multiplyService.multiplyTwoNumbers(BigInteger.valueOf(3), BigInteger.valueOf(4)));
	}

	@Test
	void multiply_byZero_returnsZero() {
		assertEquals(BigInteger.ZERO, multiplyService.multiplyTwoNumbers(BigInteger.valueOf(99), BigInteger.ZERO));
	}

	@Test
	void multiply_byOne_returnsSameNumber() {
		assertEquals(BigInteger.valueOf(7), multiplyService.multiplyTwoNumbers(BigInteger.valueOf(7), BigInteger.ONE));
	}

	@Test
	void multiply_twoNegativeNumbers_returnsPositive() {
		assertEquals(BigInteger.valueOf(6), multiplyService.multiplyTwoNumbers(BigInteger.valueOf(-2), BigInteger.valueOf(-3)));
	}

	@Test
	void multiply_positiveAndNegative_returnsNegative() {
		assertEquals(BigInteger.valueOf(-6), multiplyService.multiplyTwoNumbers(BigInteger.valueOf(2), BigInteger.valueOf(-3)));
	}

	@Test
	void multiply_largeNumbers_returnsCorrectProduct() {
		BigInteger a = new BigInteger("999999999999999999");
		BigInteger b = new BigInteger("999999999999999999");
		assertEquals(a.multiply(b), multiplyService.multiplyTwoNumbers(a, b));
	}

	@Test
	void multiply_nullA_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> multiplyService.multiplyTwoNumbers(null, BigInteger.ONE));
	}

	@Test
	void multiply_nullB_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> multiplyService.multiplyTwoNumbers(BigInteger.ONE, null));
	}


//DIVIDE


	@InjectMocks
	private DivideService divideService;

	@Test
	void divide_exactDivision_returnsCorrectQuotient() {
		assertEquals(BigInteger.valueOf(4), divideService.divideTwoNumbers(BigInteger.valueOf(12), BigInteger.valueOf(3)));
	}

	@Test
	void divide_withRemainder_returnsTruncatedQuotient() {
		assertEquals(BigInteger.valueOf(3), divideService.divideTwoNumbers(BigInteger.valueOf(10), BigInteger.valueOf(3)));
	}

	@Test
	void divide_byOne_returnsSameNumber() {
		assertEquals(BigInteger.valueOf(9), divideService.divideTwoNumbers(BigInteger.valueOf(9), BigInteger.ONE));
	}

	@Test
	void divide_zeroByNumber_returnsZero() {
		assertEquals(BigInteger.ZERO, divideService.divideTwoNumbers(BigInteger.ZERO, BigInteger.valueOf(5)));
	}

	@Test
	void divide_negativeByPositive_returnsNegative() {
		assertEquals(BigInteger.valueOf(-3), divideService.divideTwoNumbers(BigInteger.valueOf(-9), BigInteger.valueOf(3)));
	}

	@Test
	void divide_byZero_throwsArithmeticException() {
		assertThrows(ArithmeticException.class, () -> divideService.divideTwoNumbers(BigInteger.valueOf(5), BigInteger.ZERO));
	}

	@Test
	void divide_nullA_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> divideService.divideTwoNumbers(null, BigInteger.ONE));
	}

	@Test
	void divide_nullB_throwsException() {
		assertThrows(IllegalArgumentException.class, () -> divideService.divideTwoNumbers(BigInteger.ONE, null));
	}
}
