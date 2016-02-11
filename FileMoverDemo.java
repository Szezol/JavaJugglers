package sandbox;

import java.io.File;

public class FileMover {
   public static void main(String[] args) {
      
      File f = null;
      File f1 = null;
      
      try{      
         // create new File objects
         f = new File("C:\\ID3_sandbox\\adjust.mp3");
         f1 = new File("C:\\ID3_sandbox\\new_folder\\adjust.mp3");
         
         // rename file
         f.renameTo(f1);

      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }
   }
}