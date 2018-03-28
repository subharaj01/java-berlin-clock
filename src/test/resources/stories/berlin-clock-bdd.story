Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight past 1 second
When the time is 00:00:01
Then the clock should look like
O
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Noon
When the time is 12:00:00
Then the clock should look like
Y
RROO
RROO
OOOOOOOOOOO
OOOO
