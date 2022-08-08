package main.java.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import main.java.dto.Team;

public class Main {
	
	public static void main(String[] args) throws IOException {
		  for (String s: args) {
	            System.out.println(s);
	        }
       

        Scanner scan = new Scanner(new File(args[0]));
        String fileString = ""; 
        System.out.println("====");
        
        List<Team> teamsArray = new ArrayList<Team>();
        
        while (scan.hasNextLine()) {
            fileString = scan.nextLine();
            String[]match = fileString.split(",");

                int team1score = Integer.valueOf(match[1].trim());
                int team2score = Integer.valueOf(match[3].trim());

                // Create a temp team to search the List
                Team team1 = new Team(match[0]);
                // Search the list
                if (!teamsArray.contains(team1)) {
                    // Not in the list already. Add it
                    teamsArray.add(team1);
                }
                else {
                    // Already in the List. Use that one.
                    team1 = teamsArray.get(teamsArray.indexOf(team1));
                }
                // Repeat for team 2
                Team team2 = new Team(match[2]);
                if (!teamsArray.contains(team2)) {
                    teamsArray.add(team2);
                }
                else {
                    team2 = teamsArray.get(teamsArray.indexOf(team2));
                }
                team1.teamValues(team1score, team2score);
                team2.teamValues(team2score, team1score);
          
        }
       
        // Sort and print
        teamsArray
            .stream()
            .sorted(Comparator.reverseOrder())
            .forEach(t -> {

            	System.out.println(t);
            
            });

        
        scan.close();
        
	}
	


}
