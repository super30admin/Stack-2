# Time Complexity : O(N)
# Sapce Complexity : O(N)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []
        ans = [0] * n
        temp = 0
        for log in logs:
            i, action, t = log.split(":")
            i = int(i)
            t = int(t)
            
            # push in stack
            if action == "start" :
                st.append([i, action, t])
                
            elif action == "end" :
                i2, action2, t2 = st.pop()
                ans[i] = ans[i] + (t - t2 + 1)
                
                if len(st) != 0:
                    ans[st[-1][0]] = ans[st[-1][0]] - (t - t2 + 1)
                
        return ans