
// Your code here along with comments explaining your approach
// Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

//Stack
// Time - O(n)
// Space - O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int currTime = 0, prevTime = 0;
        int[] res = new int[n];
        for(String log: logs){
            String[] func = log.split(":");
            currTime = Integer.parseInt(func[2]);
            if(func[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += currTime - prevTime;
                }
                stack.push(Integer.parseInt(func[0]));
                prevTime = currTime;
            }else{
                //end
                if(!stack.isEmpty()){
                    res[stack.peek()] += currTime - prevTime + 1;
                    stack.pop();
                }
                prevTime = currTime + 1;
            }
        }
        
        return res;
    }
}

//Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
// Time - o(n)
// Space - O(n)
class Solution {
    
    
    
    public boolean isValid(String s) {
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
           char chr = s.charAt(i);
            
            if(maps.containsKey(chr)){
                if(stack.isEmpty() || stack.pop() != maps.get(chr)) return false;
            }else{
                stack.push(chr);
            }
        }
        
        return stack.empty();
        
    }
}