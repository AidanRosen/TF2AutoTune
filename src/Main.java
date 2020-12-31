import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
