// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    
    int start = 0;
    Stack<Integer> stack = new Stack<>();
    int[] res;
    
    public int[] exclusiveTime(int n, List<String> logs) {
        
        res = new int[n];
        
        for(String log : logs) {
            
            String[] strArr = log.split(":");
            int id = Integer.parseInt(strArr[0]);
            int time = Integer.parseInt(strArr[2]);
           
            if(strArr[1].equals("start")) {
                if(!stack.isEmpty())
                    res[stack.peek()] += time - start;
                stack.push(id);
                start = time;
            }
            else {
                res[stack.pop()] += time - start + 1;
                start = time+1;
            }

        }

        return res;
        
    }
}






// // ******************** Another Method of storing {id, time} both ********************


// // Time Complexity:  O(n)
// // Space Complexity: O(n)
// // where n is length of given List of Strings

// class Solution {

//     public int[] exclusiveTime(int n, List<String> logs) {
        
//         Stack<int[]> stack = new Stack<>();
//         int[] result = new int[n];
//         int prev = 0;
        
//         for(int i=0; i<logs.size(); i++) {
            
//             String str = logs.get(i);
            
//             // SPLITTING STRING
//             String[] strArr = str.split(":");
            
//             int id = Integer.parseInt(strArr[0]);
//             String type = strArr[1];
//             int time = Integer.parseInt(strArr[2]);
            
//             if(type.equals("start")) {                                       // if this is starting of the function
//                 stack.push(new int[]{id, time});                             // we will simply add current function id and start time in stack
//             }
            
//             else {                                                           // if this is end of the function
//                 int startTime = stack.pop()[1];
//                 int spentTime = time - startTime + 1;                        // got the spent time of the current function
//                 result[id] += spentTime;                                     // update current function time in "result"
//                 if(!stack.isEmpty()) {
//                     result[stack.peek()[0]] -= spentTime;                    // subtract current function time from prev function in "result" if present, because we will add it extra in future 
//                 }
//             }
//         }
//         return result;
//     }
// }
