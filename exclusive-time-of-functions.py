# TC: O(n) | SC: O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        prev, prevType = 0, None
        ans = [0] * n

        for funcID, _type, timestamp in [x.split(':') for x in logs]:
            funcID = int(funcID)
            timestamp = int(timestamp)

            if _type == "start":
                if stack:   
                    ans[stack[-1]] += timestamp - prev
                stack.append(funcID)
                prev = timestamp
                
            else: # "end"
                ans[funcID] += (timestamp+1) - prev
                stack.pop()
                prev = timestamp+1

        return ans