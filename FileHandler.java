import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {
    public static void addToFile(String file, String data) throws Exception {
        try {
            File f1 = new File(file);
            if (f1.exists()) {    
                FileWriter myWriter = new FileWriter(file,true);
                myWriter.write(data);
                myWriter.close();
            }
            else{
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException f) {
            System.out.println("file does not exist.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (Exception e) {
            System.out.println("an error occurred.");
        }
    }
    public static String readFile(String file) throws Exception {
        try{
            File f2 = new File(file);
            Scanner reader = new Scanner(f2);
            String data = "";
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                data+=line + "\n";
            }
            reader.close();
            return data;
        } catch (FileNotFoundException f){
            return "file not found.";
        }
    }
    public static void editFile(String file, String data) throws Exception{
        try {
            File f1 = new File(file);
            if (f1.exists()) {    
                FileWriter myEditor = new FileWriter(file);
                myEditor.write(data);
                myEditor.close();
            }
            else{
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException f) {
            System.out.println("file does not exist.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (Exception e) {
            System.out.println("an error occurred.");
        }
    }
}

