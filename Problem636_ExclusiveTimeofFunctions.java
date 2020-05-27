/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        int i=0;

        while( i < logs.size()){
            String log = logs.get(i);
            String[] arr = log.split(":");

            if(arr[1].equals("start")){

                if(!stack.isEmpty()){
                    res[stack.peek()] += Integer.parseInt(arr[2]) - prev;
                }
                stack.push(Integer.parseInt(arr[0]));
                prev = Integer.parseInt(arr[2]);
            }else{

                res[stack.peek()] += Integer.parseInt(arr[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(arr[2]) + 1;
            }
            i++;
        }
        return res;
    }
}