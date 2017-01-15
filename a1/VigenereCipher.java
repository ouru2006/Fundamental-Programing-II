/**
 * Ru Ou
 * V00835123
 *VigenereCipher.java
 *Assignment 1
 */

public class VigenereCipher implements Cipher {
    private String key;
    
    
    
    private int[] stringToIntArray(String text){
        int[] temp=new int[text.length()];
        for(int i=0;i<text.length();i++){
           temp[i]=text.charAt(i)-97;;
        } 
        return temp;
    }
    private String intArrayToString(int[] encodedText){
         String text="";
         for(int i=0;i<encodedText.length;i++){
             encodedText[i]=encodedText[i]+97;
             text=text+String.valueOf((char)encodedText[i]);
         }
         return text;
    }
    
    public VigenereCipher(String key) {
         this.key=key;
         
    }
    
    
    /**
     * This implementation of the interface is meant to simply
     * echo parameters passed in for input and to ensure the
     * EncryptDecryptText program compiles for students.
     * @param plainText The text to be encrypted.
     * @return The same string passed in.
     */     
    public String encrypt(String plainText) {
        int temp[]=stringToIntArray(plainText);
        int k[]=stringToIntArray(key);
        for(int i=0;i<temp.length;i++){
           temp[i]=(temp[i]+k[i%k.length])%26;
        }
        plainText=intArrayToString(temp);
        
        return plainText;
    }

    /**
     * This implementation of the interface is meant to simply
     * echo parameters pass in for input and to ensure the
     * EncryptDecryptText program compiles for students.
     * @param cipherText The text to be decrypted.
     * @return The same string passed in.
     */
    public String decrypt(String cipherText) {
        int temp[]=stringToIntArray(cipherText);
        int k[]=stringToIntArray(key);
        for(int i=0;i<temp.length;i++){
          if(temp[i]>=k[i%k.length]){
           temp[i]=(temp[i]-k[i%k.length])%26;
          }else{
          temp[i]=(temp[i]-k[i%k.length]+26)%26;
        }
        }
        cipherText=intArrayToString(temp);
        return cipherText;
    }
    /**
     * Establishes the key to be used by the Cipher. This
     * version, however, does nothing with the string passed in.
     * @param key A plain text key.
     */
    public void setKey(String key) {
        this.key=key;
        
    }
    
    
}
