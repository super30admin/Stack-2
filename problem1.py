#Time, space O(n)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        res=[0]*n
        cur=0
        prev=0
        #Adding ids in stack, adding timestamp difference in result array
        for i in logs:
            i=i.split(':')
            
            cur = int(i[2])
            if i[1]=='start':
                if stack:
                    res[stack[-1]] += cur-prev
                    print(res)
                stack.append(int(i[0]))
                prev=cur
            else:
                res[stack.pop()] += cur+1-prev
                print(res)
                prev = cur+1
        return res
        
