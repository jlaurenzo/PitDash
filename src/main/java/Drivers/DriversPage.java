package Drivers;

import java.util.Scanner;

public class DriversPage {
    Scanner userInput = new Scanner(System.in);

    int season;
    int mainPage;
    String driverName;
    public String session_key;
    public boolean perYear = true;

    public void showDriversYearPage() throws Exception {
        System.out.println("            SELECT YEAR");
        System.out.println("[1] 2023");
        System.out.println("[2] 2024");
        System.out.println("[3] 2025");
        System.out.println("[1] 2026");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        System.out.print("Enter Year: ");
        season = userInput.nextInt();
        userInput.nextLine();
        getSeason(season);
        showDriversMainPage();
    }

    public void showDriversMainPage() throws Exception {
        System.out.println("====================================");
        System.out.println("            DRIVERS PAGE");
        System.out.println("[1] Show all drivers");
        System.out.println("[2] Search driver by name");
        System.out.println("[3] Filter by team");
        System.out.println("[4] Show all drivers (2022-2026)");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice: ");
        mainPage = userInput.nextInt();

        switch (mainPage) {
            case 1:
                Driver.showDrivers(session_key);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;

        }




    }

    public void showSearchNamePage() throws Exception {
        System.out.println("====================================");
        System.out.println("            SEARCH DRIVER");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        driverName = userInput.nextLine();
        userInput.nextLine();

    }

    public void showAllDrivers() throws Exception {
        System.out.println("====================================");
        System.out.println("        ALL DRIVERS PER YEAR");
        System.out.println("------------------------------------");


    }





    public String getSeason(int season) {
        switch (season) {
            case 1:
                session_key = "9197";
                break;
            case 2:
                session_key = "9662";
                break;
            case 3:
                session_key = "9839";
                break;
            case 4:
                session_key = "11465";
                break;
            case 5:
                break;
        }

    return session_key;
    }


}
