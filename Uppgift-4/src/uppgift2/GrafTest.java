package uppgift2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GrafTest {

	public static void main(String[] args) {

        // Try to open and read the file

        try {

            // Open the file named "input.txt"

            File file = new File("karta2.txt");

            Scanner sc = new Scanner(file);

            // Create a new instance of graph

            Graph graph = new Graph();

            // While we have next line in our file, keep on reading it

            while(sc.hasNextLine()) {

                // This line will bypass the line "Node: x" in our txt file

                sc.nextLine();

                // This line will read the line next to the "Node: x" line and store it into data

                String data = sc.nextLine();

                // Now we will split the line, say "x: 130" into an array like this ["x", "130"] and then we will parse the second

                // element of the array which is our value and then divide it by 1000 because the x should be between 0 and 1

                // and then store it in a variable x

                // So the split() method breaks a given string around matches of the given regular expression

                // and the strip() method removes any whitespaces from front and rear of a string.

                double x = Double.parseDouble((data.split(":")[1]))/1000;

                // Similarly we will get our y

                data = sc.nextLine();

                double y = Double.parseDouble((data.split(":")[1]))/1000;

                // And r

                data = sc.nextLine();

                double r = Double.parseDouble((data.split(":")[1]))/1000;

                // Create a new Node

                Node newNode = new Node(x, y, r);

                // Insert this node into our graph

                graph.insert(newNode);

            }

            // draw the graph

            graph.drawGraph();

            // Close our reader

            sc.close();

        }

        // If file is not found this block will be executed

        catch (FileNotFoundException ex ) {

            System.out.println("File not found");

        }

    }

}


