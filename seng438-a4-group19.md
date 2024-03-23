**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group 19:      |    |
| -------------- | --- |
| Student Names: |     |
|     Ethan Bensler           |  30140326   |
|      Liam Brennan          |   30142832  |
|      Andrew Duong          |  30139573   |
|      Joseph Duong          |   30145210  |

# NOTE:&nbsp;The Selenium tests named "test sellers, testSavedSearches, testSavedItems" require the user to already be logged in as to avoid violating the terms and services of eBay (and getting the account banned). Please use the credentials below for the login:


user email : betax96593@nimadir.com


password : SENG438testingAssignment4

# Introduction

This lab comprises two main parts: Mutation Testing and GUI Testing. In the Mutation Testing section, we will learn how to introduce mutation faults into a Java codebase using a mutation testing tool. Additionally, we'll understand how to analyze the resulting mutation scores and utilize this knowledge to develop new test cases, ultimately enhancing the overall quality of our test suite. The second part focuses on GUI Testing, where we'll explore the record and replay approach, a commonly used method for automating graphical user interface tests. Specifically, we'll become familiar with Selenium, a well-known tool for web interface testing, and compare it with other alternatives.

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

The effectiveness of the RangeTest class appears to be relatively lower, as indicated by its mutation score of only 69%, even after significant improvements were made to the test class. Conversely, the DataUtilities class achieved a much higher mutation score of 82%. This stark contrast suggests that the DataUtilities class is more robust and capable of handling a wide range of unique situations compared to the Range class.

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

As eBay is an e-commerce website, we prioritized testing eBay's core e-commerce functionalities, including adding items to carts, searching for products, and viewing detailed item information. Given the platform's reliance on user accounts, we also designed test cases to ensure seamless account creation, login, and management. 

# Explain the use of assertions and checkpoints

Assertions and checkpoints both serve to verify specific values or elements on a page. The differentiation between the two is the way the verification is handled. Assertions are more direct as they definitively define an expected outcome and compare it with the actual outcome, terminating if there is a mismatch. Checkpoints are more relaxed as they mainly serve to validate information and do not terminate upon mismatch. Assertions are typically used for more critical points in a program that must be correct in order for the program to continue whereas with checkpoints, we can use them to gather informaion about application behaviour even if the initial expectations are unmet.

# Defects and Bugs

There were no bugs to report that we found. The closest thing we had to encountering that were inconsistencies in the login process, such as requesting a captcha to be completed or asking if we wanted to set up a passkey for quicker authentication.

# Discuss advantages and disadvantages of Selenium vs. Sikulix

Selenium is primarily designed for testing web applications where the code for the web page is accessible. By being able to access specific elements in a web page and read the underlying code, it’s able to quickly find and store information on the page and interact with the web page while monitoring any changes of state. Selenium is particularly useful for GUI testing as it relates to CI/CD as tests are able to be executed in the cloud, which allows for Selenium to be used as an automated test in deployment.

Sikulix can be used to test web applications, but isn’t solely limited to those as it can also be used to test other applications outside of the browser. This is because Sikulix works by using image recognition to record and perform actions to complete tests. It’s particularly useful when the underlying code behind an application is inaccessible as it doesn’t rely on reading different HTML tags or classes to identify components. However, a major drawback to this Sikulix is that a real screen must be connected in order for it to work. This is a major limitation as it relates to CI/CD as it becomes impossible to run Sikulix tests in the cloud as an automated step in deployment.

# How the team work/effort was divided and managed

For mutation testing, we divided the testing responsibilities for the Range class between Liam and Ethan, while Andrew and Joseph tackled the testing for DataUtilities. Subsequently, each team member contributed by creating two Selenium tests to evaluate the eBay website, culminating in a total of eight tests.

# Difficulties encountered, challenges overcome, and lessons learned

Understanding the impact of mutations on the source code during mutation testing was initially challenging. However, consulting the PitTest documentation helped clarify these effects. Boosting the total mutation score, especially for the Range class, presented difficulties.

As for the Selenium testing, one of the main challenges was using the IDE itself. We faced issues with trying to run Selenium as there were some performance problems and issues with the software properly detecting some actions/elements when recording. Although the perfomance issues were related to the software itself, we overcame the issues with detection by manually modifying and ensuring that the correct items were being selected in our playbacks. Selenium IDE is also a very limited browser extension that was very unreliable. It felt very limited in its features and being able to modify and change tests quickly and effectively. One such issue is the fact that Selenium IDE is a browser extension, meaning that it will be sharing the same Cookies and session tokens as the rest of your browser. This made it impossible to test logging in from a fresh account on eBay. Instead it saved our session tokens and always prompted us to login into an already existing account. Thus, all of our tests where we test logging in are from a state where the user has already signed in before. Another issue is that eBay has a lot of bot detection tools at its disposal, which resulted in us having to interrupt tests to complete captchas and verify other information. We've had to make 3 temporary accounts on ebay for testing purposes, 2 of which were banned for violation of their terms of service, the second of which happened during the demo of our tests. Overall, it seems like it would have been better to use the Selenium Library for java as this would've allowed for greater control and familiarity when writing tests, not to mention greater reliability. Additionally, eBay on firefox is slightly different than eBay on Google Chrome, which caused a lot of our tests to break due to different css class names and id's, and so choosing eBay as our website to test definitely made it more challenging on ourselves.

# Comments/feedback on the lab itself

The lab provided valuable insights into injecting mutation faults into a Java codebase using a mutation testing tool, allowing us to interpret reported mutation scores effectively. We can now design new test cases to enhance the overall quality of test suites. Additionally, the session equipped us with proficiency in utilizing Selenium as a GUI test automation tool, broadening our skill set and strengthening our testing capabilities.
