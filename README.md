--------------------------------------------------------------------
Deque Java Developer Coding Excercise

Instructions:

- Answer the below problems by implementing the solution complete with accompanying unit tests to verify expected behavior
- Create a file called readme and describe all design decisions, assumptions, or potential issues
- Package all source and tests into zip with the format: deque_<first-name>_<last-name>.zip
---------------------------------------------------------------------

1. Give an array of numbers, return 2 numbers that has sum of a given number, or empty array if no valid answer, for example

int[] findNumbers(int[] input, int sum)

input = {1, 2, 3, 7, 10}, sum = 13, result: {3, 10}
input = {4, 6, 8, 9}, sum = 23, result: {}

Implemented the method findNumbers by going through the input array once, check on each int x,
if (sum-x) already exists in the HashSet, then just return {sum-x, x}; otherwise
we put x in the HashSet and move to the next. At the end of the loop we just return {}.
This gives O(n) time.

Assumptions :
1) we return the first two numbers that match the sum
2) if we found a match we return the two numbers in the order of their appearance in the original input array
3) there is enough memory for the HashSet of N=input.length numbers


2. Instead of 2 numbers, return n numbers that has sum of a given number, e.g.

input = {1, 2, 3, 4, 5, 7}, sum = 11, result: {1, 2, 3, 5}
input = {2, 4, 6, 25}, sum = 25, result: {25}
input = {2, 4, -6, 3, 34}, sum = 1, result: {4, -6, 3}


In the case of multiple solutions, only need to return the first one found.

Implemented the method findNumbersNoLimit with recursion as below:
  - if input is {}, then we return {}
  - otherwise we loop through input to see if any one of the int x equals sum, if so return {x};
    else, we recursively call findNumbersNoLimit with (input with x removed) and (sum-x), if such
    recursive call return a non-empty array meaning a solution on the subset is found, then we return
    a final solution by adding x to the front of the array returned by the recursive call.

 Note this is a subset sum problem and thus is NP-complete.

Assumptions :
1) we return the first solution that match the sum
2) if we found a solution we return the numbers in the order of their appearance in the original input array
3) there is enough memory to store the runtime stack for the recursion

