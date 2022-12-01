// Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * @param {number} n
 * @param {string[]} logs
 * @return {number[]}
 */
var exclusiveTime = function (n, logs) {
    let result = new Array(n);
    result.fill(0);
    let currTS = 0;
    let stack = [];
    for (let i = 0; i < logs.length; i++) {
        let log = logs[i].split(":");
        let id = log[0];
        let condition = log[1];
        let incomingTS = parseInt(log[2]);
        if (condition === "start") {
            // The log with id at top of stack will stop running, add the time till now to result
            if (stack.length > 0) {
                result[stack[stack.length - 1]] += (incomingTS - currTS);
            }
            // Push new id and update curr time
            stack.push(id);
            currTS = incomingTS;
        } else {
            // If function ends, pop the top id and add its execution time to result 
            if (stack.length > 0) {
                result[stack.pop()] += (incomingTS - currTS + 1);
            }
            currTS = incomingTS + 1;
        }
    }
    return result;
};
