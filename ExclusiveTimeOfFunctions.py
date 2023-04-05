"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(n)
"""


def exclusiveTime(n, logs):
    # null case
    if logs is None:
        return [0]

    result = [0 for _ in range(n)]
    stk = []
    prev = 0

    for log in logs:
        log_arr = log.split(":")
        task = int(log_arr[0])
        curr = int(log_arr[2])

        if log_arr[1] == "start":
            if stk:
                result[stk[-1]] += curr - prev
            prev = curr
            stk.append(task)
        else:
            result[stk.pop()] += (curr + 1) - prev
            prev = curr + 1

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(exclusiveTime(n=2, logs=["0:start:0", "1:start:2", "1:end:5",
                                   "0:end:6"]))  # return [3, 4]
    print(exclusiveTime(n=1, logs=["0:start:0", "0:start:2", "0:end:5",
                                   "0:start:6", "0:end:6", "0:end:7"]))  # return [8]
    print(exclusiveTime(n=2, logs=["0:start:0", "0:start:2", "0:end:5",
                                   "1:start:6", "1:end:6", "0:end:7"]))  # return [7, 1]


if __name__ == "__main__":
    main()
