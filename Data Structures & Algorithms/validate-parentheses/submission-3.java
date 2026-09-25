class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');

        Deque<Character> q = new ArrayDeque<>();
        for(Character ch : s.toCharArray()){
            if(ch.equals(')') || ch.equals('}') || ch.equals(']')){
                if(q.isEmpty()) return false;
                Character c = q.pop();
                if(!c.equals(mp.get(ch))) return false; 
            }else{
                q.push(ch);
            }
        }

        return q.isEmpty();
    }
}

// TC O(N)
// SC O(1)