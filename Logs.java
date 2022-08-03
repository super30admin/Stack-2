class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int time = 0;
        Stack<int[]> stack = new Stack<>();
        int result[] = new int[n];

        for (String s : logs) {
            int functionId = Integer.parseInt(s.substring(0, s.indexOf(":")));
            String command = s.substring(s.indexOf(":") + 1, s.lastIndexOf(":"));
            int timestamp = Integer.parseInt(s.substring(s.lastIndexOf(":") + 1));

            if (command.equals("start"))
                stack.push(new int[] { functionId, timestamp });

            else {
                int dur = (timestamp - stack.peek()[1]) + 1;
                result[functionId] += dur;
                stack.pop();
                if (!stack.isEmpty())
                    result[stack.peek()[0]] -= dur;
            }
        }
        return result;
    }
}