//TC : O(n)
//SC : O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int curr = 0;
        int prev = 0;
        for(String s:logs){
            String[] sub = s.split(":");
            curr = Integer.parseInt(sub[2]);
            if(sub[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(sub[0]));
                prev = curr;
            }else{
                result[stack.pop()] += curr - prev+1;
                prev = curr + 1;
            }
        }
        return result;
    }
}
