# SoftwareAssignment

A project to showcase technical skills regarding software programming, created by Jonathan Mitchell and Harrison Long.

The project is meant to showcase a user's ability to input a number, either through direct input or by file upload, 
and have that be sent across a server to be used in a calculation that would use a large amount of the PC's CPU. 
The result will then be output to a file that the user can specify. The end result will also have a delimiter at the end that the user can also specify.


Our Computation Description:

    Takes the factorial of a number and mutiples the digits of the answer.

To Run:

    Run DatastoreServer.java and FactorialServer.java and then after that, run the Client.java file and input your data

User Input Example:

    500 ; output.txt

Computation Example:

    10! = 10 x 9 x .... x 3 x 2 x 1 = 3,628,800,

    and the pruducts of the digits is 3 x 6 x 8 x 8 = 2,304

    excluding the multiplication of zeros


API Diagram:

![Screenshot 2024-05-10 132121](https://github.com/The-Cherry-Man/SoftwareAssignment/assets/157428885/ffb50e8a-6ee7-4e72-81c3-8d8dbbea0a2d)

Thread information:

    The bound for the number of threads is 7 threads.


Updated time logging information:

    Created a new ComputeConceptualBoundaryAPI class to streamline the computation component.
    Originally, factorialResult was called each time the computation method was called.
    Updated to get rid of any extra calls that were unnecessary which results in a faster time.
    Also got rid of String conversion, I originally thought it was necessary to do so for BigInteger
    to work but BigInteger has methods built in to work with it. The original converted each digit to 
    an int and then multiplied, but that caused much more memory to be used. For an example input of 500, 
    the ComputeConceptualBoundaryAPI finished in 357 milliseconds. For UpdatedCCBAPI, it finished 
    in 8 milliseconds. This is a 77.52% reduction in time. This large increase was most likely caused 
    from my lack of knowledge on BigInteger in the original class.

Front End Explanation:

    The front end was built with HTML, CSS, and Javascript and allows the user to input
    their information in a very simple way. By hitting the submit button, the information is converted to JSON to
    be sent to the java code, however due to the intricacies of gRPC, we could not find a way to execute it correctly.
    The front end is still working however, and can be found in the folder of the same name and you can see
    how it would have worked if everything went right.
[5 Why's](https://github.com/The-Cherry-Man/SoftwareAssignment/tree/main/Documents)
