class Solution:
    # T.C. = O(N) n->len(logs)
    # S.C. = O(n) n-> no. of functions
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if ((n==0) or (len(logs)==0) or (logs is None)):
            return []
        # maintain a stack to track the elements currently active
        stack = list()
        ans = [0 for _ in range(n)]
        # last to store the timestamp of the last log
        last = 0

        for log in logs:
            # current = [functionID, "start|end", timestamp]
            current = [int(i) if i.isdigit() else i for i in log.split(":")]

            if current[1]=="start":
                if len(stack)!=0:
                    # the previously running function will be halted
                    ans[stack[-1]] += current[2]-last
                last = current[2]
                # put the current element in the stack of active functions
                stack.append(current[0])
            else:
                # if a function ends, it completes after the timestamp so if the timestamp
                # is 7 it will execute 7 and then end before 8 begins
                ans[stack.pop()] += current[2]-last+1
                # since the current timestamp has already been executed
                last = current[2]+1

        return ans