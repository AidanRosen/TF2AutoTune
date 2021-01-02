import java.io.File;
import java.util.*;
public class TF2MOD {

    public static void main(String[] args) {
        System.out.println("Enter the location of your steam directory. Input is case sensitive (Look at example for help)\n Example: C:\\Program Files (x86)\\Steam");
        Scanner input = new Scanner(System.in);
        String Steam_Location = input.nextLine();

        Custom(Steam_Location);
        TF2WithSFX(Steam_Location);
        Sound(Steam_Location);

        String Total_Location = Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom\\TF2 With SFX\\sound";

        Ambient(Total_Location);
        Commentary(Total_Location);
        Doors(Total_Location);
        Items(Total_Location);
        Misc(Total_Location);
        MVM(Total_Location);
        Player(Total_Location);
        UI(Total_Location);
        VO(Total_Location);

    }

    public static void Custom(String Steam_Location) {

        System.out.println("Adding a 'Custom' file, if you already have one it will not be added.");
        File Custom_file = new File(Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom");
        //Creating the directory
        boolean bool_1 = Custom_file.mkdir();
        if(bool_1){
            System.out.println("'Custom' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'custom' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'customs' folder");
        }
    }

    public static void TF2WithSFX(String Steam_Location) {

        File TF2WithSFX_file = new File(Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom\\TF2 With SFX");
        //Creating the directory
        boolean bool_2 = TF2WithSFX_file.mkdir();
        if(bool_2){
            System.out.println("'TF2 With SFX' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'TF2 With SFX' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'TF2 With SFX' folder");
        }

    }

    public static void Sound(String Steam_Location) {

        File Sound_file = new File(Steam_Location + "\\steamapps\\common\\Team Fortress 2\\tf\\custom\\TF2 With SFX\\sound");
        //Creating the directory
        boolean bool_3 = Sound_file.mkdir();
        if(bool_3){
            System.out.println("'sound' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'sound' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'sound' folder");
        }

    }

    public static void Ambient(String Total_Location) {

        File Ambient_file = new File(Total_Location + "\\ambient");
        boolean bool_amb = Ambient_file.mkdir();
        if(bool_amb){
            System.out.println("'Ambient' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'ambient' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'ambient' folder");
        }

    }

    public static void Commentary(String Total_Location) {

        File Commentary_file = new File(Total_Location + "\\commentary");
        boolean bool_comm = Commentary_file.mkdir();
        if(bool_comm){
            System.out.println("'Commentary' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'commentary' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'commentary' folder");
        }

    }

    public static void Doors(String Total_Location) {

        File Doors_file = new File(Total_Location + "\\doors");
        boolean bool_doors = Doors_file.mkdir();
        if(bool_doors){
            System.out.println("'doors' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'doors' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'doors' folder");
        }

    }

    public static void Items(String Total_Location) {
        File Items_file = new File(Total_Location + "\\items");
        boolean bool_items = Items_file.mkdir();
        if(bool_items){
            System.out.println("'Items' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'items' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'items' folder");
        }
    }

    public static void Misc(String Total_Location) {

        File Misc_file = new File(Total_Location + "\\misc");
        boolean bool_misc = Misc_file.mkdir();
        if(bool_misc){
            System.out.println("'Misc' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'misc' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'misc' folder");
        }
    }

    public static void MVM(String Total_Location) {

        File MVM_file = new File(Total_Location + "\\mvm");
        boolean bool_MVM = MVM_file.mkdir();
        if(bool_MVM){
            System.out.println("'MVM' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'mvm' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'mvm' folder");
        }
    }

    public static void Player(String Total_Location) {

        File Player_file = new File(Total_Location + "\\player");
        boolean bool_play = Player_file.mkdir();
        if(bool_play){
            System.out.println("'Player' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'player' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'player' folder");
        }
    }

    public static void UI(String Total_Location) {

        File UI_file = new File(Total_Location + "\\ui");
        boolean bool_UI = UI_file.mkdir();
        if(bool_UI){
            System.out.println("'Ui' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'ui' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'ui' folder");
        }
    }

    public static void VO(String Total_Location) {

        File VO_file = new File(Total_Location + "\\vo");
        boolean VO_comm = VO_file.mkdir();
        if(VO_comm){
            System.out.println("'Vo' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'vo' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'vo' folder");
        }
    }

    public static void Weapons(String Total_Location) {
        File Weapons_file = new File(Total_Location + "\\weapons");
        boolean bool_weap = Weapons_file.mkdir();
        if(bool_weap){
            System.out.println("'Weapons' file created successfully");
        }else{
            System.out.println("Sorry couldn't create 'weapons' directory. Make sure you are inputting the correct location, you have space on the computer, nothing is mispelled, or you already have the 'weapons' folder");
        }
    }

}