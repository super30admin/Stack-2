class Solution:
    def nextGreaterElements(self, nums):
        # Getting the length of the input list
        n = len(nums)
        # Initializing the result list with -1 for each element
        result = [-1] * n
        # Creating a stack to keep track of indices
        st = []

        # Iterating through the list twice to simulate circular array
        for i in range(2 * n):
            # Checking if the current element is greater than the element at the index on top of the stack
            while st and nums[i % n] > nums[st[-1]]:
                # Popping the index from the stack and updating the result for that index
                popped = st.pop()
                result[popped] = nums[i % n]

            # Pushing the index onto the stack during the first pass
            if i < n:
                st.append(i)
            # Breaking if the stack's top index matches the current index modulo n (not strictly necessary)
            elif st and st[-1] == i % n:
                break

        # Returning the result list containing next greater elements
        return result

# Time Complexity (TC): O(n)
# Space Complexity (SC): O(n)
