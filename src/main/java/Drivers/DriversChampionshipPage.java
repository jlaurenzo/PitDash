package Drivers;


import java.util.Scanner;

public class DriversChampionshipPage {
    Scanner userInput = new Scanner(System.in);

    int season;

    public void showDriversChampionshipYearPage() throws Exception {
        System.out.println("            SELECT YEAR");
        System.out.println("[1] 2023");
        System.out.println("[2] 2024");
        System.out.println("[3] 2025");
        System.out.println("[4] 2026");
        System.out.println("[5] 2023-2026 [WIP]");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        System.out.print("Enter Year: ");
        season = userInput.nextInt();
        userInput.nextLine();

        switch (season) {
            case 0 -> new Main().viewMainPage();
        }

    }

    public void DriversChampionshipMainPage() throws Exception {
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
                showFinalStandings();

        } else {
            System.out.println("Invalid, try again!");
            DriversChampionshipMainPage();
        }
    }

    public  void showPointsProgression() {
        System.out.println("====================================");
        System.out.println("------------------------------------");

    }

    public void showFinalStandings() {

        System.out.println("====================================");
        System.out.println("------------------------------------");

    }
}
