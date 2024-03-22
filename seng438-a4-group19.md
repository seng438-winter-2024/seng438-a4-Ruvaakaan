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

 
| #| method      |  line  | mutation  | status  | analysis
| --| -- | --- |--- |--- |-------- |
|1| getLength() |   return this.upper - this.lower  |  negated double field lower |  killed  |   Our test case with Range(3.0, 3.0) kills this mutation. The length between these two bounds is 0.0. Therefore, the expected return value is 0.0. The mutation returns 6.0 (3.0 - (-3.0) = 6.0 ) which is caught by the test.  | 
|2 |  getCentralValue()           |   return this.lower / 2.0 + this.upper / 2.0  |  replaced double addition with multiplication|  killed  |   Our test case with Range(0.0, 10.0) kills this mutation. The expected return value is 5.0 but the mutation returns 0.0 since we are multiplying the lower and upper bounds divided by two by one another.  | 
| 3|     contains(double value)          |   return (value >= this.lower && value <= this.upper)  |  less than to equal |  killed  |   Our test case with Range(0.0, 10.0) and value = 0.001 kills this mutation. The value falls within the range. Therefore, the expected return value is true. However, the mutation returns false since 0.001 != 0.0 is not which is caught by the test.  | 
|4 |     intersects(double b0, double b1)        |   if (b0 <= this.upper && b1 >= this.lower)  |  negated conditional |  killed  |   Our test case with Range(5.0, 10.0) and Range(0.0, 5.0) kills this mutation. The ranges intersect. Therefore, the expected return value is true since the ranges intersect on 5.0 with one another. The mutation inverts the return which is caught by the test.  | 
|5 |     constrain(double value)         |    if (!contains(value))  |  removed conditional replaced equality check with false |  killed  |   Our test case with Range(0.0, 10.0) and value = 15.0 kills this mutation. The expected return is 10 since the value falls outside the upper range. The removed conditional mutation always returns the value (15 in this case). Thus, the test catches and kills the mutation.   | 
|6 |    contains(double value)          |    return (value >= this.lower && value <= this.upper)  |  incremented (a++) double local variable number 1 |  survived  |   Our test case with Range(0.0, 10.0) and value = 0.001 fails to kill this mutation. The value falls within the range. Therefore, the expected return value is true. However, the mutation uses post incrementation which the  test case fails to catch as the return value stays the same.   | 
| 7|    intersects(Range range)        |     return intersects(range.getLowerBound(), range.getUpperBound())   |  removed call to org/jfree/Range::getLowerBound | survived  |   Our test case with Range(5.0, 10.0) and Range(0.0, 5.0) fails to kill this mutation. The ranges intersect. Therefore, the expected return value is true since the ranges intersect on 5.0 with one another. The mutation removes the call to getLowerBound() from the intersects(Range range) method which causes the incorrect value to be passed into the intersects(double b0, double b1) method. Here, the method returns 5.0 since the correct upper bound is passed into the function.    | 
|8 |   constrain(double value)         |   result = this.upper  | incremented (a--) double field upper |  survived  |   Our test case with Range(0.0, 10.0) and value = 15.0 fails to kill this mutation. The expected return is 10 since the value falls outside the upper range. The upper bound is deincremented after the result is set. Therefore, the return value stays the same.   | 
| 9|    isNaNRange()          |    return Double.isNaN(this.lower) && Double.isNaN(this.upper)  |  deincremented (--a) double field upper |  survived   |   Our test case with Range(Double.NaN, Double.NaN) fails to kill this mutation. The expected return is true as the range is between NaNs. The upper bound is deincremented. Although this does not change the test result since you cannot deincrement NaN. Thus, the range stays as a NaN range.   | 
|10 |     isNaNRange()          |    return Double.isNaN(this.lower) && Double.isNaN(this.upper)  |  negated double field lower |  survived   |   Our test case with Range(Double.NaN, Double.NaN) fails to kill this mutation. The expected return is true as the range is between NaNs. The lower bounds is negated. Although this does not change the test result since you cannot negate NaN. Thus, the range stays as a NaN range.   | 

  

  

  
  

# Report all the statistics and the mutation score for each test class

**Range Before**

![rangemutation](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/95046408/976239d1-1d55-4ef0-ad3f-e440f8bcb400)

**Range After**

![Screenshot 2024-03-21 192346](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/95046408/81a0f6a2-a17c-4231-b332-049be5665f0e)

**DataUtilities Before**

![datautilitiesmutation](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/95046408/416f7a92-74a6-43f6-a350-572d2fab5cc3)

**DataUtilities After**

![newdatautils](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/113311709/c191f13b-3b13-46fa-b960-0d58cb1d3af8)




# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy
Equivalent mutants can impact the accuracy of mutation scores when they are present but not detected by the test suite which inflates the mutation score. The test suite does not distinguish between equivalent mutants and genuine faults, it reports higher mutation scores, suggesting better test coverage than achieved.
# A discussion of what could have been done to improve the mutation score of the test suites
Manual inspection of mutation logs can reveal equivalent mutants. By reviewing the mutation logs generated by the mutation testing tool and understanding the nature of each mutation, such as whether it involves changing operators, variables, or control flow structures, we can detect equivalent mutants. Another way to detect equivalent mutants is to manually design and execute test cases targeting mutations suspected to be equivalent and compare the behaviour and output of the mutated code with the original code to determine whether there are any differences. Mutation testing encourages the creation of high-quality test cases with meaningful assertions and proper coverage, which promotes the overall reliability and robustness of the software.
# Why do we need mutation testing? Advantages and disadvantages of mutation testing
We need mutation testing to evaluate the effectiveness of a test suite by introducing small changes (mutations) into the code and checking if the tests detect these changes. The advantage of mutation testing is that it provides an assessment of the effectiveness of the test suite, indicated by the mutation score which reflects the amount of mutations identified by the tests. This can reveal the weaknesses in the test suite such as inadequate test cases or insufficient code coverage. This prompts developers to enhance their test suites with comprehensive test cases capable of detecting faults effectively. Mutation testing also has its limitations. It can be computationally intensive due to the amount of mutants, especially for large codebases with extensive test suites, leading to increased resource consumption and longer testing times. The generation of meaningful mutations that accurately represent potential faults in the code can be challenging. The effectiveness of mutation testing is dependent on the quality of the test suite; if the test suite lacks comprehensive coverage or contains weak test cases, mutation testing may not provide accurate insights into the code's fault tolerance.
# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
