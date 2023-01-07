'''
TIme Complexity --> O(n)
Space Complexity --> O(n)
'''
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev = 0
        res = [0 for x in range(n)]
        curr = 0
        stk = []
        for i in logs:
            val = i.split(':')
            if val[1]=='start':
                if len(stk)==0:
                    curr = int(val[2])
                    
                else:
                    curr = int(val[2])
                    id_ = stk[-1]
                    res[id_] += curr-prev
                    prev = curr
                stk.append(int(val[0]))
                    

                
            else:
                curr = int(val[2])
                id_ = stk[-1]
                stk.pop(-1)
                #print(id_)
                res[id_] += (curr+1)-prev
                prev = curr+1
        return res


