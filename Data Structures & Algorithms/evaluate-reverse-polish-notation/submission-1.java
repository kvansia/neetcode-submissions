class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                Integer b = st.pop();
                Integer a = st.pop();
                switch(s){
                    case("+"):
                        st.push(a+b);
                        break;
                    case("-"):
                        st.push(a-b);
                        break;
                    case("*"):
                        st.push(a*b);
                        break;
                    case("/"):
                        st.push(a/b);
                        break;
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
