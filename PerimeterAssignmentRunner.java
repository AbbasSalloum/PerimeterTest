import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 3
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for(Point p:s.getPoints()){
            count=count+1;
            
        }
            
           
        return count;
    }

    public double getAverageLength(Shape s) {
        double Avg=0.0;
        double num=getNumPoints(s);
        double total=getPerimeter(s);
        Avg=total/num;
       
        return Avg;
    }

    
   public double getLargestSide(Shape s) {
        // Put code here
        double LSide=0.0;
        Point PrePt=s.getLastPoint();
        for (Point CurPt : s.getPoints()){
            double Dis= PrePt.distance(CurPt);
            if(Dis > LSide){
                LSide=Dis;
            }
          }
            
        
        return LSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double LarX=0.0;
        for(Point CurPt :s.getPoints ()){
            double x=CurPt.getX();
            if(x>LarX){
                LarX=x;
            }
        }
            return LarX;
    }

    
    
    
    
    
  
  
public double getLargestPerimeterMultipleFiles() {
        double LargestPerm=0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
         FileResource fr= new FileResource(f);
         Shape s = new Shape(fr);
         double Perm=getPerimeter(s);
         if(Perm>LargestPerm){
             LargestPerm=Perm;
         
        }
    }
        return LargestPerm;
    }

    public String getFileWithLargestPerimeter() {
        
        File temp=null;
        double LargePerm=0.0;
        DirectoryResource dr= new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s= new Shape(fr);
            double FilePerm=getPerimeter(s);
            if(FilePerm>LargePerm){
              temp=f;
            
            
            }
          
    }
    return temp.getName();
    
}

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int NumOfPt=getNumPoints(s);
        System.out.println("Number of Points = " + NumOfPt);
        double Average=getAverageLength(s);
        System.out.println("Average Length = " + Average);
        double LargestSide=getLargestSide(s);
        System.out.println("Largest Side = " + LargestSide);
        double LargestX=getLargestX(s);
        System.out.println("Largest X = " + LargestX);
        
        
        
    }
    
    public void testPerimeterMultipleFiles() {
        double LargestPermFile=getLargestPerimeterMultipleFiles();
        System.out.println("LargestPermFile = " + LargestPermFile);
        
        
    }

    public void testFileWithLargestPerimeter() {
        String File = getFileWithLargestPerimeter();
        System.out.println("File Name = " + File);
        
       
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        
    }
}
