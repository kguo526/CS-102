/* Kelvin Guo
CS-102, Spring 2018 
Assignment 1
Description: TennisDatabase class combines TennisPlayer
and TennisMatch containers into one database
*/

package TennisDatabase;

import java.io.*;
import java.util.*;

public class TennisDatabase implements TennisDatabaseInterface 
{
   // Initialize variables
   private TennisPlayersContainer tpc;
   private TennisMatchesContainer tmc;
   private static File inFile;
   private static Scanner fileScan;

   // Default TennisDatabase Constructor
   public TennisDatabase() 
   {
      tpc = new TennisPlayersContainer();
      tmc = new TennisMatchesContainer();
   }

   // Load input file into program and divide it into variables
   public void loadFile() 
   {
      Scanner terminal = new Scanner(System.in);
      String fileName;
      boolean valid = false;
      do 
      {
         try 
         {
            System.out.println("Please Enter a file name: ");
            fileName = terminal.next();
            inFile = new File(fileName);
            fileScan = new Scanner(inFile);
            valid = true;
         }
         catch (FileNotFoundException invalidFile) 
         {
            System.out.println("Input a valid file name. Please enter a new one (Example: inputFile.txt)");
         }
      } 
      while (!valid);
      String dataLine; 
      String[] data; 
      while (fileScan.hasNext()) 
      {
         dataLine = fileScan.nextLine(); 
         data = dataLine.split("/"); 
         switch (data[0].charAt(0)) 
         { 
            case 'P':
                insertPlayer(data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]); 
                break;
            case 'M':
                TennisMatch m = new TennisMatch(data[1], data[2], Integer.parseInt(data[3].substring(0, 4)), Integer.parseInt(data[3].substring(4, 6)), Integer.parseInt(data[3].substring(6, 8)), data[4], data[5]);
                tmc.insertMatch(m); 
                tpc.insertMatch(m); 
                break;
         }
      }
      fileScan.close();
   }
   
   // Prints all stored Tennis Players
   public void printAllPlayers() 
   {
      tpc.printAllPlayers(tmc);
   }
   
   // Prints all matches of a given player
   public void printMatchesOfPlayer(String Id) 
   {
      tmc.printMatchesOfPlayer(Id); 
   }
   
   // Prints all stored Tennis Matches
   public void printAllMatches() 
   {
      tmc.printAllMatches();
   }

   // Inserts a player into the tennis player container
   public void insertPlayer(String id, String firstName, String lastName, int year, String country) 
   { 
      TennisPlayer p = new TennisPlayer(id, firstName, lastName, year, country);
      tpc.insertPlayer(p);
   }
   
   // Inserts a match
   public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score) 
   {
      TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, year, month, day, tournament, score);
      tmc.insertMatch(m);
      tpc.insertMatch(m);
   }
}
