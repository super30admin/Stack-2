# Approach - At every start time calculate how long previous process was running for by pushing peeking from stack and cacl with prev pointer ref
# at every end time calculate how long that process ran for by popping from stack and calculating
# Time - O(N)
# Space - O(N)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        result = [0] * n
        st = []
        prev = 0
        for log in logs:
            string = log.split(":")
            current = int(string[2])
            if string[1] == 'start':
                if st:
                    result[st[-1]] += current - prev
                    
                    prev = current
                    
                st.append(int(string[0]))
                
            else:
                # once at end we pop the value and process it
                result[st.pop()] += current - prev + 1
                prev = current + 1
                
        return result
        