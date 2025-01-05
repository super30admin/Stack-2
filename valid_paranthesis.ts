function isValidParentheses(s: string): boolean {
  let stack: string[] = [];
  for (const c of s) {
    if (c == "(" || c == "[" || c == "{") stack.push(c);
    else if (c == ")" && (stack.length == 0 || stack[stack.length - 1] != "("))
      return false;
    else if (c == "]" && (stack.length == 0 || stack[stack.length - 1] != "["))
      return false;
    else if (c == "}" && (stack.length == 0 || stack[stack.length - 1] != "{"))
      return false;
    else stack.pop();
  }
  return stack.length == 0;
}

describe("20. Valid Parentheses", () => {
  it("New Logic - 01", () => {
    expect(isValidParentheses("()[]{}")).toStrictEqual(true);
  });
});
