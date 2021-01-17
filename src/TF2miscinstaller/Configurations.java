package TF2miscinstaller;

import java.io.*;
import java.util.Scanner;


//Configuration focuses on storing paths
public class Configurations {




    /**HOWEVER these strings are stored in publicly available .txt files....**/

    public Configurations() throws IOException {
        /**ADD a print statement stating what can be done in this option!!!111!!!1!!11!1!!1**/
        this.main();
    }


    public void main () throws IOException {




        Scanner myObj = new Scanner(System.in);  // Create a Scanner object ;;; Add a check to see if this is the first time. If so, add the storedPaths file

        File customPath = new File("customPaths.txt");
        customPath.setReadable(true); //read
        customPath.setWritable(true); //write
        customPath.setExecutable(true);

        if (!customPath.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists

            customPath.createNewFile(); //<-- will probably need a try and except <-- Ved

        }
        /**Need to add \whatever\sounds\category\ eventually <-- do this in Ved's code
         * Ved makes \whatever\sounds\category
         *
         * Then, Ved writes to the file as the string of customDir + \\ + TF2miscInstaller-VA + \\ + souncs + \\ + category
         *
         * TF2misc and sounds are hard coded
         *
         * Category is a string detected by veds code.
         * save whole path as string after creating the folders.
         *
         *
         *
         *         string final custom path = customDir + \\ + TF2miscInstaller-VA + \\ + souncs + \\ + category);
         *
         *         Use this string for line 69, replace customDir with final custom path
         *      WILL need to reset the string as the file is read
         * */

        File storedPaths = new File("storedPaths.txt"); //storedPaths stores the music folder (where all wavs are kept_)
        storedPaths.setReadable(true); //read
        storedPaths.setWritable(true); //write
        storedPaths.setExecutable(true);

        if (!storedPaths.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists
            storedPaths.createNewFile(); //<-- will probably need a try and except <-- Ved

        }

        File onlyCustomPath = new File("onlyCustomPath.txt"); //storedPaths stores the music folder (where all wavs are kept_)
        storedPaths.setReadable(true); //read
        storedPaths.setWritable(true); //write
        storedPaths.setExecutable(true);

        if (!onlyCustomPath.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists
            onlyCustomPath.createNewFile(); //<-- will probably need a try and except <-- Ved

        }



        System.out.println("\n\nWhat is the EXACT path of the directory you contain your sound files and HUD folders in? Be sure to keep any soundfiles you upload in this folder! Be sure to extract your HUDS into this folder! I.e C:\\Users\\username\\Desktop. Tutorial in the README.txt of this program");

        String storageDir = myObj.nextLine(); // Read user input

        storageDir += "\\"; //need to add a backslash so that file name can be slapped right on the end. Prevents the need to add the \ later




        System.out.println("\n\nWhat is the exact path of your steam directory. Input is case sensitive (Look at example for help)\n Example: C:\\Program Files (x86)\\Steam");
        //Go up to ONLY custom folder i.e tf\custom <-- thats it
        //Then Ved's code adds the whatever folder, sound folder, and category folder + my code to add the .wav file
        //The category folder is after Aidan's string input
        String Steam_Location = myObj.nextLine();

        TF2MOD folderBuilder = new TF2MOD();

        folderBuilder.Custom(Steam_Location);
        folderBuilder.TF2WithSFX(Steam_Location);
        folderBuilder.Sound(Steam_Location);

        String Total_Location = Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom\\TF2 With SFX\\"; //removed sound\\ so that we can move into any other folder within TF@ with SFX



        folderBuilder.Ambient(Total_Location + "sound\\");
        folderBuilder.Commentary(Total_Location + "sound\\");
        folderBuilder.Doors(Total_Location+ "sound\\");
        folderBuilder.Items(Total_Location + "sound\\");
        folderBuilder.Misc(Total_Location + "sound\\");
        folderBuilder.MVM(Total_Location + "sound\\");
        folderBuilder.Player(Total_Location+ "sound\\");
        folderBuilder.UI(Total_Location + "sound\\");
        folderBuilder.VO(Total_Location + "sound\\");
        folderBuilder.Weapons(Total_Location + "sound\\"); //MUST concatenate the "sound\\" because Total_location no longer automatically adds sound\\
        //No longer automatically adds sound\\ because we want to store ONLY the TF@ with SFX folder in the customPaths.txt file




        //Need to do Ved's category detection here.
                                /**Change to accomodate Ved's stuff! Cahgne to just ask for steam directory
                                 *
                                 * Refer to Ved's line 6. May need to integrate/change stuff. How will we call to Ved's code? Make an object whenever we use it.
                                 *
                                 * Simply make Ved's object, then call main in configurations.
                                 *
                                 * Still need to get address of custom folder...
                                 *
                                 * From line 14: use total_direction for custom path that goes into the customPaths.txt !!!
                                 *
                                 * This way, we only need to concatenate \ + category folder + \ + soundFileName.wav
                                 *
                                 * */



        //File writing area


        FileWriter storageWriter = new FileWriter(storedPaths); //storedPaths stores the music folder
        //NOTE: don't put the \n here, because that directory doesn't exist
        storageWriter.write(storageDir);//first time configuration <-- maybe have two classes for first-time configuration and second time configuration?
        //we store storageDir and NOT the file because we want to make it such that you just type the file name + the folder it is in, then it concatenates the stored path there
        //Also
        storageWriter.close();


        FileWriter customWriter = new FileWriter(customPath); //customPath is the FILE with tfCustom/Steam_Location inside
        customWriter.write(Total_Location);
        customWriter.close();

        FileWriter onlyCustomWriter = new FileWriter(onlyCustomPath); //This file contains the path ONLY UP TO custom\ . This is so that we can access both the custom folder only AND the TF2 with SFX folder within custom without unnecessary concatenation
        onlyCustomWriter.write(Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom");//first time configuration <-- maybe have two classes for first-time configuration and second time configuration?

        onlyCustomWriter.close();


    }
}
