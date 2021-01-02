import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Modifications {

    public Modifications() throws IOException {
        /**ADD a print statement stating what can be done in this option!!!111!!!1!!11!1!!1**/
        this.main();
    }

    public void main () throws IOException {

        Scanner soundScanner = new Scanner(System.in);

        BufferedReader projectFolderReader = new BufferedReader(new FileReader("projectPath.txt")); //Need buffered reader to go line by line
        String sfxFilePath = projectFolderReader.readLine(); //Get file path to folder with all other stored txt files


        System.out.println("What is the EXACT name of the file you wish to move? Include file extension i.e ededdeddy.wav");

        String soundSource = soundScanner.nextLine();  // Read user input for the name of the .wav file
        //NOTE: The above line belongs in the second option, AKA option 1 BECAUSE it involves copying files into custom, not storing pathways

        System.out.println("\n\nWhat is the EXACT name of the sound you are trying to modify? Refer to this site: https://www.maurits.tv/data/garrysmod/wiki/wiki.garrysmod.com/index82eb.html\n format should look like spy_knife_crit.wav \n please include the .wav");

        String soundType = soundScanner.nextLine();



        BufferedReader reader = new BufferedReader(new FileReader(sfxFilePath + "storedPaths.txt")); //Need buffered reader to go line by line
        String trueStorageDir = reader.readLine();
        //Belongs in option1. The path through the TF2withSFX folder SHOULD be a string that can be concatenated to deal with locations other than Users\\RosenKids lmao
        //However, the storedPaths.txt part is hardcoded

        /***NOTE: Need to save UP to TF2withSFX as it's own string!!!!!!!1111!!!1 to be saved in a txt file and then read ***/


        BufferedReader customReader = new BufferedReader(new FileReader(sfxFilePath + "customPaths.txt")); //Need buffered reader to go line by line
        String customDir = customReader.readLine();
        //Belongs in option1. The path through the TF2withSFX folder SHOULD be a string that can be concatenated....
        //However, the storedPaths.txt part is hardcoded

        //For copying a file to a new place

        Path source = Paths.get(trueStorageDir + soundSource); //using trueStorageDir so that I can check the .txt file properly stores the directory and can be used for fetching
        //"C:\\Users\\RosenKids\\Desktop\\spySumo.wav" <-- test with this: path: up to Desktop , storageFile: spySumo.wav


        Path destination = Paths.get(customDir + soundType);
        //The custom path is saved in a txt file
        //Need to ask for the title of the sound (i.e knife_swing_crit) as a string input, just like soundStorage !
        /***In other words, there should only be 2 string inputs for option 1: soundStorage and soundType***/


        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("After file movement");

        System.out.println("Modification complete! Try it out in game! Close terminal to end program");

        System.out.println("\nReturning to the main menu...");
        Main.main(null);




    }
}
