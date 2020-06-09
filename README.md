# DataStructuresAndProblemSolving

Big O Notation is a way to formalize fuzzy counting. It allows us to talk the run time of an algorithm as the input grows. 

An Algorithm is O(f(n)), if the number of operations that computer has to do is less than a constant time f(n), as n grows:
- f(n) could be linear (f(n) = n)
- f(n) could be quadratic (f(n)=n^2)
- f(n) could be constant (f(n) = 1)

### Simplyifying Big(O) expressions

Constants don't matter
- O(2n), O(n+10), O(1000n+50) -> O(n)
- O(500), O(3), O(50) -> O(1)
- O(13n^2). O(n^2 + 5n + 3) -> O(n^2)

### Big O Shorthands

- Arithmetic Operations are constant
- Variable assignment is constant
- Accessing Elements in an array is constant
- In a loop, complexity is length of loop times complexity of whatever happens in the loop

### Space Complexity
Space Complexity is a way to formalize how much additional memory do we need to allocate in order to run the code in our algorithm

- Primitives (Boolean, Int, null etc) are constant space
- Reference types requires O(n) space

#### Udemy Course

Thanks to Colt Steele for this Udemy Course: 
https://www.udemy.com/course/js-algorithms-and-data-structures-masterclass/ 

