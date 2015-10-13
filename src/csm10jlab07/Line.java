package csm10jlab07;

/**
 *
 * @author brianobioha
 */
public class Line {
    Line(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    Line(Line other){
        a = other.getA();
        b = other.getB();
        c = other.getC();
    }
    Line(){}
    
    public double getSlope(){
        if(Double.isNaN(this.getB())) return Double.NaN;
        return (-this.getA()/this.getB());
    }
    public boolean equals(Line other){
       if (getA() == other.getA() && getB() == other.getB() && getC() == other.getC())
           return true;
       else if(getA()/other.getA() == getB()/other.getB() && getA()/other.getA() == getC()/other.getC())
           return true;
       return false;
    }
    public boolean parallelTo(Line other){
        return getSlope() == other.getSlope();
    }
    public boolean perpendicularTo(Line other){
        if(isHorizontal() && other.isVertical() || isVertical() && other.isHorizontal())
            return true;
        else if(getSlope()*other.getSlope() == -1)
            return true;
        return false;
    }
    public boolean isHorizontal(){
        return getA() == 0;
    }
    public boolean isVertical(){
        return getB() == 0;
    }
    
    public double getA(){ return a;}
    public double getB(){ return b;}
    public double getC(){ return c;}
    
    public void setA(double a){this.a = a;}
    public void setB(double b){this.b = b;}
    public void setC(double c){this.c = c;}
    
    private double a, b, c;
    
    public static void main(String [] args){
        // test cases
        // default constructor
        Line slopeOfOne = new Line();
        // test the get / set methods
        System.out.println("Test Get / Set");
        slopeOfOne.setA(-1);
        System.out.println("A == -1 ? " + (slopeOfOne.getA() == -1));
        slopeOfOne.setB(1);
        System.out.println("B == 1 ? " + (slopeOfOne.getB() == 1));
        slopeOfOne.setC(1);
        System.out.println("C == 1 ? " + (slopeOfOne.getC() == 1));
        System.out.println();
        // special constructor
        Line slopeOfTwo = new Line(-2, 1, 2);
        System.out.println("Test special constructor");
        System.out.println("A == -2 ? " + (slopeOfTwo.getA() == -2));
        System.out.println("B == 1 ? " + (slopeOfTwo.getB() == 1));
        System.out.println("C == 2 ? " + (slopeOfTwo.getC() == 2));
        System.out.println();
        
        // slope defined
        Line slopeDefined = new Line(1, 1, 1);
        System.out.println("Test slope defined");
        System.out.println("Slope defined ? " + !Double.isNaN(slopeDefined.getSlope()));
        System.out.println();
        // slope undefined
        Line slopeUndefined = new Line(1, 0, 2);
        System.out.println("Test slope undefined");
        System.out.println("Slope NaN ? " + !Double.isNaN( slopeUndefined.getSlope() ));
        System.out.println();
        
        System.out.println("Test parallel");
        // parallelTo
        Line line1 = new Line(2, 4, 6);
        Line line2 = new Line(line1);
        System.out.println("Are parallel? " + line1.parallelTo(line2));
        
        // not parallelTo
        line1.setA(3);
        System.out.println("Are not parallel? " + line1.parallelTo(line2));
        System.out.println();
        
        // perpendicularTo
        line1.setA(0);
        line2.setB(0);
        System.out.println("Test perpendicular");
        System.out.println("Are perpendicular? " + line1.perpendicularTo(line2));
        
        // not perpendicularTo
        line1.setA(2);
        
        System.out.println("Are not perpendicular? " + line1.perpendicularTo(line2));
        System.out.println();
        
        System.out.println("Test equality");
        // equal (same coefficient)
        Line line3 = new Line(line1);
         System.out.println("Same coefficients, are equal? " +  line3.equals(line1));
        // equal (multiple of coefficients)
         line3.setA(4);
         line3.setB(8);
         line3.setC(12);
        System.out.println("Different coefficients, same multiplier, are equal? " + line3.equals(line1));
        // not equal
        line3.setA(9);
        System.out.println("Are not equal? " +  line3.equals(line1));

    }
}
