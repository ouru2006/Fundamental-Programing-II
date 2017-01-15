/**
 * Ru Ou
 * V00835123
 *CipherTester.java
 *Assignment 1
 */
import java.io.*;
import java.util.*;
public class CipherTester{
     public static void main(String[]args){
       Cipher key = new VigenereCipher("");
       boolean passed;
       
       
       Scanner input=null;
       Scanner read=null;
       PrintStream output=null;
       try{
       output=new PrintStream(new File("test_output.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
        
       
       //test1
       try{
       input=new Scanner(new File("in01.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
    
       try{
       read=new Scanner(new File("out01.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
       key.setKey("bob");
       String plainText=input.next();
       String result=key.encrypt(plainText);
       String cipherText=read.next();
       
       
       if(result.equals(cipherText)){
       output.println("test1 encrypt passed");
       }else{
       output.println("test1 encrypt failed");
       }
       
       result=key.decrypt(result);
       
       if(result.equals(plainText)){
       output.println("test1 decrypt passed");
       }else{
       output.println("test1 decrypt failed");
       }
       
      
       
       
       //test2
       try{
       input=new Scanner(new File("in02.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
       }
       try{
       read=new Scanner(new File("out02.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
       key.setKey("uvicrulz");
       plainText=input.next();
       result=key.encrypt(plainText);
       cipherText=read.next();
       
       if(result.equals(cipherText)){
       output.println("test2 encrypt passed");
       }else{
       output.println("test2 encrypt failed");
       }
       
       result=key.decrypt(result);
       
       if(result.equals(plainText)){
       output.println("test2 decrypt passed");
       }else{
       output.println("test2 decrypt failed");
       }
       
       
       
       
       
        //test3
        try{
       input=new Scanner(new File("in03.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
       }
       try{
       read=new Scanner(new File("out03.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
       key.setKey("heart");
       plainText=input.next();
       result=key.encrypt(plainText);
       cipherText=read.next();
       if(result.equals(cipherText)){
       output.println("test3 encrypt passed");
       }else{
       output.println("test3 encrypt failed");
       }
       
       result=key.decrypt(result);
       
       if(result.equals(plainText)){
       output.println("test3 decrypt passed");
       }else{
       output.println("test3 decrypt failed");
       }
       
       
       
       
        //test4
        try{
       input=new Scanner(new File("in04.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
       }
       try{
       read=new Scanner(new File("out04.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
       key.setKey("thequickbrownfoxjumpsoverthelazydog");
       plainText=input.next();
       result=key.encrypt(plainText);
       cipherText=read.next();
       if(result.equals(cipherText)){
       output.println("test4 encrypt passed");
       }else{
       output.println("test4 encrypt failed");
       }
       
       result=key.decrypt(result);
       
       if(result.equals(plainText)){
       output.println("test4 decrypt passed");
       }else{
       output.println("test4 decrypt failed");
       }
       
        
        
        
        //test5
        try{
       input=new Scanner(new File("in05.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
        try{
       read=new Scanner(new File("out05.txt"));
       }
       catch(java.io.FileNotFoundException ex){
            System.out.println("Error: File not found");
            System.exit(-1);
        }
       key.setKey("shakespeare");
       plainText=input.next();
       result=key.encrypt(plainText);
       cipherText=read.next();
       if(result.equals(cipherText)){
       output.println("test5 encrypt passed");
       }else{
       output.println("test5 encrypt failed");
       }
       
       result=key.decrypt(result);
       
       if(result.equals(plainText)){
       output.println("test5 decrypt passed");
       }else{
       output.println("test5 decrypt failed");
       }
       
      
        
     
        
 
 }
}