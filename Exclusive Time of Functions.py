class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        #Approach: Stack
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        
        result = [0 for _ in range(n)]
        st = []
        
        prev = None
        for log in logs:
            id, status, timestamp = log.split(':')
            id, timestamp = int(id), int(timestamp)
            
            if status == 'start':
                if st:
                    result[st[-1]] += timestamp - prev
                st.append(id)
                prev = timestamp
                
            else:
                result[st.pop()] += timestamp - prev + 1
                prev = timestamp + 1
                
        return result