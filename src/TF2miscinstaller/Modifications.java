package TF2miscinstaller;

import TF2miscinstaller.Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Modifications {

    public Modifications() throws IOException {
        /**ADD a print statement stating what can be done in this option!!!111!!!1!!11!1!!1**/
        File tempFile = new File("storedPaths.txt");
        if (tempFile.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists
            System.out.println("\n\nTF2miscinstaller.Configurations ready; entering modifications");
            System.out.println("In this mode, you will enter the file name of the sound you are importing, and the name of the sound you are changing\n\n");
            this.main();

        }
        else {
            System.out.println("Your configurations are not ready. Please type in 0 after returning to the main menu and enter the folder-paths for your configurations\n\n");
        }
        Main.main(null);//Return to main menu
    }

    public void main () throws IOException {

        Scanner soundScanner = new Scanner(System.in);



        System.out.println("What is the EXACT name of the .wav (must be .wav) file you wish to move? Include file extension i.e ededdeddy.wav (.wav is the file extension)");

        String soundSource = soundScanner.nextLine();  // Read user input for the name of the .wav file
        //NOTE: The above line belongs in the second option, AKA option 1 BECAUSE it involves copying files into custom, not storing pathways

        System.out.println("\n\nWhat is name of the sound you are modifying? Refer to: https://www.maurits.tv/data/garrysmod/wiki/wiki.garrysmod.com/index82eb.html\nNOTE: you MUST exactly copy paste the sound on the site\n format should look like weapons/knife_swing_crit.wav \n please include the .wav");
        //This is where VEd's code picks apart the string to detect some stuff
        //Like if Aidan types weapons\knife_swing_crit.wav, then Ved's code checks for "weapons", creates the weapons folder,
        /**Use split function to get string up to the backslash i.e weapon from weapon\knife_swing_crit.wav
         *
         * Also add code that automatically opens that URL!!111!!1*
         * */
        String soundType = soundScanner.nextLine();

        int location = soundType.indexOf("/"); //<-- NEED a forward slash to deal with the copy-pasted sound
        String split[] = soundType.split("");

        String category = "";
        for (int i = 0; i < location; i++) {
            category += split[i]; //Gets everything before backslash
        }

        String categorySound = soundType.substring(location + 1);


        BufferedReader reader = new BufferedReader(new FileReader("storedPaths.txt")); //Need buffered reader to go line by line
        String trueStorageDir = reader.readLine(); /**Give you the music folder!111*/
        //Belongs in option1. The path through the TF2withSFX folder SHOULD be a string that can be concatenated to deal with locations other than Users\\RosenKids lmao
        //However, the storedPaths.txt part is hardcoded

        /***NOTE: Need to save UP to TF2withSFX as it's own string!!!!!!!1111!!!1 to be saved in a txt file and then read ***/


        BufferedReader customReader = new BufferedReader(new FileReader("customPaths.txt")); //Gets you the custom folder path up to the sounds folder
        String customDir = customReader.readLine() + "sound\\" + category + "\\";
        //MUST concatenate the sound\\ in order to move into the sound folder

        //For copying a file to a new place

        //Gets the music file
        Path source = Paths.get(trueStorageDir + soundSource); //using trueStorageDir so that I can check the .txt file properly stores the directory and can be used for fetching
        //"C:\\Users\\RosenKids\\Desktop\\spySumo.wav" <-- test with this: path: up to Desktop , storageFile: spySumo.wav

        //The math: trueStorageDir = musicFolder + \ + .wav


        //Gets the path to the custom sound spot i.e ...weapons\knife_swing_crit.wav
        Path destination = Paths.get(customDir + categorySound);
        //The custom path is saved in a txt file
        //Need to ask for the title of the sound (i.e knife_swing_crit) as a string input, just like soundStorage !
        /***In other words, there should only be 2 string inputs for option 1: soundStorage and soundType***/

        //Math: ...sound\weapons\ + .wav

        //Now we only have up to sounds, need to get category from Ved's array code


        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);


        System.out.println("Modification complete! Try it out in game! Close terminal to end program\n\n");

        System.out.println("Returning to the main menu...\n\n\n\n\n\n\n\n\n");





    }
}
