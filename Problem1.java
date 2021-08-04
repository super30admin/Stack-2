
// time - O(N)
// space - O(N)


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int [] result = new int[n];
        int prev = 0;
        Stack<Integer> stk = new Stack<>();

        for(String log: logs) {

            String [] strArr = log.split(":");

            int current = Integer.parseInt(strArr[2]);

            if(strArr[1].equals("start")) { // if the element equals start

                if(!stk.isEmpty()) { // if the stk contains elements

                    result[stk.peek()] += current - prev;

                }
                // if the stack is empty
                stk.push(Integer.parseInt(strArr[0]));
                prev = current;

            }
            else {
                // if the element equals start
                result[stk.pop()] += current - prev + 1;
                prev = current + 1;

            }


        }

        return result;

    }
}