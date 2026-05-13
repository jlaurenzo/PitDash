package Drivers;

import APIManager.OpenF1APIClient;
import APIManager.OpenF1Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DriversPage {
    Scanner userInput = new Scanner(System.in);

    int season;
    int mainPage;
    protected String year;
    String driverName;
    public List<String> sessionKeys = new ArrayList<>();

    public void showDriversYearPage() throws Exception {
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
        getSeason(season);
        showDriversMainPage();
    }

    public void showDriversMainPage() throws Exception {
        System.out.println("====================================");
        System.out.println("            DRIVERS PAGE");
        System.out.println("[1] Show drivers");
        System.out.println("[2] Search driver by name");
        System.out.println("[3] Filter by team");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        System.out.print("Enter Choice: ");
        mainPage = userInput.nextInt();

        switch (mainPage) {
            case 1 -> showDrivers();
            case 2 -> showSearchDriverNamePage();
            case 3 -> showFilterByTeamPage();
            case 0 -> showDriversYearPage();

            default -> System.out.println("Try Again");

        }
    }

    public void showSearchDriverNamePage() throws Exception {
        System.out.println("====================================");
        System.out.println("            SEARCH DRIVER");
        System.out.println("[0] Back");
        System.out.println("------------------------------------");
        driverName = userInput.nextLine();
        userInput.nextLine();

        if (driverName == "0") {
            showDriversMainPage();
        } else {
            showDriversMainPage();
        }

        System.out.println("====================================");
    }

    public void showDrivers() throws Exception {
        System.out.println("====================================");
        System.out.println("           "+ year + " SEASON");
        Driver.showDrivers(sessionKeys);
        System.out.println("------------------------------------");
    }


    public void showFilterByTeamPage() throws Exception{
        System.out.println("====================================");
        System.out.println("            FILTER BY TEAM");
    }


    public List<String> getSeason(int season) {
        switch (season) {
            case 1:
                year = "2023";
                sessionKeys.addAll(Arrays.asList("7953", "9133", "9173"));
                break;
            case 2:
                year = "2024";
                sessionKeys.addAll(Arrays.asList("7953", "9133", "9173"));
                break;
            case 3:
                year = "2025";
                sessionKeys.addAll(Arrays.asList("7953", "9133", "9173"));
                break;
            case 4:
                year = "2026";
                sessionKeys.addAll(Arrays.asList("7953", "9133", "9173"));
                break;
            case 5:
                year = "2023-2026";
                break;
            default:
                System.out.println("Enter a valid number (1-3 | 0)");
                break;
        }
    return sessionKeys;
    }


}
