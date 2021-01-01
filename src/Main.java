import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.Scanner;  // Import the Scanner class


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Before file movement");

        File storageUnit = new File("C:\\Users\\RosenKids\\Desktop\\TF2withSFX\\storedPaths.txt");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object ;;; Add a check to see if this is the first time. If so, add the storedPaths file

        storageUnit.createNewFile();

        int readiness = 3;
        System.out.println("Is this your first time running this software? Type '0', exactly 0, if so and configurations will be run. Type '1' if you are ready to modify sounds.");

        do {
            try{
                readiness = myObj.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You must type in a number");
                main(null);
            }
                                                            //This option choosing will stay in the main file. Move configuration and file movement to separate classes
            if (readiness != 1 && readiness != 0){
                System.out.println("You MUST type in 1 or 0 silly!");
            }
        }
        while (readiness != 0 && readiness != 1);

        myObj.nextLine(); //<-- REALLY important. At the end of nextInt there's apparently a \n character, which the next .nextLine accepts as an input. We need this 'useless' .nextLine to
        //Prevent the important nextLines from reading that \n character, and instead read user input as intended from the beginning

        System.out.println("\nyou chose option " + readiness);

        System.out.println("What is the EXACT path of the directory you contain your sound files in? I.e C:\\Users\\username\\Desktop");

        String storageDir = myObj.nextLine(); // Read user input

        storageDir += "\\"; //need to add a backslash so that file name can be slapped right on the end. Prevents the need to add the \ later

        System.out.println("What is the EXACT name of the file you wish to move? Include file extension i.e ededdeddy.wav");

        String storageFile = myObj.nextLine();  // Read user input for the name of the .wav file

        System.out.println("What is the exact path to your TF2 custom folder?");
        String tfCustom = myObj.nextLine() + "\\";

        File customPath = new File("C:\\Users\\RosenKids\\Desktop\\TF2withSFX\\customPaths.txt");

        if (!customPath.exists()){ //This needs to trigger if the file does NOT exist. In other words, if it is false that it exists
            customPath.createNewFile(); //<-- will probably need a try and except <-- Ved

        }


        FileWriter storageWriter = new FileWriter("C:\\Users\\RosenKids\\Desktop\\TF2withSFX\\storedPaths.txt"); //NOTE: don't put the \n here, because that directory doesn't exist
        storageWriter.write(storageDir);//first time configuration <-- maybe have two classes for first-time configuration and second time configuration?
        //we store storageDir and NOT the file because we want to make it such that you just type the file name + the folder it is in, then it concatenates the stored path there
        //Also
        storageWriter.close();

        FileWriter customWriter = new FileWriter("C:\\Users\\RosenKids\\Desktop\\TF2withSFX\\customPaths.txt");
        customWriter.write(tfCustom);
        customWriter.close();


        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\RosenKids\\Desktop\\TF2withSFX\\storedPaths.txt")); //Need buffered reader to go line by line
        String trueStorageDir = reader.readLine();



        //For copying a file to a new place

        Path source = Paths.get(trueStorageDir + storageFile); //using trueStorageDir so that I can check the .txt file properly stores the directory and can be used for fetching
        //"C:\\Users\\RosenKids\\Desktop\\spySumo.wav" <-- test with this: path: up to Desktop , storageFile: spySumo.wav


        Path destination = Paths.get("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Team Fortress 2\\tf\\custom\\Ed_Edd_N'Eddy_KILLSOUND\\sound\\weapons\\knife_swing_crit.wav");

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("After file movement");




    }
}


       /*
        File f = new File("C:\\Users\\RosenKids\\Desktop\\testSource.txt"); //Remember to concatenate the tf2 sound name to the end!!!!1111!!@!!!1#p1fknsdvbwf;luweblifwbelfub

        f.renameTo(new File("C:\\Users\\RosenKids\\Pictures\\testProduct.txt"));*/