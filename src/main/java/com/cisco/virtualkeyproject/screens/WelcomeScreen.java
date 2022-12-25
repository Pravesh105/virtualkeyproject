package com.cisco.virtualkeyproject.screens;
import com.cisco.virtualkeyproject.services.DirectoryService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cisco.virtualkeyproject.screens.Screen;

import com.cisco.virtualkeyproject.services.DirectoryService;
import com.cisco.virtualkeyproject.services.ScreenService;

public class WelcomeScreen implements Screen{
	private String welcomeText = "   | Welcome to VirtualKey | ";
    private String developerText = "   Developer:Pravesh Kumar Patel";

    private ArrayList<String> options = new ArrayList<>();

    public WelcomeScreen() {
        options.add("   1. Show Files");
        options.add("   2. Show File Options Menu");
        options.add("   3. Quit");

    }
    public void introWS() {
    	System.out.println("    _______________________");
    	System.out.println(welcomeText);
    	System.out.println("    ***********************");
    	System.out.println("   _____________________________");
        System.out.println(developerText);
        System.out.println("   *****************************");
        System.out.println("\n");
        Show();
    }
    @Override
    public void Show() {
    	System.out.println("    ___________");
    	System.out.println("   | Main Menu |");
    	System.out.println("    ***********");
        for (String s : options)  {
            System.out.println(s);
        }
    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("   Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

        System.out.println("   List of Files: ");
    	DirectoryService.PrintFiles();

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
