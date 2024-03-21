**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group 19:      |    |
| -------------- | --- |
| Student Names: |     |
|     Ethan Bensler           |     |
|      Liam Brennan          |     |
|      Andrew Duong          |     |
|      Joseph Duong          |     |

# Introduction


# Analysis of 10 Mutants of the Range class 

**getLength() - return this.upper - this.lower - negated double field lower - killed**

Our test case with Range(3.0, 3.0) kills this mutation. The length between these two bounds is 0.0. Therefore, the expected return value is 0.0. The mutation returns 6.0 (3.0 - (-3.0) = 6.0 ) which is caught by the test.


**getCentralValue() - return this.lower / 2.0 + this.upper / 2.0 - replaced double addition with multiplication - killed**

Our test case with Range(0.0, 10.0) kills this mutation. The expected return value is 5.0 but the mutation returns 0.0 since we are multiplying the lower and upper bounds divided by two by one another.


**contains(double value) - return (value >= this.lower && value <= this.upper) - less than to equal - killed**

Our test case with Range(0.0, 10.0) and value = 0.001 kills this mutation. The value falls within the range. Therefore, the expected return value is true. However, the mutation returns false since 0.001 != 0.0 is not which is caught by the test.


**intersects(double b0, double b1) - if (b0 <= this.upper && b1 >= this.lower) - negated conditional - killed**

Our test case with Range(5.0, 10.0) and Range(0.0, 5.0) kills this mutation. The ranges intersect. Therefore, the expected return value is true since the ranges intersect on 5.0 with one another. The mutation inverts 
the return which is caught by the test.


**constrain(double value) - if (!contains(value)) - removed conditional replaced equality check with false - killed**

Our test case with Range(0.0, 10.0) and value = 15.0 kills this mutation. The expected return is 10 since the value falls outside the upper range. The removed conditional mutation always returns the value (15 in this 
case). Thus, the test catches and kills the mutation. 





**contains(double value) - return (value >= this.lower && value <= this.upper) - incremented (a++) double local variable number 1 - survived**

Our test case with Range(0.0, 10.0) and value = 0.001 fails to kill this mutation. The value falls within the range. Therefore, the expected return value is true. However, the mutation uses post incrementation which the  test case fails to catch as the return value stays the same.

  
**intersects(Range range) - return intersects(range.getLowerBound(), range.getUpperBound()) - removed call to org/jfree/Range::getLowerBound - survived**

Our test case with Range(5.0, 10.0) and Range(0.0, 5.0) fails to kill this mutation. The ranges intersect. Therefore, the expected return value is true since the ranges intersect on 5.0 with one another. The mutation removes the call to getLowerBound() from the intersects(Range range) method which causes the incorrect value to be passed into the intersects(double b0, double b1) method. Here, the method returns 5.0 since the correct upper bound is passed into the function. 


**constrain(double value) - result = this.upper - incremented (a--) double field upper - survived**

Our test case with Range(0.0, 10.0) and value = 15.0 fails to kill this mutation. The expected return is 10 since the value falls outside the upper range. The upper bound is deincremented after the result is set. Therefore, the return value stays the same.


**isNaNRange() - return Double.isNaN(this.lower) && Double.isNaN(this.upper) - deincremented (--a) double field upper - survived**

Our test case with Range(Double.NaN, Double.NaN) fails to kill this mutation. The expected return is true as the range is between NaNs. The upper bounds is deincremented. Although this does not change the test result since you cannot deincrement NaN values. Thus, the range stays as a NaN range.



  
| method      |  line  | mutation  | status  | explanation
| -------------- | --- |--- |--- |--- |
| getLength() |   return this.upper - this.lower  |  negated double field lower |  killed  |   Our test case with Range(3.0, 3.0) kills this mutation. The length between these two bounds is 0.0. Therefore, the expected return value is 0.0. The mutation returns 6.0 (3.0 - (-3.0) = 6.0 ) which is caught by the test.  | 
|  getCentralValue()           |   return this.lower / 2.0 + this.upper / 2.0  |  replaced double addition with multiplication|  killed  |   Our test case with Range(0.0, 10.0) kills this mutation. The expected return value is 5.0 but the mutation returns 0.0 since we are multiplying the lower and upper bounds divided by two by one another.  | 
|     contains(double value)          |   return (value >= this.lower && value <= this.upper)  |  less than to equal |  killed  |   Our test case with Range(0.0, 10.0) and value = 0.001 kills this mutation. The value falls within the range. Therefore, the expected return value is true. However, the mutation returns false since 0.001 != 0.0 is not which is caught by the test.  | 
|      intersects(double b0, double b1)        |   if (b0 <= this.upper && b1 >= this.lower)  |  negated conditional |  killed  |   Our test case with Range(5.0, 10.0) and Range(0.0, 5.0) kills this mutation. The ranges intersect. Therefore, the expected return value is true since the ranges intersect on 5.0 with one another. The mutation inverts the return which is caught by the test.  | 
|      constrain(double value)         |    if (!contains(value))  |  removed conditional replaced equality check with false |  killed  |   Our test case with Range(0.0, 10.0) and value = 15.0 kills this mutation. The expected return is 10 since the value falls outside the upper range. The removed conditional mutation always returns the value (15 in this case). Thus, the test catches and kills the mutation.   | 
|      contains(double value)          |    return (value >= this.lower && value <= this.upper)  |  incremented (a++) double local variable number 1 |  survived  |   Our test case with Range(0.0, 10.0) and value = 0.001 fails to kill this mutation. The value falls within the range. Therefore, the expected return value is true. However, the mutation uses post incrementation which the  test case fails to catch as the return value stays the same.   | 
|      intersects(Range range)        |     return intersects(range.getLowerBound(), range.getUpperBound())   |  removed call to org/jfree/Range::getLowerBound | survived  |   Our test case with Range(5.0, 10.0) and Range(0.0, 5.0) fails to kill this mutation. The ranges intersect. Therefore, the expected return value is true since the ranges intersect on 5.0 with one another. The mutation removes the call to getLowerBound() from the intersects(Range range) method which causes the incorrect value to be passed into the intersects(double b0, double b1) method. Here, the method returns 5.0 since the correct upper bound is passed into the function.    | 
|     constrain(double value)         |   result = this.upper  | incremented (a--) double field upper |  survived  |   Our test case with Range(0.0, 10.0) and value = 15.0 fails to kill this mutation. The expected return is 10 since the value falls outside the upper range. The upper bound is deincremented after the result is set. Therefore, the return value stays the same.   | 
|      isNaNRange()          |    return Double.isNaN(this.lower) && Double.isNaN(this.upper)  |  deincremented (--a) double field upper |  survived   |   Our test case with Range(Double.NaN, Double.NaN) fails to kill this mutation. The expected return is true as the range is between NaNs. The upper bound is deincremented. Although this does not change the test result since you cannot deincrement NaN. Thus, the range stays as a NaN range.   | 
|      isNaNRange()          |    return Double.isNaN(this.lower) && Double.isNaN(this.upper)  |  negated double field lower |  survived   |   Our test case with Range(Double.NaN, Double.NaN) fails to kill this mutation. The expected return is true as the range is between NaNs. The lower bounds is negated. Although this does not change the test result since you cannot negate NaN. Thus, the range stays as a NaN range.   | 

  

  

  
  

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
