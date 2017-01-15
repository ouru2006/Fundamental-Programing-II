 /**
 * Ru Ou
 * V00835123
 * TaskListTester.java
 * Assignment 2
 */
import java.io.*;
import java.util.*;
public class TaskListTester{
      public static void main(String[]args){
           TaskList list=new TaskListRefBased(200);
           Task result;
           boolean passed=true;
           Task one;
           
           
           PrintStream output=null;
           try{
           output=new PrintStream(new File("test_output.txt"));
           }
           catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
           }
           
           
      
           // Test behavior of isEmpty
           if (list.isEmpty()) {
            output.println("Test 1 (isEmpty): passed");
           } else {
            output.println("Test 1 (isEmpty): FAILED");
           }
           
           
           // Test behavior of length
           if (list.getLength() == 0) {
            output.println("Test 2 (length): passed");
           } else {
            output.println("Test 2 (length): FAILED");
           }
           
           
            // Test behavior of length after inserting a single item
            one=new Task(0,1);
            list.insert(one);
            if (list.getLength() == 1) {
            output.println("Test 3 (insert): passed");
            } else {
            output.println("Test 3 (insert): FAILED");
            }
            
            
            // Test behavior of retrieve of the single item
            result = list.retrieve(0);
            if (result.priority==one.priority&&result.number==one.number) {
            output.println("Test 4 (retrieve): passed");
            } else {
            output.println("Test 4 (retrieve): FAILED");
            }
            
            // Test behavior of remove head
            list.removeHead();
            if(list.getLength()==0){
             output.println("Test 5 (removeHead): passed");
            } else {
            output.println("Test 5 (removeHead): FAILED");
            }
            
            // Test behavior when removing,remove head, and retrieve from an empty list.
            one=new Task(10, 198);
            one=list.remove(new Task(10, 198));
            if(one!=null){
            passed=false;
            }
            one=list.removeHead();
            if(one!=null){
            passed=false;
            }
            one=list.retrieve(0);
            if(one!=null){
            passed=false;
            }
            if (passed) {
            output.println("Test 6 (remove from empty list): passed");
            } else {
            output.println("Test 6 (remove from empty list): FAILED");
            }
            
            // Is the task number 
            // returned really 100? Is the resulting list really 
            // that with tasks numbered 212, then 198, then 104? boolean passed = true;
            int expected[] = {212, 198, 104}; 

            list.insert(new Task(10, 212)); 
            list.insert(new Task(12, 100)); 
            list.insert(new Task(10, 198)); 
            list.insert(new Task(3, 104));
            one= list.removeHead(); 
            if (one.number != 100) {
               passed = false; 
            }else{
              for (int i = 0; i < expected.length; i++) { 
                one= list.retrieve(i);
                if (one!= null && one.number!= expected[i]) {
                   passed = false;
                   break;
                } else if (one == null) {
                   passed = false;
                   break; 
                }
              }
            }
            if (passed) {
              output.println("Test 7 (multiple inserts and remove head): passed"); 
            }else {
              output.println("Test 7 (multiple inserts and remove head): FAILED"); 
              }
            
            
            
            // Test behavior when adding (2,91) to the end of the current list.
            int expected1[] = {212, 198, 104, 91};
            list.insert(new Task(2,91));
            for (int i = 0; i < expected1.length; i++) { 
                one= list.retrieve(i);
                if (one!= null && one.number!= expected1[i]) {
                   passed = false;
                   break;
                } else if (one == null) {
                   passed = false;
                   break; 
                }
            }
            output.println("Test 8 (insert at end): " +
            (passed ? "passed" : "FAILED"));
            
            
            

            // Test behavior when we remove item (10, 198) from the
            // list 212, 198, 104, 91 (result should be 212, 104, 91).
            list.remove(new Task(10, 198));
            int expected2[]= {212, 104, 91};
            for (int i = 0; i < expected2.length; i++) { 
                one= list.retrieve(i);
                if (one!= null && one.number!= expected2[i]) {
                   passed = false;
                   break;
                } else if (one == null) {
                   passed = false;
                   break; 
                }
            }
            output.println("Test 9 (remove from middle): " +
            (passed ? "passed" : "FAILED"));
            
            
            
            // insert several Tasks 
            // remove 10,212  3,104
            // remove head twice
            // retrieve the task 1
            
            int expected3[] = {88,91,103}; 

            list.insert(new Task(16, 218)); 
            list.insert(new Task(1, 103)); 
            list.insert(new Task(5, 77)); 
            list.insert(new Task(5, 88));
            
            
            one=list.remove(new Task(10, 212));
            if (one.number != 212) {
               passed = false; 
               
            }
            one=list.remove(new Task(3,104));
            if (one.number != 104) {
               passed = false; 
              
            }
            one=list.removeHead(); 
            if (one.number != 218) {
               passed = false; 
              
            }
            one=list.removeHead();
            if (one.number != 77) {
               passed = false; 
              
            }
            one=list.retrieve(1);
            if (one.number != 91) {
               passed = false; 
               
            }
           
           for (int i = 0; i < expected3.length; i++) { 
                  one= list.retrieve(i);
                if (one!= null && one.number!= expected3[i]) {
                   passed = false;
                   break;
                } else if (one == null) {
                   passed = false;
                   break; 
                }
           }
           output.println("Test 10 (general test): " +
            (passed ? "passed" : "FAILED"));
            
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}
}