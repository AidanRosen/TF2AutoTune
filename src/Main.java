import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import java.io.File;
import java.util.*;
public class TF2MOD {

    public static void main(String[] args) {
        System.out.println("Enter the location of your steam directory. Input is case sensitive (Look at example for help)\n Example: C:\\Program Files (x86)\\Steam");
        Scanner input = new Scanner(System.in);
        String Steam_Location = input.nextLine();

        System.out.println("Adding a 'Custom' file, if you already have one it will not be added.");
        File Custom_file = new File(Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom");
        //Creating the directory
        boolean bool = Custom_file.mkdir();
        if(bool){
            System.out.println("'Custom' file created successfully");
        }else{
            System.out.println("Sorry couldn't create specified directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the customs folder");
        }

    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Before file movement");

        File f = new File("C:\\Users\\RosenKids\\Desktop\\testSource.txt"); //Remember to concatenate the tf2 sound name to the end!!!!1111!!@!!!1#p1fknsdvbwf;luweblifwbelfub

        f.renameTo(new File("C:\\Users\\RosenKids\\Pictures\\testProduct.txt"));

            //For copying a file to a new place
        Path source = Paths.get("C:\\Users\\RosenKids\\Desktop\\spySumo.wav");
        Path destination = Paths.get("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Team Fortress 2\\tf\\custom\\customSounds\\Spy\\knife_swing_crit.wav");

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("After file movement");




    }
}
