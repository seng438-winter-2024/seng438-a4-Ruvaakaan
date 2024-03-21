**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|     Ethan Bensler           |     |
|      Liam Brennan          |     |
|      Andrew Duong          |     |
|      Joseph Duong          |     |

# Introduction


# Analysis of 10 Mutants of the Range class 

getLength() - negated double field lower - killed

  Our test case with Range(3.0, 3.0) kills this mutation. The expected return value is 0.0 but the mutation returns 6.0.   


getCentralValue() - replaced double addition with multiplication - killed

  Our test case with Range(0.0, 10.0) kills this mutation. The expected return value is 5.0 but the mutation returns 0.0.


contains(double value) - less than to equal - killed

  Our test case with Range(0.0, 10.0) and value = 0.001 kills this mutation. The value falls within the range. Therefore, 
  the expected return value is true. However, the mutation returns false which is caught by the test.


intersects(double b0, double b1) - negated conditional - killed

  Our test case with Range(5.0, 10.0) and Range(0.0, 5.0) kills this mutation. The ranges intersect. Therefore, the expected 
  return value is true since the ranges intersect on 5.0 with one another. The mutation inverts the return which is caught 
  by the test.


constrain(double value) - removed conditional replaced equality check with false - killed

  Our test case with Range(0.0, 10.0) and value = 15.0 kills this mutation. The expected return is 10 since the value falls 
  outside the upper range. The removed conditional mutation always returns the value (15 in this case). Thus, the test 
  catches and kills the mutation. 




  

  

  
  

# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
