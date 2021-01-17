package TF2miscinstaller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HudInstaller {

    public HudInstaller() throws IOException {
        File tempFile = new File("storedPaths.txt");
        if (tempFile.exists()){
            System.out.println("\n\nTF2miscinstaller.Configurations ready; entering HUD installer");
            System.out.println("In this mode, you will enter the folder name of the HUD folder you are importing to TF2\n\n");
            this.main();
        }
        else{
            System.out.println("Your configurations are not ready. Please type in 0 after returning to the main menu and enter the folder-paths for your configurations\n\n");
        }
        Main.main(null);//Return to main menu
    }

    private static void directoryCopy(Path sourceDir, Path targetDir) throws IOException{
        Path sourcePath = sourceDir;
        Path targetPath = targetDir;//Modified code block from website above so that we can pass in the already defined paths (changed parameters to path instead of string)
        // Walk the tree structure using WalkFileTree method
        Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>(){
            @Override
            // Before visiting the directory, create directory
            public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
                Path newDir = targetPath.resolve(sourcePath.relativize(dir));
                System.out.println("Path- " + newDir.toString());
                if (!Files.exists(newDir)) {
                    Files.createDirectory(newDir);//Need to test if the directory already exists to avoid the error FileAlreadyExists due to the .createdirectory
                } //This if statement modifies the code block
                return FileVisitResult.CONTINUE;
            }
            @Override
            // For each visited file copy it
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
                Path newFile = targetPath.resolve(sourcePath.relativize(file));

                Files.copy(file, newFile);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void main () throws IOException {

        Scanner hudScanner = new Scanner(System.in); //Lets keep the hud AND sound files in the tfSounds folder

        System.out.println("What is the EXACT name of the folder containing your HUD? Make sure your HUD folder is inside the same folder you keep your sound files! Tutorial in README.txt");
        String hudPath = hudScanner.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader("storedPaths.txt")); //Need buffered reader to go line by line
        String trueStorageDir = reader.readLine(); //i.e tfSounds. Where all the HUD folders are located

        BufferedReader onlyCustomReader = new BufferedReader(new FileReader("onlyCustomPath.txt")); //Need buffered reader to go line by line
        String onlyCustomDir = onlyCustomReader.readLine(); //Fetch path of storage folder

        Path source = Paths.get(trueStorageDir + hudPath);
        // Math is like this: + "name of the hud folder"

        Path destination = Paths.get(onlyCustomDir);

        this.directoryCopy(source, destination);

        System.out.println("\n\nYour HUD is now installed!\nReturning to main menu\n\n");




    }
}
