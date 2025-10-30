// Time complexity- O(n), where n is the length of the string
// Space complexity- O(n)
function isValid(s: string): boolean {
	const n = s.length;
	const stack = [];

	for (let i = 0; i < n; i++) {
		const ch = s[i];

		// we push the expected closing parenthesis onto the stack for any opening bracket
		// when we encounter a closing bracket, it should match the top element in the stack for the parentheses to be valid
		if (ch == "(") {
			stack.push(")");
		} else if (ch == "{") {
			stack.push("}");
		} else if (ch == "[") {
			stack.push("]");
		} else if (stack.length < 1 || ch != stack.pop()) return false;
	}

	// if we've processed all parentheses and the stack is not empty, it means we couldn't find the closing parentheses
	return stack.length === 0 ? true : false;
}
