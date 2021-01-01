import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//Configuration focuses on storing paths
public class Configurations {




    /**HOWEVER these strings are stored in publicly available .txt files....**/

    public Configurations() throws IOException {
        /**ADD a print statement stating what can be done in this option!!!111!!!1!!11!1!!1**/
      // this.main();
    }


    public String main (String sfxDirectory) throws IOException {



        Scanner myObj = new Scanner(System.in);  // Create a Scanner object ;;; Add a check to see if this is the first time. If so, add the storedPaths file

        File customPath = new File(sfxDirectory + "customPaths.txt");

        if (!customPath.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists
            customPath.createNewFile(); //<-- will probably need a try and except <-- Ved

        }

        File storedPaths = new File(sfxDirectory + "storedPaths.txt");

        if (!storedPaths.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists
            storedPaths.createNewFile(); //<-- will probably need a try and except <-- Ved

        }



        System.out.println("What is the EXACT path of the directory you contain your sound files in? I.e C:\\Users\\username\\Desktop");

        String storageDir = myObj.nextLine(); // Read user input

        storageDir += "\\"; //need to add a backslash so that file name can be slapped right on the end. Prevents the need to add the \ later


        System.out.println("What is the exact path to your TF2 custom folder?");
        String tfCustom = myObj.nextLine() + "\\";



        //File writing area

        FileWriter storageWriter = new FileWriter(storedPaths); //NOTE: don't put the \n here, because that directory doesn't exist
        storageWriter.write(storageDir);//first time configuration <-- maybe have two classes for first-time configuration and second time configuration?
        //we store storageDir and NOT the file because we want to make it such that you just type the file name + the folder it is in, then it concatenates the stored path there
        //Also
        storageWriter.close();

        FileWriter customWriter = new FileWriter(customPath);
        customWriter.write(tfCustom);
        customWriter.close();

        return sfxDirectory;
    }
}