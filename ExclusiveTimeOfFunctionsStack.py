class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        # null case
        if logs is None:
            return None

        # stack of function IDs under process
        stkID = []  # O(n)

        # initialize the exclusive time array
        exclusiveTime = [0] * n

        # pointers for execution time calculation
        prev = 0

        # iterate over each log in logs
        for log in logs:  # O(n)

            # split log message into string array
            msg = log.split(":")

            # current time
            curr = int(msg[2])

            # for start
            if msg[1] == "start":

                # if stack has any function ID, add recent execution time of top (last in) call in stack to corresponding function ID in exclusive time array
                if stkID:
                    exclusiveTime[stkID[-1]] += (curr - prev)

                # push start function ID into stack
                stkID.append(int(msg[0]))

                # update previous pointer for further executions
                prev = curr

            # for end
            else:

                # end is at the end of the timestamp, so increment by 1 to include the ending timestamp
                curr += 1

                # pop out call function ID from stack which has just ended and update its exclusive time by adding recent execution time
                exclusiveTime[stkID.pop()] += (curr - prev)

                # update previous pointer for further executions
                prev = curr

        # output exclusive time array
        return exclusiveTime
