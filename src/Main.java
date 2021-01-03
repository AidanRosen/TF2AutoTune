import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.Scanner;  // Import the Scanner class


//Authors: Aidan "Ampersands" Rosen and Ved "Mr. Anime PFP" Iyer
//Created On : 7/8/2015 9:56:39 AM
//Last Modified On : 8/9/2015 11:53:23 AM
//Copy Rights : your company
//Description : Class for defining database related function


public class Main {

    private static String programDirectoryG; // "G" stands for global

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to TF2withSFX!\n\nBefore file movement");


        //System.out.println(file.getAbsoluteFile().getParent() + "\\" + "          end of print statement\n\n"); //NOTE: the file itself is just projectPath.txt --> this means we need
        //to get the absolute file in order to get the parent path!



        Scanner myObj = new Scanner(System.in);  // Create a Scanner object ;;; Add a check to see if this is the first time. If so, add the storedPaths file

        int readiness = 3;
        System.out.println("\n\nIs this your first time running this software? Type '0', exactly 0, if so and configurations will be run. Type '1' if you are ready to modify sounds.");

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

        System.out.println("\nyou chose option " + readiness + "\n\n");
        // AFTER this print, go into separate directions of configuration or direct file addition

        if (readiness == 0){
            Configurations configuring = new Configurations();

            /***
             * NEED to pass in programDirectoryG so that the folder path of the program is completely dynamic AND only has to be written once in configuration
             * Tricky part: what if they jump straight into option 1?
             * How can I check that .txt file and not worry about hard coding the path?
             * Do I need to code it from a .jar perspective?
             *
             * Answer: Ask in the Main file!!!!!111!!!1
             *
             *
             * For future: rewrite directories as just being new .txt files ONLY for those in the TF2withSFX folder. Reason is because the .jar file can
             * detect files in the same directory as itself without error or the need to add a path!
             * Repalce paths with "directory of this .jar file"
             *
             * ***/

            System.out.println("\n\nConfiguration complete! Close terminal to end program");

            System.out.println("Returning to the main menu...\n\n\n\n\n\n");
            Main.main(null);
            /**IMPORTANT! Be sure to return to the main menu after configuration!**/
        }

        if (readiness == 1){
            Modifications additions = new Modifications();
        }




    }
}


       /*
        File f = new File("C:\\Users\\RosenKids\\Desktop\\testSource.txt"); //Remember to concatenate the tf2 sound name to the end!!!!1111!!@!!!1#p1fknsdvbwf;luweblifwbelfub

        f.renameTo(new File("C:\\Users\\RosenKids\\Pictures\\testProduct.txt"));*/