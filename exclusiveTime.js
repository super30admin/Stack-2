/**
Intuition:
Use a stack to simulate function calls — the top of the stack is the function currently running.
When a new function starts, pause the current one, by adding elapsed time to its result, then push the new function onto the stack.
When a function ends, add its inclusive time (+1'), pop it, and update the parent’s start time to resume right after it finishes.
T.C: O(n) // logs length
S.C: O(n) // stack space for logs
 */
var exclusiveTime = function (n, logs) {
    let stack = [];
    let result = new Array(n).fill(0);
    for (let i = 0; i < logs.length; i++) {
        let [job, flag, slot] = logs[i].split(':');
        slot = Number(slot);
        job = Number(job);
        if (flag === 'start') {
            if (stack.length) {
                let [peekJob, peekTime] = stack[stack.length - 1];
                result[peekJob] += slot - peekTime;
            }
            stack.push([job, slot]);
        } else {
            let [poppedJob, poppedTime] = stack.pop();
            result[poppedJob] += slot + 1 - poppedTime;
            if (stack.length) {
                stack[stack.length - 1][1] = slot + 1;
            }
        }

    }
    return result;
};