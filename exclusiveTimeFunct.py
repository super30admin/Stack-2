'''
time complexity: O(n)
space complexity: O(n)
'''
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        st = []
        res = [0 for _ in range(n)]
        prev = 0
        for i in range(len(logs)):
            strArr = logs[i].split(':')
            curr = int(strArr[2])
          
            
            if(strArr[1]=="start"):
                if(len(st)!=0):
                    res[st[-1]]+=curr - prev
                prev = curr
                st.append(int(strArr[0]))
            else:
                res[st.pop()]+=curr-prev+1
                prev = curr+1
                
        return res
                    