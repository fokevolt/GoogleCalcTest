Meta:

Narrative:
As a mathematician
I want to perform some math calculations
So that I can get right answers

Scenario: calculator calculations
Given a calculator
When do calculations <number_1> <operation> <number_2>
Then the answer is <result>

Examples:
|number_1|operation|number_2|result|
|3|+|2|5|
|9|-|6|3|
|18|/|3|6|
|5|*|3|15|
|3|/|0|Infinity|
|0|/|0|Error|
|-10|+|10|0|
