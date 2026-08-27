class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        String ans = "";

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')') st.pop();
            
              if(!st.empty()) ans+=ch;
              if(ch=='(') st.push(ch);

            }
        
     return ans;
}
}