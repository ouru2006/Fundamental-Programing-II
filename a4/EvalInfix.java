/**
 * Ru Ou
 * V00835123
 * Assignment #4
 *
 * Michael Zastre
 */

public class EvalInfix {
    /**
     * First ensure the arithmetic operations plus parentheses
     * are surrounded by spaces. Then go ahead and split up the
     * whole expression using spaces (i.e, the operands will be
     * nicely separated from everything else by at least a single
     * space). This will not work for negative numbers.
     */
    public static String[] tokenize(String s) {
        // Note the missing minus character...
        String symbols[] = {"\\(", "\\)", "\\+", "\\-", "\\*", "\\/"};

        // First eliminate any quotation marks
        s = s.replaceAll("'", " ");
        s = s.replaceAll("\"", " ");

        // Now all operators or parentheses, surround the character
        // with a single space on either side.
        for (int i = 0; i < symbols.length; i++) {
            String regex = symbols[i];
            String replace = " " + regex + " ";
            s = s.replaceAll(regex, replace);
        }   

        // Special case: If there is a unary minus, then then
        // what appears to the right of the symbol is whitespace
        // and a digit; what appears to the left whitespace
        // and a non-digit symbol.
        s = s.replaceAll("(^|([\\+\\-\\*\\/]))\\s+\\-\\s+(\\d+)", "$1 -$3");

        // Eliminate extra whitespaces at start and end of the
        // transformed string. 
        s = s.trim();

        // Finally, take advantage of the whitespace to create an
        // array of strings where each item in the array is one
        // of the elements in the original string passed in to this
        // method.
        return s.split("\\s+");
    } 
    
    /**
     *check parenthesis on infix expression  
     *by StringStack
     */       
    public static boolean isBalanced(String expr){
        StringStack stack = new StringStackRefBased();
        boolean result = true;

        try {
            for (int i = 0; i < expr.length(); i++) {
                if (expr.charAt(i) == '(') {
                    stack.push("(");
                } else if (expr.charAt(i) == ')') {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                result = true;
            } else {
                result = false;
            }
        } catch (StringStackException e) {
            result = false;
        }

        return result;
    
    }
    
    
    
    /**
     *a method represent the operators by numbers 
     */       
    public static int precedence(String s) {
        if (s.equals("/")) {
            return 2;
        } else if (s.equals("*")) {
            return 2;
        } else if (s.equals("-")) {
            return 1;
        } else if (s.equals("+")) {
            return 1;
        } 
        else {
            return 0;
        }
    }   
    

    /**
     *convert infix to postfix  
     *by StringStack and StringList
     */     
    public static StringList toPostfix(String[]array){
        StringStack stack = new StringStackRefBased();
        StringList list=new StringListRefBased();
       try{
        for (int i=0; i<= array.length-1;i++) {
           if(precedence(array[i])!=0){
              while(!stack.isEmpty()&&!stack.peek().equals("(")&&
                     precedence(stack.peek()) >= precedence(array[i])){
                 list.insertTail(stack.peek());
                 stack.pop();
              }
                 
              stack.push(array[i]);
             
           }else if (array[i].equals("(")) {
             
              stack.push("(");
             
           }else if(array[i].equals(")")){
               
               while(!stack.peek().equals("(")){
                 list.insertTail(stack.peek());
                 stack.pop();
               }
               stack.pop();
                  
                  
           }else{
               list.insertTail(array[i]); 
                    
              
              
           
           }
            
        }
        
        while(!stack.isEmpty()){
           list.insertTail(stack.peek());
           stack.pop();
        }
      } catch(StringStackException e){
              System.exit(1);
      }
        return list;
   
    }
    
    
    /**
     *evaluate postfix expression    
     *calculate the postfix
     */ 
    public static String evaluatePostfix(StringList list){
        String result=null;
        int frontNumber=0;
        int backNumber=0;
        StringList evalu=new StringListRefBased();
        
        for(int i=0;i<list.getLength();i++){
           
           if(precedence(list.retrieve(i))!=0){
              if(evalu.getLength()<2){
                 System.err.println("<syntax error>");
                 System.exit(1);
              }
              try{
                 frontNumber= Integer.parseInt(evalu.retrieve(evalu.getLength()-2));
                 backNumber= Integer.parseInt(evalu.retrieve(evalu.getLength()-1));
              }catch(NumberFormatException e){
                 System.err.println("<noninteger>");
                 System.exit(1);
              } 
              
              if(list.retrieve(i).equals("*")){
                 frontNumber=frontNumber*backNumber;
              }else if(list.retrieve(i).equals("/")){
                 try{
                    frontNumber=frontNumber/backNumber;
                 }catch(ArithmeticException e){
                    System.err.println("<divide by zero>");
                    System.exit(1);
                 }
              }else if(list.retrieve(i).equals("+")){
                 frontNumber=frontNumber+backNumber;
              }else if(list.retrieve(i).equals("-")){
                 frontNumber=frontNumber-backNumber;
              }
                 evalu.removeTail();
                 evalu.removeTail();
                 result=Integer.toString(frontNumber);
                 evalu.insertTail(result);
           }else{
           evalu.insertTail(list.retrieve(i));
           }
        }
       
        if(evalu.getLength()==1){
           result=evalu.retrieve(0);
        }else{
           System.err.println("<syntax error>");
           System.exit(1);
        }
        
        
        
        
        return result;
    }
    

   /**
    *If expression has unbalanced parentheses then return the string “<unbalanced ()>” (A)
    *Split string into an array of strings, one string per token (B)
    *Pass the string array to a method returning a StringList that is the postfix representation of the infix expression (C)
    *Use the StringList as an argument to a method that evaluates the postfix expression and returns a string as a result (D)
    *Return the String produced in the last step
    */
    public static String evaluateExpression(String expr) {
        String result =null;
        
    //check parenthesis on infix expression   
        if(!isBalanced(expr)){
            System.err.println("<unbalanced ()>");
            System.exit(1);
            
        }
        
    //change to array of string-tokenize    
        String[] element=tokenize(expr);
        

    //convert infix to postfix    
        StringList list=toPostfix(element);
        
    //evaluate postfix expression 
        result=evaluatePostfix(list);
          
                
        
        
       
        
        
       
    
        

        return result;
    }
 

    public static void main(String args[]) {
        if (args.length < 1) {
            System.err.println("usage: java EvalInfix '<expression>'");
            System.exit(1);
        }
        
        System.out.println(evaluateExpression(args[0]));

    }
}
