// This uses a stack based approach to track time for respective function
// For any function that starts, we need to push it to the stack function id and index. If there is an existing function the updated time for that function is calculated and kept in array i.e., previous function processing time
// For any other function that ends, we need to calculcate time for it as it expected that its start index is present on the stack. Only catch being if its end we need add additonal 1 to it considering it occupies all that time slot
// At the same time we need to push the last element in the stack index as curr+1 because the last function in the stack will automatically start running if nested function ends
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> function = new Stack();
        Stack<Integer> index = new Stack();

        for(String log:logs) {
            String[] split = log.split(":");
            int fun = Integer.parseInt(split[0]);
            String op = split[1];
            int ind = Integer.parseInt(split[2]);

            if(op.equals("start")) {
                if(!function.isEmpty()) {
                    result[function.peek()]+=ind-index.peek();
                }
                function.push(fun);
                index.push(ind);
            } else {
                result[function.pop()]+=ind-index.pop()+1;
                if(!function.isEmpty()) {
                    int val = index.pop();
                    index.push(ind+1);
                }
            }
        }

        return result;
    }
}
