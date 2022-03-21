package uppgift2;

import java.util.*;

import junit.framework.Assert;


class Node {
    private double x, y, r;
    Node(double x, double y, double r) {

        this.x = x;

        this.y = y;

        this.r = r;}

    public double getRadius() {

        return r;

    }
 public double getXAxis() {

        return x;

    }

   public double getYAxis() {

        return y;

    }
   
 public void drawNode() {
 StdDraw.setPenColor(StdDraw.BLACK);
  StdDraw.setPenRadius(0.002);
        StdDraw.circle(x, y, r);

    }

}


class Graph {

    // A list of all the nodes that we read from the file

    private ArrayList<Node> nodes = new ArrayList<>();

    // A function insert that will insert a node in the list of nodes.

    public void insert(Node node) {

        nodes.add(node);

    }

    // metoden för att rita grafen

    public void drawGraph() {

        // A for each loop, this loop will iterate through all the nodes in our list and call the drawNode() function

        // that will draw the node on the canvas

        for (Node node : nodes) {

            node.drawNode();

        }

        // Once we have drawn the nodes, now we need to draw the paths wherever the circles overlap.

        // For this we will go through each node and check it's distance with the remaining nodes and see if we need to draw the path

        // To check what we'll do is, first we will find the distance between those nodes.

        // Then we will check if the distance is less than the sum of radius of the circles. If yes, we will draw a path

        // Iterate through all the nodes

        for(int i=0;i<nodes.size();i++) {

            // node1 = ith node

            Node node1 = nodes.get(i);

            // Iterate through all the nodes ahead of this node, so we initialize j = i+1 and not j = 0

            for(int j=i+1;j<nodes.size();j++) {

               

                Node node2 = nodes.get(j);

                // Now find the distance. So the distance between two points (x1, y1) and (x2, y2) is

                // sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1))

                // We calculate the distance here

                double distance = (node2.getXAxis()-node1.getXAxis())*(node2.getXAxis()-node1.getXAxis());

                distance +=  (node2.getYAxis()-node1.getYAxis())*(node2.getYAxis()-node1.getYAxis());

                distance = Math.sqrt(distance);

                // If distance is less than sum of the radii, call the drawPath function

                if(distance < node1.getRadius() + node2.getRadius()) {

                    drawPath(node1.getXAxis(),node1.getYAxis(), node2.getXAxis(), node2.getYAxis());

                }

            }

        }

    }


//för att rita line vi behöver två points
    public void drawPath(double x1, double y1, double x2, double y2) {

        // Set the color of the pen to Blue

        StdDraw.setPenColor(StdDraw.BLUE);

        // Set the pen radius to 0.003

        StdDraw.setPenRadius(0.003);

        // Draw a line from (x1, y1) to (x2, y2)

        StdDraw.line(x1, y1, x2, y2);

    }


    public void DepthFirstSearchIterative(Node node) {
       Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<Node>();

        stack.add(node);

        while (!nodes.isEmpty()) {
            node = stack.pop();
            visited.add(node);
            boolean endOfRoad = true;
            for (Node child : stack) {
                if (!visited.contains(child)) {
                    endOfRoad = false;
                    stack.add(child);
                }
            }
            if (endOfRoad) {
               
                System.out.println(node);
            }
        }
    }
    public void BreadthFirstSearchIterative(Node node) {
       Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(node);
            for (Node child : queue ) {
                queue.add(child);
            }
        }
    }

public boolean isConnected(Node node1, Node node2) {
	boolean isconnected = false;
	//loop för att rita alla noder
    for(int i=0;i<nodes.size();i++) {
    node1 = nodes.get(i);
//loop for följande (nästa) node
    for(int j=i+1;j<nodes.size();j++) {
     node2 = nodes.get(j);
double distance = (node2.getXAxis()-node1.getXAxis())*(node2.getXAxis()-node1.getXAxis());

    distance +=  (node2.getYAxis()-node1.getYAxis())*(node2.getYAxis()-node1.getYAxis());

  if(distance < node1.getRadius() + node2.getRadius()) {
     System.out.println(node1 + " and "+ node2+ "is connected");
       isconnected = true;
  }
  }

  }
	return isconnected;
}

}

