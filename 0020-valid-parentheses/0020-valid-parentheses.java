class Solution {
    public boolean isValid(String s) {
        // create a stack
        Stack<Character> charStack = new Stack<Character>();

        // traverse through the string
        for (char bracket : s.toCharArray()) {
            // if the bracket is one of the opening brackets then push the bracket in the stack
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                charStack.push(bracket);
            } else {
                // check if the stack is empty for the scenario when all the brackets are closing one
                if (charStack.isEmpty()) {
                    return false;
                } else {
                    // pop the first element from the stack
                    char top = charStack.peek();

                    // check if the top bracket from the stack is similar to the current bracket
                    if ((top == '(' && bracket == ')') || (top == '{' && bracket == '}') || (top == '[' && bracket == ']')) {
                        charStack.pop();
                    } else {
                        // there is a presence of an odd number of brackets
                        return false;
                    }
                }
            }
        }

        return charStack.isEmpty();
    }
}