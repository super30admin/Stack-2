// Time Complexity : O(n), where n is the number of logs in the input list
// Space Complexity : O(n), where n is the number of logs in the input list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Create a stack to maintain the execution order of the functions and a variable to maintain the current start time of the system
//2. Iterate over te logs and for each log check if it is start of a function and do the follwing
        //1. If the stack is Not empty, then update the index equal to function's Id (at stack top) with the the execution time
                //(start - currStart)
        //2. add the new funstion on the stack top and upadte currStart time to the current functions start time (currStart = start)
//3. If it is end of the funstion, do the following,
        //1. then update the index equal to function's Id(function at stack top) with the the execution time (start - currStart + 1)
        //2. remove the function from stack top and update currStart to the current function's end time plus 1 (currStart = end + 1)
                //Assumption (end's next second will the currStart of the system)
                            //(start is at the start of the specified time)
                            //(end is at the end of the specified time, and that is the reason we do +1 to find execution time)
//Return the result

// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        //result array
        int[] result = new int[n];
        
        //create a stack to maintain the execution order of the functions
        Stack<String> st = new Stack<>();
        
        //maintain the current start time
        int currStart = 0;
        //iterate over all the logs
        for(String log : logs){
            //split the string into array ["id", "start/end", "timestamp"]
            String[] logArr = log.split(":");
            //check if it is a start or end of a function
            if(logArr[1].equals("start")){//start
                if(!st.isEmpty()){
                    //update the index of the function's (under execution) execution time in the result
                    result[Integer.parseInt(st.peek())] += Integer.parseInt(logArr[2])-currStart;
                }
                st.push(logArr[0]);//make it the current function under execution
                currStart = Integer.parseInt(logArr[2]); //update the current start with functions start time
            }else{//end
                //update the index of the function's (under execution) execution time in the result
                result[Integer.parseInt(st.peek())] += Integer.parseInt(logArr[2]) - currStart+1;
                currStart = Integer.parseInt(logArr[2]) + 1; //plus 1, because this the function has a end time
                st.pop(); //function execution done
            }
        }
        return result;
    }
}