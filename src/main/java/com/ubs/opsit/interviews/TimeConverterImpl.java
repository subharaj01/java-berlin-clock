package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter {

	// constants to be used
	public static final String NEW_LINE = "\r\n";
	public static final String EMPTY_STRING = "";
	public static final String OFF_INDICATOR = "O";
	public static final String RED_INDICATOR = "R";
	public static final String YELLOW_INDICATOR = "Y";
	public static final String REPLACE_PATTERN = "YYY";
	public static final String FINAL_PATTERN = "YYR";
	public static final String SPLITER = ":";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 */
	@Override
	public String convertTime(String aTime) throws RuntimeException {
		String output;
		String[] timeParts = splitTime(aTime);
		validate(timeParts, aTime);
		output = generateClockPatternFor1stRow(Integer.valueOf(timeParts[2]));
		output = output + NEW_LINE + generateClockPatternFor2ndRow(Integer.valueOf(timeParts[0]));
		output = output + NEW_LINE + generateClockPatternFor3rdRow(Integer.valueOf(timeParts[0]));
		output = output + NEW_LINE + generateClockPatternFor4thRow(Integer.valueOf(timeParts[1]));
		output = output + NEW_LINE + generateClockPatternFor5thRow(Integer.valueOf(timeParts[1]));
		return output;
	}

	/**
	 * split time in hour , minute, seconds
	 * 
	 * @param aTime
	 * @return
	 */
	protected String[] splitTime(String aTime) {
		String[] timeParts = aTime.split(SPLITER);
		return timeParts;
	}

	/**
	 * validate input
	 * 
	 * @param timeParts
	 * @throws Exception
	 */
	protected void validate(String[] timeParts, String aTime) throws RuntimeException {
		if (timeParts == null || timeParts.length != 3) {
			throw new RuntimeException("input: " + aTime + " is not valid!, expected format 00:00:00");
		}
	}

	/**
	 * generate pattern for 1st row
	 * 
	 * @param seconds
	 * @return
	 */
	protected String generateClockPatternFor1stRow(int seconds) {
		if (seconds == 1) {
			return OFF_INDICATOR;
		}
		return seconds % 2 == 0 ? YELLOW_INDICATOR : OFF_INDICATOR;
	}

	/**
	 * generate pattern for 2nd row
	 * 
	 * @param hours
	 * @return
	 */
	protected String generateClockPatternFor2ndRow(int hours) {
		int numbersOfOnLights = hours / 5;
		return generateCommonPattern(4, RED_INDICATOR, numbersOfOnLights);
	}

	/**
	 * generate pattern for 3rd row
	 * 
	 * @param hours
	 * @return
	 */
	protected String generateClockPatternFor3rdRow(int hours) {
		int numbersOfOnLights = hours % 5;
		return generateCommonPattern(4, RED_INDICATOR, numbersOfOnLights);
	}

	/**
	 * generate pattern for 4th row
	 * 
	 * @param minutes
	 * @return
	 */
	protected String generateClockPatternFor4thRow(int minutes) {
		int numbersOfOnLights = minutes / 5;
		String interimPattern = generateCommonPattern(11, YELLOW_INDICATOR, numbersOfOnLights);
		return interimPattern.replaceAll(REPLACE_PATTERN, FINAL_PATTERN);
	}

	/**
	 * generate pattern for 5th row
	 * 
	 * @param minutes
	 * @return
	 */
	protected String generateClockPatternFor5thRow(int minutes) {
		int numbersOfOnLights = minutes % 5;
		return generateCommonPattern(4, YELLOW_INDICATOR, numbersOfOnLights);
	}

	/**
	 * utility method for pattern generation
	 * 
	 * @param maxLights
	 * @param OnSymbol
	 * @param numbersOfOnLights
	 * @return
	 */
	protected String generateCommonPattern(int maxLights, String OnSymbol, int numbersOfOnLights) {
		String pattern = EMPTY_STRING;
		for (int i = 0; i < numbersOfOnLights; i++) {
			pattern = pattern + OnSymbol;
		}
		for (int j = 0; j < maxLights - numbersOfOnLights; j++) {
			pattern = pattern + OFF_INDICATOR;
		}
		return pattern;
	}
}
