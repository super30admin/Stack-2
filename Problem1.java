//Time = O(n), number of logs
//Space = O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
    int[] res = new int[n]; // Initialize an array of size n to store exclusive times
    Stack<Integer> stack = new Stack<>(); // Initialize a stack to keep track of function ids
    int prevTime = 0; // Initialize prevTime to 0
    
    // Iterate through each log in logs
    for (String log : logs) {
        String[] parts = log.split(":"); // Split the log string into its parts
        int id = Integer.parseInt(parts[0]); // Parse the id as an integer
        String action = parts[1]; // Get the action (start or end)
        int currTime = Integer.parseInt(parts[2]); // Parse the current time as an integer
        
        // If the stack is not empty, update the exclusive time of the previous function
        if (!stack.isEmpty()) {
            int prevId = stack.peek(); // Get the previous function id
            res[prevId] += currTime - prevTime; // Add the difference to its exclusive time
        }
        prevTime = currTime; // Update prevTime to the current time
        
        // If the action is "start", push the id onto the stack
        if (action.equals("start")) {
            stack.push(id);
        } 
        // If the action is "end", update the exclusive time of the current function and pop it from the stack
        else {
            res[id]++; // Add one to the exclusive time of the current function
            prevTime++; // Increment prevTime to account for end time
            stack.pop();
        }
    }
    
    return res; // Return the array of exclusive times
    }

}
