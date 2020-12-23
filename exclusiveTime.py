#As taughts in class, using stack to split and add elemeents and find the final intrvals by adding result to subtraction of preevious element and current elemeent
#Time Complexity: O(n)
#Space complexity: O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if logs is None or len(logs)==0:
            return []
        result = [0]*n
        prev = 0
        st = list()
        for log in logs:
            splitlog = log.split(":")
            curr = int(splitlog[2])
            if (splitlog[1]=="start"):
                if (len(st)!=0):
                    result[int(st[-1])] += curr - prev
                    prev = curr
                st.append(splitlog[0])
            else:
                result[int(st.pop())] += curr - prev + 1
                prev = curr + 1
        return result