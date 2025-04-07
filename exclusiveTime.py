"""
Stack approach -
TC - O(n)
SC - O(n)
"""
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n is None or len(logs) == 0: return []

        prev = 0
        curr = 0

        stack = []
        rtnData = [0 for i in range(n)]

        for log in logs:
            # step 1 - split log
            splitlog = log.split(":")
            # step 2 - set curr
            curr = int(splitlog[2])
            # step 3 - check if start/end
            if splitlog[1] == "start":
                # append to stack BUT first check if the stack already has elements
                if stack:
                    # update the curr by getting the old curr value for this particular functionId
                    # from rtnData
                    rtnData[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(splitlog[0]))
            else:
                # end is encountered
                rtnData[stack.pop()] += curr + 1 - prev
                prev = curr + 1

        return rtnData

