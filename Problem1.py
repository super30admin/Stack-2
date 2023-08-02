class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        Calculate the exclusive time for each function in a given log.

        Time complexity: O(logs)
        Space complexity: O(n)

        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        result = [0] * \
            n  # Initialize a list to store the exclusive time for each function.

        if logs is None or len(logs) == 0:
            # If the logs list is empty, return the list with all elements initialized to 0.
            return result

        st = []  # Stack to store the function ids.
        curr = 0  # Variable to store the current timestamp.
        prev = 0  # Variable to store the previous timestamp.

        for log in logs:  # Loop through each log entry in the logs list.
            # Split the log entry into parts using ':' delimiter.
            strArr = log.split(":")
            # Extract the function id from the log entry.
            currId = int(strArr[0])
            # Extract the current timestamp from the log entry.
            curr = int(strArr[2])

            # If the log entry represents the start of a function call.
            if strArr[1] == "start":
                if st:  # If the stack is not empty, update the exclusive time for the top function.
                    result[st[-1]] += curr - prev
                st.append(currId)  # Push the function id to the stack.
                prev = curr  # Update the previous timestamp.

            else:  # If the log entry represents the end of a function call.
                # Pop the function id from the stack and update the exclusive time.
                result[st.pop()] += curr + 1 - prev
                # Update the previous timestamp for the next log entry.
                prev = curr + 1

        # Return the list containing the exclusive time for each function.
        return result
