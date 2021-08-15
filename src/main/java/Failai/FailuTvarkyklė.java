package Failai;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FailuTvarkyklė {
   public File kurtiNaujaFaila(String failoPav){
           File file = new File(failoPav);
           try {
           if(!file.exists()){
               file.createNewFile();
           }
       }catch (IOException e){
               System.out.println("Failo sukurti nepavayko " + e);
       }
           return file;
   }
   public void writeToFIle(String fileName){
       try (FileWriter fileWriter = new FileWriter(fileName)){
        fileWriter.write(fileName);
        fileWriter.flush();
       }catch (IOException e){
           System.out.println("Nepavyko irašyti i failą");
       }
   }
   public void readFromFile(String fileName){

   }
}
