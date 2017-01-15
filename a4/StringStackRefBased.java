/**
 * Ru Ou
 * V00835123
 * Assignment #4
 *
 * Michael Zastre
 */
public class StringStackRefBased implements StringStack {
    StringNode head;

    public StringStackRefBased() {
        head =null;
    }

    /**
     * Returns true if there are no strings in the stack; false
     * otherwise.
     * @return true or false as described
     */
    public boolean isEmpty() {
        return (head==null);
    }



    /**
     * If the stack contains at least one string, then the string
     * at the top of the stack is removed, and the value contained
     * returned to the caller. Otherwise if the stack was empty
     * at the start of the method, then a StringStackException must
     * be thrown.
     *
     * @return the value of the String at the top of the stack.
     */
    public String pop() throws StringStackException {
        if (head==null) {
            throw new StringStackException("pop() on empty stack");
        } else {
            String result=head.item;
            head=head.next;
            return result;                
        }
    }

    /**
     * Clears the stack such that is contains no elements (i.e.,
     * isEmpty() on the stack will be true after this call completes).
     */
    public void popAll() {
        head=null;
    }
    
    /**
     * Places the item onto the top of the stack. However, if there
     * is no room in which to place this item, then the method
     * must instead thrown a StringStackException.
     */
    public void push(String item) throws StringStackException{
      
        StringNode temp=head;
        head=new StringNode(item);
        head.next=temp;
        
    }
    
    /**
     * If the stack contains at least one string, then the value of
     * the String at the top of the stack is returned to the caller.
     * Otherwise if the stack was empty at the start of the method, 
     * then a StringStackException must be thrown. This method
     * does not modify the stack's contents.
     *
     * @return the value of the String at the top of the stack.
     */    
    public String peek() throws StringStackException {
        if (head==null) {
            throw new StringStackException("pop() on empty stack");
        } else {
            String result =head.item;
            return result;                
        }
    }
    
     
    
    public static void main(String[]args){
        StringStack stack = new StringStackRefBased();
        boolean result = true;
        if(!stack.isEmpty()){
            System.out.println("Error."); 
        
        }
        
        try{
           stack.push("first");
           stack.push("last");
        }catch(StringStackException e){
           System.err.println("WHAT!");  
           System.exit(1);
        }
        
        try{
        stack.pop();
        if(stack.peek()!="first"){
           System.out.println("Error(pop&peek)."); 
        }
        }catch(StringStackException e){
           System.err.println("WHAT!");  
           System.exit(1);
        }
        
        stack.popAll();
        if(!stack.isEmpty()){
            System.out.println("Error(popAll)."); 
        
        }
        
        
    
    }
}
