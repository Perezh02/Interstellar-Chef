package com.interstellarchef.view;

public class View {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void printStartBanner() {
        clearScreen();
        System.out.println("                                              ▄█  ███▄▄▄▄       ███        ▄████████    ▄████████    ▄████████     ███        ▄████████  ▄█        ▄█          ▄████████    ▄████████      \n" +
                "                                             ███  ███▀▀▀██▄ ▀█████████▄   ███    ███   ███    ███   ███    ███ ▀█████████▄   ███    ███ ███       ███         ███    ███   ███    ███      \n" +
                "                                             ███▌ ███   ███    ▀███▀▀██   ███    █▀    ███    ███   ███    █▀     ▀███▀▀██   ███    █▀  ███       ███         ███    ███   ███    ███      \n" +
                "                                             ███▌ ███   ███     ███   ▀  ▄███▄▄▄      ▄███▄▄▄▄██▀   ███            ███   ▀  ▄███▄▄▄     ███       ███         ███    ███  ▄███▄▄▄▄██▀      \n" +
                "                                             ███▌ ███   ███     ███     ▀▀███▀▀▀     ▀▀███▀▀▀▀▀   ▀███████████     ███     ▀▀███▀▀▀     ███       ███       ▀███████████ ▀▀███▀▀▀▀▀        \n" +
                "                                             ███  ███   ███     ███       ███    █▄  ▀███████████          ███     ███       ███    █▄  ███       ███         ███    ███ ▀███████████      \n" +
                "                                             ███  ███   ███     ███       ███    ███   ███    ███    ▄█    ███     ███       ███    ███ ███▌    ▄ ███▌    ▄   ███    ███   ███    ███      \n" +
                "                                             █▀    ▀█   █▀     ▄████▀     ██████████   ███    ███  ▄████████▀     ▄████▀     ██████████ █████▄▄██ █████▄▄██   ███    █▀    ███    ███      \n" +
                "                                                                                       ███    ███                                       ▀         ▀                        ███    ███      \n" +
                "                                                                                           ▄████████    ▄█    █▄       ▄████████    ▄████████                                              \n" +
                "                                                                                          ███    ███   ███    ███     ███    ███   ███    ███                                              \n" +
                "                                                                                          ███    █▀    ███    ███     ███    █▀    ███    █▀                                               \n" +
                "                                                                                          ███         ▄███▄▄▄▄███▄▄  ▄███▄▄▄      ▄███▄▄▄                                                  \n" +
                "                                                                                          ███        ▀▀███▀▀▀▀███▀  ▀▀███▀▀▀     ▀▀███▀▀▀                                                  \n" +
                "                                                                                          ███    █▄    ███    ███     ███    █▄    ███                                                     \n" +
                "                                                                                          ███    ███   ███    ███     ███    ███   ███                                                     \n" +
                "                                                                                          ████████▀    ███    █▀      ██████████   ███                                                     \n" +
                "                                                                                                                                                                                           ");
        System.out.println("\n                                                                                     Welcome Chef! A world of cosmic culinary adventure awaits!                        ");
        System.out.println("\n                                                                                                     Press Enter To Continue                                                ");
    }

    public void printGameIntro(){
        clearScreen();
        System.out.println("                                                                      Welcome to InterstellarChef, where you can embark on a culinary journey across the cosmos!\n"
            + "                                                       As a spaceship sous chef, you must travel near and far to gather the most rare and delectable ingredients in the universe.\n"
            + "                                                                                        Only then can you complete your dish and feed the crew!\n");
    }

}

