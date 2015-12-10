// Richard Wang
// APCS1 pd9
// HW45 -- .
// 2015-12-09

public class Rational implements Comparable {
    public int numerator;
    public int denominator;
    
    public Rational() {
        numerator = 0;
        denominator = 1;
    }
    
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("STOP DIVIDING BY 0!!!!!!!");
            this.denominator = 1;
            this.numerator = 0;
        }
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public float floatValue(){
        return this.numerator / this.denominator;
    }

    
    public void multiply(Rational other) {
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
    }
    
    public void divide(Rational other) {
    	if (other.numerator == 0) {
        	this.numerator *= other.denominator;
        	this.denominator *= other.numerator;
    	} else {
	    System.out.println("Cannot divide by 0.");
    	}
    }
    
    public static void main(String[] args) {
        Rational r = new Rational(1, 1);
        Rational s = new Rational(7, 20);
	Rational t = new Rational(14, 40);
	s.compareTo(r);
        System.out.println(s.compareTo(r));
	System.out.println(s.equals(t));
     }

  /*=====================PHASE 2=====================*/

     public void add(Rational other){
	 this.numerator *= other.denominator;
	 this.numerator += (other.numerator * this.denominator);
	 this.denominator *= other.denominator;
     }

     public void subtract(Rational other){
	 this.numerator *= other.denominator;
	 this.numerator -= (other.numerator * this.denominator);
	 this.denominator *= other.denominator;
     }

     public int gcdEW(){
	 int gcd = 0;
	 int a = this.numerator;
	 int b = this.denominator;
	     if (a == 0){
		 return b;
	     }
	 while (a != 0 || b != 0){
	     if (a > b) {
		 if (a % b == 0){
		     gcd = b;
		 }
		 a = a % b;
	     }
	     else {
		 if ( b % a == 0){
		     gcd = a;
		 }
		 b = b % a;
	     }
	 }
	 return gcd;
     }

     public void reduce(){
	 int gcd = gcdER(this.numerator, this.denominator);
	 this.numerator /= gcd;
	 this.denominator /= gcd;
     }

     /*=====================PHASE 3=====================*/
     public static int gcdER (int a, int b){
	 if ((a == b) || (b == 0)){
	     return a;} //returns the GCD.
	 else if (a < b){
	     return gcdER (b,a);} //If b is greater than a, the function will be run again with both values swapped.
	 else{
	     return gcdER (b , (a-b));
	 }
     }

     public int compareTo (Object other){
	 if (this.floatValue() > other.floatValue()) {
	     return 1;
	 } else if (this.floatValue() < other.floatValue()) {
	     return -1;
	 } else {
	     return 0;
	 }
    }

    /*=====================PHASE 4=====================*/
    public boolean equals(Object other){
	boolean retboo = this == other;
	if (!retboo) {
	    retboo = (other instanceof Rational && ((this).compareTo((Rational)other))==0);
	}
	return retboo;
    }
}
