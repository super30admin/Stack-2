'''
Using Stack
Time: O(n)
Space: O(n), for stack
'''

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        if logs is None or len(logs) == 0:
            return None
        
        res = [0 for _ in range(n)]
        st = list()
        curr = 0
        prev = 0
        
        for i in range(len(logs)):
            arr = logs[i].split(':')
            print(arr)
            task = int(arr[0])
            fn = arr[1]
            curr = int(arr[2])
            
            if fn == 'start':
                if len(st) != 0:
                    res[st[-1]] += curr - prev
                st.append(task)
                prev = curr
            
            else:
                res[st.pop()] += curr + 1 -prev
                prev = curr + 1
        return res
                