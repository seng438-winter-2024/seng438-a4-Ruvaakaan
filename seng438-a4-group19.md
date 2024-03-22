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

**Range Before:**

![rangemutation](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/95046408/976239d1-1d55-4ef0-ad3f-e440f8bcb400)

**Range After:**

![Screenshot 2024-03-21 192346](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/95046408/81a0f6a2-a17c-4231-b332-049be5665f0e)

**DataUtilities Before:**

![datautilitiesmutation](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/95046408/416f7a92-74a6-43f6-a350-572d2fab5cc3)

**DataUtilities After:**

![newdatautils](https://github.com/seng438-winter-2024/seng438-a4-Ruvaakaan/assets/113311709/c191f13b-3b13-46fa-b960-0d58cb1d3af8)




# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants can impact the accuracy of mutation scores when they are present but not detected by the test suite which inflates the mutation score. The test suite does not distinguish between equivalent mutants and genuine faults, it reports higher mutation scores, suggesting better test coverage than achieved.

# A discussion of what could have been done to improve the mutation score of the test suites

To boost our test suite's mutation scores, we reviewed each method, focusing on methods with high a number of surviving mutants. Additionally, we increased our efforts to enhance test coverage by considering various scenarios and edge cases more thoroughly. This ensured our tests were robust and capable of handling mutations. Moreover, we addressed issues in the source code, particularly in the Range and DataUtilities classes. Key improvements were made to the expand(), intersects(), and combine() methods in the Range class and specific adjustments to the <INSERT WHICH METHODS WERE CHANGED> methods in the DataUtilities class we also made. These modifications removed any failures from out test suite and increased our mutation scores.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

**Why?:**

Mutation testing serves as a powerful tool for gauging the efficacy of our test suite in detecting bugs. Through its utilization, we not only enhance the effectiveness of our test cases but also increase the reliability of our systems.

**Advantages:**

Mutation testing provides a thorough evaluation of test suite effectiveness, identifying areas where tests fail to detect mutations, thus revealing weaknesses in test coverage. Additionally, it encourages developers to write more comprehensive test cases, fostering continuous improvement in testing practices and enabling early bug detection.

**Disadvantages:**

Mutation testing also has its drawbacks. It can be computationally expensive, potentially leading to longer testing times and resource constraints. Specifically for this assignment, it took around 5 minutes for the the mutation testing to be completed. Moreover, interpreting results accurately requires a deep understanding of both the codebase and testing principles.


# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed

For mutation testing, we split the Range class testing between Liam and Ethan and then we split the DataUtilities testing between Andrew and Joseph. Then for the Selenium testing, each group member created two tests to test the ebay website, totaling 8 tests. 

# Difficulties encountered, challenges overcome, and lessons learned

Understanding the impact of mutations on the source code during mutation testing was initially challenging. However, consulting the PitTest documentation helped clarify these effects. Boosting the total mutation score, especially for the Range class, presented difficulties. Transitioning to Selenium testing also posed challenges, particularly due to frequent changes in object IDs on the site. Additionally, dealing with mobile authentication on eBay added complexity to test execution. 

# Comments/feedback on the lab itself

The lab provided valuable insights into injecting mutation faults into a Java codebase using a mutation testing tool, allowing us to interpret reported mutation scores effectively. We can now design new test cases to enhance the overall quality of test suites. Additionally, the session equipped us with proficiency in utilizing Selenium as a GUI test automation tool, broadening our skill set and strengthening our testing capabilities.
