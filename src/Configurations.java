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

        BufferedReader reader = new BufferedReader(new FileReader("projectPath.txt")); //Need buffered reader to go line by line
        String sfxFilePath = reader.readLine();



        Scanner myObj = new Scanner(System.in);  // Create a Scanner object ;;; Add a check to see if this is the first time. If so, add the storedPaths file

        File customPath = new File(sfxFilePath + "customPaths.txt");

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

        File storedPaths = new File(sfxFilePath + "storedPaths.txt"); //storedPaths stores the music folder (where all wavs are kept_)

        if (!storedPaths.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists
            storedPaths.createNewFile(); //<-- will probably need a try and except <-- Ved

        }



        System.out.println("\n\nWhat is the EXACT path of the directory you contain your sound files in? BE sure to keep any soundfiles you upload in this folder! I.e C:\\Users\\username\\Desktop");

        String storageDir = myObj.nextLine(); // Read user input

        storageDir += "\\"; //need to add a backslash so that file name can be slapped right on the end. Prevents the need to add the \ later


        System.out.println("\n\nWhat is the exact path to your TF2 custom folder? By default this is C:\\Program Files (x86)\\Steam\\steamapps\\common\\Team Fortress 2\\tf\\custom");



        System.out.println("What is the exact path of your steam directory. Input is case sensitive (Look at example for help)\n Example: C:\\Program Files (x86)\\Steam");
        //Go up to ONLY custom folder i.e tf\custom <-- thats it
        //Then Ved's code adds the whatever folder, sound folder, and category folder + my code to add the .wav file
        //The category folder is after Aidan's string input
        String Steam_Location = myObj.nextLine();

        TF2MOD folderBuilder = new TF2MOD();

        folderBuilder.Custom(Steam_Location);
        folderBuilder.TF2WithSFX(Steam_Location);
        folderBuilder.Sound(Steam_Location);

        String Total_Location = Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom\\TF2 With SFX\\sound\\";



        folderBuilder.Ambient(Total_Location);
        folderBuilder.Commentary(Total_Location);
        folderBuilder.Doors(Total_Location);
        folderBuilder.Items(Total_Location);
        folderBuilder.Misc(Total_Location);
        folderBuilder.MVM(Total_Location);
        folderBuilder.Player(Total_Location);
        folderBuilder.UI(Total_Location);
        folderBuilder.VO(Total_Location);
        folderBuilder.Weapons(Total_Location);




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


    }
}
