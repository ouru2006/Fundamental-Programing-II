 /**
 * Ru Ou
 * V00835123
 * TaskListRefBased.java
 * Assignment 2
 */
 public class TaskListRefBased implements TaskList {
    private int length;
    private TaskListNode head;
    private Task t;
    private int max;
    
    
    public TaskListRefBased(int size) {
          head=null;
          this.max=size;
          this.t=null;
          int length=0;
    }


    public int getLength() {
        System.out.println("ECHO getLength()");
        return length;
    }


    public boolean isEmpty() {
        
        System.out.println("ECHO isEmpty()");
        return (length==0);
    }



    public Task removeHead() {
     
       if(isEmpty()){
       System.out.println("List Empty");
       return null;
       }
       
     
       else{
        System.out.println("ECHO removeHead()");
        Task result=new Task(head.priority,head.number);
        head=head.next;
        length--;
        
        return result;
        }
        
    }
    

    
    public Task remove(Task t)  {
      
        TaskListNode prev=null;
        TaskListNode succ=head;
        TaskListNode temp2=null;
        
        if(length==0){
        System.out.println("List Empty");
        return null;
        }
        
        while(succ!=null){
            if(succ.priority==t.priority&&succ.number==t.number){
                 if(prev!=null){
                 prev.next=succ.next;
                 
                 for ( TaskListNode temp=head;(temp.priority!=prev.priority)||(temp.number!=prev.number);temp=temp.next)  {
                     succ=new TaskListNode(temp.priority,temp.number);
             
                     succ.next=temp2;
             
                     temp2=succ;
                  }
                for(   TaskListNode temp=temp2;temp!=null;temp=temp.next){
           
                    succ=new TaskListNode(temp.priority,temp.number);
                    succ.next=prev;
                    prev=succ;
                 } 
                 }else{
                 prev=succ.next;
                 }
                 System.out.println("ECHO remove "+t.priority+" "+t.number);
                 break;
            }else if(succ.next==null){
                 System.out.println("cannot find "+t.priority+" "+t.number);
                 return null;
                 }
            else{
            prev=succ;
            succ=succ.next;
            }
        }
            
           head=prev;
           length--;
           
           return t;
      
    }


    public void insert(Task t) {
        if(length>=max){
         System.out.println("List full.");
        }else{
         TaskListNode list=new TaskListNode(t.priority,t.number);
         TaskListNode prev=null;
         TaskListNode succ=head;
         TaskListNode temp2=null;
         while(succ!=null){
          if(t.priority<=succ.priority){     
                prev=succ;
                succ=succ.next;
                    
          }
          else{
               break;
          }
        }
        
        list.next=succ;
        
        if(prev==null){
        
           head=list;
          
        }else{
           prev.next=list;
           
           
           for ( TaskListNode temp=head;(temp.priority!=prev.priority)||(temp.number!=prev.number);temp=temp.next)  {
             succ=new TaskListNode(temp.priority,temp.number);
             
             succ.next=temp2;
             
             temp2=succ;
            }
           for(   TaskListNode temp=temp2;temp!=null;temp=temp.next){
           
             succ=new TaskListNode(temp.priority,temp.number);
             succ.next=prev;
             prev=succ;
           }    
           head=prev;
           }   
             
        System.out.println("ECHO insert(Task(" + t.priority + " " +
            t.number + "))");
            length++;
      }
    }


    public Task retrieve(int i){
        if(isEmpty()){
        System.out.println("List Empty");
        return null;
        }
        int acc=0;
    
        for(TaskListNode list=head;list!=null;list=list.next){
        
           if(acc==i){
             t=new Task(list.priority,list.number);
             System.out.println("ECHO retrieve(" + i + ")");
             return t;
           }else if(list.next==null){
             System.out.println("There is no such task "+i);
             return null;
           }
           else{
            acc++;
           }
        }
       return null;
     }
}
