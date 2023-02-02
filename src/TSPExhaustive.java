import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class TSPExhaustive {
	protected static ArrayList<Point> pointList = new ArrayList<>();
	protected static int numPoints;
	protected static ArrayList<ArrayList<Point>> paths = new ArrayList<>();
	protected static ArrayList<Double> distanceArray = new ArrayList<>();
	
	
	
	public static void getPermutations(ArrayList<Point> array){  
        helper(array, 1);  
    }  
  
    private static void helper(ArrayList<Point> array, int pos){  
    	ArrayList<Point> tempArray = new ArrayList<>();
    	
        if(pos >= array.size() - 1){    
            for(int i = 0; i < array.size(); i++){  
                tempArray.add(array.get(i));
            }  
            
            paths.add(tempArray);
            return;  
        }  
  
        for(int i = pos; i < array.size(); i++){   
          
            Point t = array.get(pos); 
            array.set(pos,array.get(i));
            array.set(i, t);
 
            helper(array, pos+1);  
  
            t = array.get(pos); 
            array.set(pos,array.get(i));
            array.set(i, t);  
        }  
    }  
    
    
    
    public static double getDistance(ArrayList<Point> array) {
    	double distance = 0.0;
    	
    	for (int i =0; i<numPoints - 1;i++) {
    		distance += Math.sqrt(Math.pow(array.get(i).x-array.get(i+1).x,2)  +  Math.pow(array.get(i).y-array.get(i+1).y,2));
    	}
    	
    	distance += Math.sqrt(Math.pow(array.get(numPoints-1).x-array.get(0).x,2)  +  Math.pow(array.get(numPoints-1).y-array.get(0).y,2));
    	return distance;
    }
    
    
    public static void main(String[] args) {
			
	        Scanner sc = new Scanner(System.in);
	        numPoints = sc.nextInt();
	        for(int i = 0; i<numPoints;i++) {
	        int x = sc.nextInt();
	        int y = sc.nextInt();
	        Point temp = new Point(x,y);
	        pointList.add(temp);
	        }
	        
	        getPermutations(pointList);
	       
	       
	        
	        for (int i=0;i<paths.size();i++) {
	        	 distanceArray.add(getDistance(paths.get(i)));
	        }


	        double minDistance = distanceArray.get(0);
	        
	        for (int i =0; i<distanceArray.size();i++) {
	        	if(distanceArray.get(i) <= minDistance) {
	        		minDistance = distanceArray.get(i);
	        	}
	        }
	        
	        
	        System.out.printf("%.3f %n", minDistance);
	}
	

}
