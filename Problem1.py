# Time: O(n); Space: O(n/2) + O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        last_excecuted = 0
        total_execution = [0] * n
        mystack = []

        for log in logs:
            log = log.split(':')
            # check what log is at the top of the stack
            # if it is start log then find the diff and add to total execution
            if log[1] == "start" and mystack:
                top = mystack[-1]
                total_execution[int(top[0])] += (int(log[2]) - last_excecuted)
                # then append to stack
                mystack.append(log)
                last_excecuted = int(log[2])
            # end log
            elif log[1] == "end" and mystack:
                top = mystack[-1]
                total_execution[int(log[0])] += int(log[2]) - last_excecuted + 1
                last_excecuted = int(log[2]) + 1
                mystack.pop()
            else:
                mystack.append(log)
            print(mystack)
        return total_execution



