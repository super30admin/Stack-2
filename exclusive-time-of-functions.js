// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number} n
 * @param {string[]} logs
 * @return {number[]}
 */
var exclusiveTime = function(n, logs) {
    if (!n || !logs || !logs.length) return [];

    const result = new Array(n).fill(0);
    const st = [];
    let priorTimestamp = 0;
    let currentTimestamp = 0;

    for (const log of logs) {
        const token = log.split(":");
        
        const functionId = parseInt(token[0]);
        const currTimestamp = parseInt(token[2]);
        if (token[1] == "start") {
            if (st.length > 0) result[st[st.length - 1]] += currTimestamp - priorTimestamp;
            st.push(functionId)
            priorTimestamp = currTimestamp;
        } else {
            result[st.pop()] += currTimestamp - priorTimestamp + 1;
            priorTimestamp = currTimestamp + 1;
        }
    }
    return result;
};
