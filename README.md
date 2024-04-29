# SoftwareAssignment

Our Computation Discription:
Takes the factorial of a number and mutiples the digits of the answer.
![Diagram2](https://github.com/The-Cherry-Man/SoftwareAssignment/assets/157428885/e7e27f10-4c2e-4480-b985-ae3c3889b7d8)


The bound for the number of threads is 7 threads.


Updated time logging information:
Created a new ComputeConceptualBoundaryAPI class to streamline the computation component.
Originally, factorialResult was called each time the computation method was called.
Updated to get rid of any extra calls that were unnecessary which results in a faster time.
Also got rid of String conversion, I originally thought it was necessary to do so for BigInteger
to work but BigInteger has methods built in to work with it.
The original converted each digit to an int and then multiplied, but that caused much more memory to be used.
For an example input of 500, the ComputeConceptualBoundaryAPI finished in 357 milliseconds.
For UpdatedCCBAPI, it finished in 8 milliseconds.
This is a 77.52% reduction in time.
This large increase was most likely caused from my lack of knowledge on BigInteger in the original class