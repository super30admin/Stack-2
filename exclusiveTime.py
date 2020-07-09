#Time Complexity:O(n)
#Space COmplexity:O(n)
#Ran successfully on Leetcode:Yes
#Approach:
#Here we store function ID in stack and ots timestamp in result array.
#The time is computed by subtracting prev time-curr time.
# if function is start, time=curr-prev and prev=curr
# if function is end: time=curr-prev+1 and prev=curr+1

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        total = [0 for i in range(n)]
        s = []
        i = 0
        curTime = 0
        while( i < len(logs)):
            curLog = logs[i].split(":")
            curId = int(curLog[0])
            status = curLog[1]
            nextTime = int(curLog[2])
            if (status ==  "start"):
                if (s):
                    total[s[-1]]+= nextTime - curTime
                s.append(curId)
                curTime = nextTime
            else:
                total[s[-1]]+= nextTime - curTime + 1
                s.pop()
                curTime = nextTime + 1
            i+=1
        return total
