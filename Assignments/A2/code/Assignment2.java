//Kelvin Guo
//CS-102
//May 7th 2018

import TennisDatabase.TennisDatabase;
import TennisDatabase.TennisDatabaseException;
import TennisDatabase.TennisDatabaseRuntimeException;
import java.util.*;
import java.io.File;

public class Assignment1
{
   private static File inFile;
   private static Scanner fileScan;

   public static void main ( String[] args)
   {
      TennisDatabase tdb = new TennisDatabase();
      tdb.loadFile();
      Scanner scan = new Scanner(System.in);
      int input;
      boolean isRunning = true;
      
      while (isRunning == true)
      {
         System.out.println("Welcome to the CS-102 Tennis Manager" +
         "\nCurrent available commands: " +
         "\n1 --> Print all tennis players" +
         "\n2 --> Print all tennis matches of a player" +
         "\n3 --> Print all tennis matches" +
         "\n4 --> Insert a new tennis player" +
         "\n5 --> Insert a new tennis match" +
         "\n9 --> Exit");
         input = scan.nextInt();
         
         switch (input)
         {
            case 1:
               tdb.printAllPlayers();
               break;
            case 2:         
               System.out.println("Please enter the ID of the your desired player");
               tdb.printMatchesOfPlayer(scan.next());
               break;
            case 3:     
               tdb.printAllMatches();
               break;
            case 4:
               System.out.println("Please Enter the Player's ID");
               String id = scan.next();
               System.out.println("Please Enter the Player's First Name");
               String firstName = scan.next();
               System.out.println("Please Enter the Player's Last Name");
               String lastName = scan.next();
               System.out.println("Please Enter the Player's Birth Year");
               Integer year = scan.nextInt();
               System.out.println("Please Enter the Player's Country (One word or abbreviations only)");
               String country = scan.next();
               tdb.insertPlayer(id, firstName, lastName, year, country);
               break;
            case 5:
               System.out.println("Please Enter the First Player's ID");
               String idPlayer1 = scan.next();
               System.out.println("Please Enter the Second Player's ID");
               String idPlayer2 = scan.next();
               System.out.println("Please Enter the Day of the Match");
               Integer matchDay = scan.nextInt();
               System.out.println("Please Enter the Month of the Match");
               Integer matchMonth = scan.nextInt();
               System.out.println("Please Enter the Year of the Match");
               Integer matchYear = scan.nextInt();
               System.out.println("Please Enter the Name of the Tournament (One word only)");
               String tournament = scan.next();
               System.out.println("Please Enter the Score (Ex: 6-4,6-4)");
               String matchScore = scan.next();
               tdb.insertMatch(idPlayer1, idPlayer2, matchDay, matchMonth, matchYear, tournament, matchScore);
               break;
            case 9:
               isRunning = false;
               break;
            default:
               System.out.println("The option chosen was not one that was listed. Please try again");
               input = scan.nextInt();
               break;         
         }
      }
   }
}
