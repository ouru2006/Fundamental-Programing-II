public class Tester{
    public static void main (String[]args){
    String text="";
    int []encodedText={5,6,7,8,9};
         for(int i=0;i<encodedText.length;i++){
             encodedText[i]=encodedText[i]+97;
             text=text+String.valueOf((char)encodedText[i]);
         }
         
    System.out.println(text);
    
    }
}