class MinStack {
    Deque<Integer> s;
    Deque<Integer> ms;    

    public MinStack() {
        s = new ArrayDeque<>();
        ms = new ArrayDeque<>();
    }
    
    public void push(int val) {
        s.push(val);
        if (!ms.isEmpty() && val > ms.peek()) {
            ms.push(ms.peek());
        } else { 
            ms.push(val);
        }
    }
    
    public void pop() {
        if(!s.isEmpty()){
            s.pop();
            ms.pop();        
        }
    }
    
    public int top() {
        if(!s.isEmpty()){
            return s.peek();
        }
        return 0;
    }
    
    public int getMin() {
        if(!ms.isEmpty()){   
            return ms.peek();
        }
        return 0;
    }
}
