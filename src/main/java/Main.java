import java.util.Scanner;
import com.google.gson.*;


public class Main {
    public static void main(String[] args) throws Exception {

        Scanner userInput = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("       WELCOME TO PITDASH!");
        System.out.println(" An application where you can view");
        System.out.println("  past F1 races, driver standings");
        System.out.println("key race events and telemetry datas!");
        System.out.println("====================================");
        System.out.println("(1) View Drivers & Teams");
        System.out.println("(2) View Past Races");
        System.out.println("(3) View Race Tracks");
        System.out.println("(4) View Race Telemetry");
        System.out.println("(5) Exit");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice: ");
        int homeChoice = userInput.nextInt();
        System.out.println("====================================");

        switch (homeChoice) {
            case 1:
                System.out.println("(1) View Drivers");
                Driver.showDrivers();
                break;
            case 2:

                break;

            case 3:

                break;

            case 4:


                break;

            case 5:

                break;

            default:
                System.out.println("Enter a valid value [1-5]!");
        }
    }
}