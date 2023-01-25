/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//package dsaj.arrays;

/** Class for storing high scores in an array in nondecreasing order. */

import java.util.Arrays;


public class Scoreboard {
  private int numEntries = 0;              // number of actual entries
  private GameEntry[] entries;               // array of game entries (names & scores)
  
  /** Constructs an empty scoreboard with the given capacity for storing entries. */
  public Scoreboard(int capacity) {
    entries = new GameEntry[capacity];
  }

  /** Attempt to add a new score to the collection (if it is high enough) */
  public void add(GameEntry e) {
    int n = 0;
    int place = 0;

    //if the array isn't full, just add current score as a new highscore
    //as it's not even full
    //does that until it is actually full
    if(entries[0] == null){
      entries[0] = e;
      return;
    }
    if(entries[1] == null){
      entries[1] = e;
      return;
    }
    if(entries[2] == null){
      entries[2] = e;
      return;
    }
    if(entries[3] == null){
      entries[3] = e;
      return;
    }
    if(entries[4] == null){
      entries[4] = e;
      return;
    }

    //finds the current lowest high score in the list
    GameEntry low = entries[0];
    for (GameEntry i: entries){
      if(i.getScore()<low.getScore()){
        low=i;
        //gets the index of the lowest score
        place = n;
      }
      n++;
      
    }

    //checks if the new score is actually a high score
    for (GameEntry j: entries){
      if (j.getScore()<e.getScore()){
        //if it is, then replace the lowest score
        entries[place] = e;
        //break out of the loop as we already replaced it
        break;
      }
    }
    //the highscore print from Chung's test code wasn't working,
    //so I have my own print to print the list
    //it will only acutally print if the highscore array is full
    System.out.println(Arrays.toString(entries));

   //put your code here based on class notes or reading
  }

  /** Returns a string representation of the high scores list */
  public String toString() {
    String s = "[";
    for (int i = 0; i < numEntries; i++) {
      if (i > 0) s  += ", "; // separate entries by commas
      s += entries[i];
    }
    return s + "]";
  }
  
  public static void main(String[] args) {
    // The main method
    Scoreboard highscores = new Scoreboard(5);
    String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
    int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

	for (int i=0; i < names.length; i++) {
      GameEntry gE = new GameEntry(names[i], scores[i]);
      System.out.println("Adding " + gE);
      highscores.add(gE);
      System.out.println(" Scoreboard: " + highscores);
    }
  }
}