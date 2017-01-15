 
 /**
 * Ru Ou
 * V00835123
 * MazeTester.java
 * Assignment 3
 */ 

public class MazeTester{
      
      
      public static void main (String[]args){
      boolean passed = true;
      
     
           
      //test 1
      String testcase[] = {"* ****",
                           "*    *",
                           "**** *"};
      Maze maze = new Maze(testcase, 0, 1, 2, 4);
      MazeLocation expected[] = new MazeLocation[6]; 
      expected[0] = new MazeLocation(0, 1); 
      expected[1] = new MazeLocation(1, 1); 
      expected[2] = new MazeLocation(1, 2); 
      expected[3] = new MazeLocation(1, 3); 
      expected[4] = new MazeLocation(1, 4); 
      expected[5] = new MazeLocation(2, 4); 
      MazeLocationList result = maze.solve();
     
      if (result == null) { 
         passed = false;
      } else if (result.isEmpty() == true) {
         passed = false;
      } else {
         for (int i = 0; i < result.getLength(); i++) {
            MazeLocation loc = result.retrieve(i); 
            if (loc.equals(expected[i]) == false) {
               passed = false;
               break; 
            }
         }
      }
     if (passed) {
     System.out.println("Test one (horizonal path): passed");
     } else {
     System.out.println("Test one (horizonal path): FAILED");
     }
     
     
     //test2
     String testcase2[] = {"* ****",
                          "*    *",
                          "**** *",
                          "**** *",
                          "**** *",
                          "**** *",
                          "**** *"};
      maze = new Maze(testcase2, 0, 1, 6, 4);
      MazeLocation expected2[] = new MazeLocation[10]; 
      expected2[0] = new MazeLocation(0, 1); 
      expected2[1] = new MazeLocation(1, 1); 
      expected2[2] = new MazeLocation(1, 2); 
      expected2[3] = new MazeLocation(1, 3); 
      expected2[4] = new MazeLocation(1, 4); 
      expected2[5] = new MazeLocation(2, 4); 
      expected2[6] = new MazeLocation(3, 4); 
      expected2[7] = new MazeLocation(4, 4); 
      expected2[8] = new MazeLocation(5, 4); 
      expected2[9] = new MazeLocation(6, 4); 
      result = maze.solve();
     
      if (result == null) { 
         passed = false;
      } else if (result.isEmpty() == true) {
         passed = false;
      } else {
         for (int i = 0; i < result.getLength(); i++) {
            MazeLocation loc = result.retrieve(i); 
            if (loc.equals(expected2[i]) == false) {
               passed = false;
               break; 
            }
         }
      }
     if (passed) {
     System.out.println("Test two (vertical path): passed");
     } else {
     System.out.println("Test two (vertical path): FAILED");
     }
     
     //test3
     String testcase3[] = {"* ******",
                           "*   ****",
                           "** *** *",
                           "**** ***",
                           "**** ***",
                           "**** ***",
                           "****** *"};
      maze = new Maze(testcase3, 0, 1, 6, 6);
       
      result = maze.solve();
     
      if (result!= null) { 
         passed = false;
      } 
     if (passed) {
     System.out.println("Test three (no path): passed");
     } else {
     System.out.println("Test three (no path): FAILED");
     }
     
     
     
     //test4
     String testcase4[] = {"* *********",
                           "*         *",
                           "** * **** *",
                           "*  *    ***",
                           "**** **  **",
                           "**** ***  *",
                           "********* *"
                           };
      maze = new Maze(testcase4, 0, 1, 6, 9);
      MazeLocation expected4[] = new MazeLocation[15]; 
      expected4[0] = new MazeLocation(0, 1); 
      expected4[1] = new MazeLocation(1, 1); 
      expected4[2] = new MazeLocation(1, 2); 
      expected4[3] = new MazeLocation(1, 3); 
      expected4[4] = new MazeLocation(1, 4); 
      expected4[5] = new MazeLocation(2, 4); 
      expected4[6] = new MazeLocation(3, 4); 
      expected4[7] = new MazeLocation(3, 5); 
      expected4[8] = new MazeLocation(3, 6); 
      expected4[9] = new MazeLocation(3, 7);
      expected4[10] = new MazeLocation(4, 7); 
      expected4[11] = new MazeLocation(4, 8); 
      expected4[12] = new MazeLocation(5, 8); 
      expected4[13] = new MazeLocation(5, 9); 
      expected4[14] = new MazeLocation(6, 9); 
      
      result = maze.solve();
     
      if (result == null) { 
         passed = false;
      } else if (result.isEmpty() == true) {
         passed = false;
      } else {
         for (int i = 0; i < result.getLength(); i++) {
            MazeLocation loc = result.retrieve(i); 
            if (loc.equals(expected4[i]) == false) {
               passed = false;
               break; 
            }
         }
      }
     if (passed) {
     System.out.println("Test four (find true path): passed");
     } else {
     System.out.println("Test four (find true path): FAILED");
     }
     
     //test5
     String testcase5[] = {"* ****************",
                           "* *********** ****",
                           "*                *",
                           "* * * **** **** **",
                           "* * *   **      **",
                           "* * *** **  ******",
                           "* * *** *** ******",
                           "* * ***  *    ****",
                           "* * **  *****    *",
                           "**************** *",
                           };
      maze = new Maze(testcase5, 0, 1, 9, 16);
      MazeLocation expected5[] = new MazeLocation[25]; 
      expected5[0] = new MazeLocation(0, 1); 
      expected5[1] = new MazeLocation(1, 1); 
      expected5[2] = new MazeLocation(2, 1); 
      expected5[3] = new MazeLocation(2, 2); 
      expected5[4] = new MazeLocation(2, 3); 
      expected5[5] = new MazeLocation(2, 4); 
      expected5[6] = new MazeLocation(2, 5); 
      expected5[7] = new MazeLocation(2, 6); 
      expected5[8] = new MazeLocation(2, 7); 
      expected5[9] = new MazeLocation(2, 8);
      expected5[10] = new MazeLocation(2, 9); 
      expected5[11] = new MazeLocation(2, 10); 
      expected5[12] = new MazeLocation(3, 10); 
      expected5[13] = new MazeLocation(4, 10); 
      expected5[14] = new MazeLocation(5, 10); 
      expected5[15] = new MazeLocation(5, 11); 
      expected5[16] = new MazeLocation(6, 11); 
      expected5[17] = new MazeLocation(7, 11); 
      expected5[18] = new MazeLocation(7, 12); 
      expected5[19] = new MazeLocation(7, 13); 
      expected5[20] = new MazeLocation(8, 13);
      expected5[21] = new MazeLocation(8, 14); 
      expected5[22] = new MazeLocation(8, 15); 
      expected5[23] = new MazeLocation(8, 16); 
      expected5[24] = new MazeLocation(9, 16); 
     
      
      result = maze.solve();
     
      if (result == null) { 
         passed = false;
      } else if (result.isEmpty() == true) {
         passed = false;
      } else {
         for (int i = 0; i < result.getLength(); i++) {
            MazeLocation loc = result.retrieve(i); 
            if (loc.equals(expected5[i]) == false) {
               passed = false;
               break; 
            }
         }
      }
     
     System.out.println("Test five (complex path): " +
            (passed ? "passed" : "FAILED"));
     
    
    
    //test6
     String testcase6[] = {"* ****************",
                           "* ** ******** ****",
                           "*                *",
                           "* * * **** **** **",
                           "* * *   **      **",
                           "* * *** *** ******",
                           "* * *   *** ******",
                           "* * ***  *    ****",
                           "* * **  *****    *",
                           "* * **  ***** ****",
                           "* *   *  *    ****",
                           "* *** * ** *******",
                           "* *   ****       *",
                           "**************** *",
                           };
      maze = new Maze(testcase6, 0, 1, 13, 16);
      MazeLocation expected6[] = new MazeLocation[35]; 
      expected6[0] = new MazeLocation(0, 1); 
      expected6[1] = new MazeLocation(1, 1); 
      expected6[2] = new MazeLocation(2, 1); 
      expected6[3] = new MazeLocation(2, 2); 
      expected6[4] = new MazeLocation(2, 3); 
      expected6[5] = new MazeLocation(2, 4); 
      expected6[6] = new MazeLocation(2, 5); 
      expected6[7] = new MazeLocation(2, 6); 
      expected6[8] = new MazeLocation(2, 7); 
      expected6[9] = new MazeLocation(2, 8);
      expected6[10] = new MazeLocation(2, 9); 
      expected6[11] = new MazeLocation(2, 10); 
      expected6[12] = new MazeLocation(3, 10); 
      expected6[13] = new MazeLocation(4, 10); 
      expected6[14] = new MazeLocation(4, 11); 
      expected6[15] = new MazeLocation(5, 11); 
      expected6[16] = new MazeLocation(6, 11); 
      expected6[17] = new MazeLocation(7, 11); 
      expected6[18] = new MazeLocation(7, 12); 
      expected6[19] = new MazeLocation(7, 13); 
      expected6[20] = new MazeLocation(8, 13);
      expected6[21] = new MazeLocation(9, 13); 
      expected6[22] = new MazeLocation(10, 13); 
      expected6[23] = new MazeLocation(10, 12); 
      expected6[24] = new MazeLocation(10, 11); 
      expected6[25] = new MazeLocation(10, 10); 
      expected6[26] = new MazeLocation(11, 10); 
      expected6[27] = new MazeLocation(12, 10); 
      expected6[28] = new MazeLocation(12, 11); 
      expected6[29] = new MazeLocation(12, 12);
      expected6[30] = new MazeLocation(12, 13);
      expected6[31] = new MazeLocation(12, 14); 
      expected6[32] = new MazeLocation(12, 15); 
      expected6[33] = new MazeLocation(12, 16); 
      expected6[34] = new MazeLocation(13, 16); 
     
     
      
      result = maze.solve();
     
      if (result == null) { 
         passed = false;

      } else if (result.isEmpty() == true) {
         passed = false;
        
      } else {
         for (int i = 0; i < result.getLength(); i++) {
            MazeLocation loc = result.retrieve(i);
            
            if (loc.equals(expected6[i]) == false) {
               passed = false;
               
               break; 
            }
         }
      }
      
     
     
     System.out.println("Test six (complex path): " +
            (passed ? "passed" : "FAILED"));
     
      
}
}