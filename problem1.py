class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        ans = [0 for i in range(n)]
        prev = 0
        prev_id = []
        for i in logs:
            i= i.split(':')
            if(i[1]=='start'):
                if(len(prev_id)!=0):
                    ans[prev_id[-1]] += int(i[2])-prev
                    prev = int(i[2])
                prev_id.append(int(i[0]))  
            else:
                ans[prev_id.pop(-1)] += int(i[2])-prev+1
                prev = int(i[2])+1
        return ans
                
            