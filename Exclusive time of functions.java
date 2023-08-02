//Time complexity: O(N)
//Space Complexity: O(N)
//Method: when a function starts working push it inside the stack and if another function starts, then update the previous fn run time in the result array. if a function ends, then add (end - start) + 1(because when end and start are eual it implies function ran for 1 sec that also implies the timeline at which the function ends would be end+1) so update this for the next call.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> fnStk = new Stack<>();
        int prev= 0;int curr = 0;
        int[] result = new int[n];
        for(String s: logs){
            String[] split = s.split(":");
            int id = Integer.parseInt(split[0]);
            String call = split[1];
            curr = Integer.parseInt(split[2]);

            if(call.equals("start")){
                //update the previous id in result array
                if(!fnStk.isEmpty()){
                    result[fnStk.peek()] += curr - prev;
                }
                //push id
                fnStk.push(id);
                //update prev
                prev = curr;

            }else{
                //end
                //pop id from stack

                //update result[id] = curr+1 - prev
                result[fnStk.pop()] += curr - prev +1;
                //update prev = curr+1
                prev = curr +1 ;
            }
        }
        return result;
    }
}