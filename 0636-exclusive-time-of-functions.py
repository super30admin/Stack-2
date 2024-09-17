# TC - O(N), SC - O(N)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # Declaring this array just in case logs doesn't exist'
        arr = [0]
        if not logs: return arr
        # Output of this problem
        result = [0]*n
        # Why Stack? because it is important to note that if we are interuppting function 1 with function 2, as the fn 2 ends we will resume with fn 1. Order is important. Cant keep up with order in hashmaps
        st = []
        # two pointers prev and curr for tracing
        prev = 0
        for log in logs:
            # splitting and converting to int before appending to string variable since we receive strings not integers
            string = log.split(":")
            currId = int(string[0])
            curr = int(string[2])
            # If start, we check if we have any previous fn and we update its time instantly instead of waitng for its end and then calculating all timestamp with subtraction of fn that came in between to interrupt. We store this time value in resultant output. We might have just 1 function hence it is imp to check the presence of st. It might not be present. Setting prev to curr for upcoming fn. Appending currId to st.
            if string[1] == "start":
                if st: result[st[-1]] += curr - prev
                prev = curr
                st.append(currId)
                # as we receive end, we will pop the fn id from st and will store its time value in resultant output by calculating curr - prev + 1. IMP observation. We also put prev to curr+1 to remain consistent with adding 1 to curr-prev step.
            else:
                result[st.pop()] += curr + 1 - prev
                prev = curr + 1 
        return result
                

