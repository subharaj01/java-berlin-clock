package com.ubs.opsit.interviews;

import org.junit.Test;

import com.ubs.opsit.interviews.TimeConverterImpl;

import org.junit.Assert;

/**
 * Test method for TimeConverterImpl class
 * 
 * @author subharaj
 *
 */
public class TestTimeConverterImpl extends TimeConverterImpl {

	TimeConverterImpl timeConverterImpl = new TimeConverterImpl();

	@Test
	public void testSplitTime() {
		String[] splitted = timeConverterImpl.splitTime("10:12:13");
		Assert.assertNotNull("result should not be null!", splitted);
		Assert.assertTrue("there should be 3 parts!", splitted.length == 3);
		Assert.assertTrue("1st part should be 10!", splitted[0].equals("10"));
		Assert.assertTrue("2nd part should be 12!", splitted[1].equals("12"));
		Assert.assertTrue("3rd part should be 13!", splitted[2].equals("13"));
	}

	@Test(expected = RuntimeException.class)
	public void testValidate() {
		String[] splitted = timeConverterImpl.splitTime("10:12");
		timeConverterImpl.validate(splitted, "10:12");
	}

	@Test
	public void testGenerateClockPatternFor1stRow() {
		String pattern = timeConverterImpl.generateClockPatternFor1stRow(13);
		Assert.assertNotNull("pattern should not be null!", pattern);
		Assert.assertTrue("pattern should be Off!", pattern.equals("O"));
	}

	@Test
	public void testGenerateClockPatternFor1stRowFor1stSecond() {
		String pattern = timeConverterImpl.generateClockPatternFor1stRow(01);
		Assert.assertNotNull("pattern should not be null!", pattern);
		Assert.assertTrue("pattern should be Off!", pattern.equals("O"));
	}

	@Test
	public void testGenerateClockPatternFor2ndRow() {
		String pattern = timeConverterImpl.generateClockPatternFor2ndRow(10);
		Assert.assertNotNull("pattern should not be null!", pattern);
		Assert.assertTrue("pattern should be RROO!", pattern.equals("RROO"));
	}

	@Test
	public void testGenerateClockPatternFor3rdRow() {
		String pattern = timeConverterImpl.generateClockPatternFor3rdRow(10);
		Assert.assertNotNull("pattern should not be null!", pattern);
		Assert.assertTrue("pattern should be OOOO!", pattern.equals("OOOO"));
	}

	@Test
	public void testGenerateClockPatternFor4thRow() {
		String pattern = timeConverterImpl.generateClockPatternFor4thRow(12);
		Assert.assertNotNull("pattern should not be null!", pattern);
		Assert.assertTrue("pattern should be YYOOOOOOOOO!", pattern.equals("YYOOOOOOOOO"));
	}

	@Test
	public void testGenerateClockPatternFor5thRow() {
		String pattern = timeConverterImpl.generateClockPatternFor5thRow(12);
		Assert.assertNotNull("pattern should not be null!", pattern);
		Assert.assertTrue("pattern should be YYOO!", pattern.equals("YYOO"));
	}

	@Test
	public void testConvertTime() {
		String output = timeConverterImpl.convertTime("10:12:13");
		Assert.assertTrue("result is not correct!", output
				.equals("O" + NEW_LINE + "RROO" + NEW_LINE + "OOOO" + NEW_LINE + "YYOOOOOOOOO" + NEW_LINE + "YYOO"));
	}

	@Test
	public void testConvertTimeForAllZero() {
		String output = timeConverterImpl.convertTime("00:00:00");
		Assert.assertTrue("result is not correct!", output
				.equals("Y" + NEW_LINE + "OOOO" + NEW_LINE + "OOOO" + NEW_LINE + "OOOOOOOOOOO" + NEW_LINE + "OOOO"));
	}

	@Test(expected = RuntimeException.class)
	public void testConvertTimeForInvalidInput() {
		timeConverterImpl.convertTime("00:03");
	}
}