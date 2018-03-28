# Changes

1. added TimeConverterImpl class which contain entire logic.

2. added TestTimeConverterImpl class for junit / TDD

3. added src\test\resources\stories\berlin-clock-bdd.story for more BDD and ensured they are run successfully along with existing BDD

4.BDD reports are also checked in.

#Issues

# BerlinClockFixture class has to be edited to initialize berlinClock - I have done that. See below line

private TimeConverter berlinClock = new TimeConverterImpl();

# ClasspathStoryFinder is not able to find story file automatically in its current form , hence during BDD - i have put absolute path [ret.add(new File("H:\\java-berlin-clock-master\\src\\test\\resources\\stories"));] in getRootDirs() method and made it work, but before checkin to github i have removed this line as i trust the declaration-
/**
 * A class to help us find stories (files) across a classpath with many roots.  This is especially important
 * when finding files when executed from a Gradle test context.
 */






# The Berlin Clock

The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that
blinks on/off every two seconds. The time is calculated by adding rectangular lamps.
 
The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp
represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and
three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
 
The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the
first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first
quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp
represents 1 minute.

One can be seen [here](http://uniqueclocks.co.uk/media/berlin~clock.jpg~1.gif)

## The brief

We have created a number of acceptance tests for the Berlin Clock and your challenge is to get them passing.

## Some hints
If you are new to Gradle, it may be worth spending 10 minutes reading a high level summary.  We are using the Gradle
Wrapper so `gradlew` from the command line should download everything you need.  Most modern IDEs support Gradle projects.

The use of JBehave in this instance is to provide you with our definition of done for the task.

Please ensure that you are familiar with our values in the instructions project.  They are important to us.