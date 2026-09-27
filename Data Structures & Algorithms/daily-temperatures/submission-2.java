class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < len; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int prevLow = st.pop();
                res[prevLow] = i - prevLow;
            }
            st.push(i);
        }

        return res;
    }
}
// TC: O(N) Iterating the loop
// SC: O(N) len of an array in worst case as the length of the stack would be n in case of decreasing array
