/*
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if logs is None or len(logs) == 0:
            return []
        
        result = [0]*n
        stack = []
        cur = 0
        prev = 0
        for i in range(len(logs)):
            string = logs[i].split(":")
            cur = int(string[2])
            if string[1] == "start":
                if len(stack) > 0:
                    result[stack[-1]] += cur - prev
                    prev = cur
                stack.append(int(string[0]))
                
            else:
                result[stack.pop()] += cur - prev + 1
                prev = cur + 1
                
        return result
*/
// time - O(n)
// space - O(n)
// logic - whenever there is start I push onto stack and calculate for how much units the previous process ran by taking index from stack
// whenever there is end i pop from stack and calculate the unit for the process
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0)
            return new int[]{};
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int cur = 0, prev = 0;
        for (int i=0; i<logs.size(); i++){
            String[] s = logs.get(i).split(":");
            cur = Integer.parseInt(s[2]);
            
            if (s[1].equals("start")){
                if (!stack.isEmpty()){
                    result[stack.peek()] += cur - prev;
                    prev = cur;
                }
                stack.push(Integer.parseInt(s[0]));
            }
            else{
                result[stack.pop()] += cur - prev + 1;
                prev = cur + 1;
            }
        }
        return result;
    }
}