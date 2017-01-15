 /**
 * Ru Ou
 * V00835123
 * Maze.java
 * Assignment 3
 */
public class Maze{
      
      private int startRow;
      private int startCol;
      private int finishRow;
      private int finishCol;
      private MazeLocationList list;
      private MazeLocation locS;
      private int [][]path;
      private boolean check=true;

      
 public Maze(String[] textmaze, int startRow, int startCol, int finishRow, int finishCol){
            
            this.startRow=startRow; 
            this.startCol=startCol; 
            this.finishRow=finishRow; 
            this.finishCol=finishCol;
            this.list=new MazeLocationListRefBased();
            
            
           //change the 1-D array to 2-D array to represent each point as an object
            path=new int[textmaze.length][textmaze[0].length()];
            for(int i=0;i<textmaze.length;i++){
              String temp=textmaze[i];
              char []single=temp.toCharArray();
              
              //to determine the space object as 0,which can be the path
              //and determine the "*" object as 1, which is wall
              for(int j=0;j<single.length;j++){
                  if(single[j]=='*'){
                    path[i][j]=1;
                  }else{
                    path[i][j]=0;
                  }
              }
            }
            path[startRow][startCol]=2;
                      
}



//Find a solution to the maze.
//@return a list of locations in order
//if no solution, return null
 public MazeLocationList solve(){
            if (findPath(startRow,startCol,finishRow,finishCol)){
               return list;
            }
            return null;
      }
      
//recursion method 
//if the near object is space, insert the original object
//and move to it and mark it as 2, which means i have passed it
//if there is no way, then reverse to 2 which we marked before to find another way 
//and change the earlier path as 1,which means no path,and remove tail
private boolean findPath(int fromRow, int fromCol, int toRow, int toCol){
            
     locS=new MazeLocation(fromRow,fromCol);
     
            
     if(fromRow==toRow&&fromCol==toCol){
        list.insertTail(locS);
        return true;    
     } else if(fromRow==startRow&&fromCol==startCol&&
                    !check){
        list=null;
        return false;
           
           
     }else{
        check=false;
             
          if(path[fromRow+1][fromCol]==0){
              fromRow+=1;
              path[fromRow][fromCol]=2;
              list.insertTail(locS);
              
              
              
          } else if(path[fromRow][fromCol+1]==0){
              fromCol+=1;
              path[fromRow][fromCol]=2;
              list.insertTail(locS);
              
          }else if(path[fromRow-1][fromCol]==0){
             
              fromRow-=1;
              path[fromRow][fromCol]=2;
              list.insertTail(locS);
            
          }else if(path[fromRow][fromCol-1]==0){
             
              fromCol-=1;
              path[fromRow][fromCol]=2;
              list.insertTail(locS);
             
          }else{
              
             
              path[fromRow][fromCol]=1;
              list.removeTail();
                 
              
              if(path[fromRow-1][fromCol]==2){
          
                    fromRow-=1;
                    
               }else if(path[fromRow][fromCol-1]==2){
          
                    fromCol-=1;
                    
               }else if(path[fromRow+1][fromCol]==2){
               
                    fromRow+=1;
                   
               }else if(path[fromRow][fromCol+1]==2){
            
                    fromCol+=1;
               }        
       
         }
        
        
        return findPath(fromRow,fromCol,toRow,toCol);
     }
            
}

//we can add "toString()" in the front of solve method
//to show the result before each step
//it is helpful to debug 
public String toString(){
   for(int i=0;i<path.length;i++){
      for(int j=0;j<path[0].length;j++){
          System.out.print(path[i][j]);
          
      }
        System.out.println();
   }
   System.out.println();
   return null; 
}

}



