package Drivers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DriversChampionshipPage {
    Scanner userInput = new Scanner(System.in);
    public List<String> sessionKeys = new ArrayList<>();
    String year;

    int season;

    public void showDriversChampionshipYearPage() throws Exception {
        System.out.println("            SELECT YEAR");
        System.out.println("[1] 2023");
        System.out.println("[2] 2024");
        System.out.println("[3] 2025");
        System.out.println("[4] 2026");
        System.out.println("[5] 2023-2026 [WIP - NOT AVAILABLE]");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        System.out.print("Enter Year: ");
        season = userInput.nextInt();
        userInput.nextLine();
        getSeason(season);

        switch (season) {
            case 1, 2, 3, 4, 5 -> driversChampionshipMainPage(sessionKeys);
            case 0 -> new Main().viewMainPage();
        }

    }

    public void driversChampionshipMainPage(List<String> sessionKeys) throws Exception {
        System.out.println("====================================");
        System.out.println("      DRIVERS CHAMPIONSHIP PAGE");
        System.out.println("[1] Show points progression");
        System.out.println("[2] Show Final Standings");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice: ");
        int choice = userInput.nextInt();

        if (choice == 0 ) {
            showDriversChampionshipYearPage();

            } else if (choice == 1) {
                showPointsProgression();

                } else if (choice == 2) {
                showFinalStandings(sessionKeys);

        } else {
            System.out.println("Invalid, try again!");
            driversChampionshipMainPage(sessionKeys);
        }
    }

    public void showPointsProgression() {
        System.out.println("====================================");
        System.out.println("------------------------------------");

    }

    public void showFinalStandings(List<String> sessionKeys) throws Exception {

        System.out.println("====================================");
        System.out.println("           FINAL STANDING");
        DriverStanding.showFinalDriverStanding(sessionKeys);
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice: ");
        int choice = userInput.nextInt();

        if (choice == 0) {
            driversChampionshipMainPage(sessionKeys);
        }

    }



    public List<String> getSeason(int season) {
        switch (season) {
            case 1:
                year = "2023";
                sessionKeys.addAll(Arrays.asList("9197"));
                break;
            case 2:
                year = "2024";
                sessionKeys.addAll(Arrays.asList("9662"));
                break;
            case 3:
                year = "2025";
                sessionKeys.addAll(Arrays.asList("9839"));
                break;
            case 4:
                year = "2026";
                sessionKeys.addAll(List.of("11436"));
                break;
            case 5:
                year = "2023-2026";
                sessionKeys.addAll(Arrays.asList("7953", "9133", "9173", "9472", "9662", "9693", "9850", "11465"));
                break;
            default:
                System.out.println("Enter a valid number (1-3 | 0)");
                break;
        }
        return sessionKeys;
    }
}
