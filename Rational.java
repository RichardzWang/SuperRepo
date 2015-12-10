// Richard Wang
// APCS1 pd9
// HW45 -- .
// 2015-12-09

public class Rational implements Comparable{
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

    public int compareTo (Rational o){
	int diff = this.numerator*o.denominator - o.numerator*this.denominator;
	if (diff > 0){
            return 1;
        }
	else if (diff == 0){
            return 0;
        }
        else{
	    return -1;
	}
    }
    
    public int compareTo (Object o){
	if (o == null) {
	    throw new NullPointerException("\n compareTo() input is null");
	}
	if (!(o instanceof Comparable)) {
	    throw new ClassCastException("\n compareTo() input does not implement Comparable");
	}
	else {
	    if (o instanceof Rational) {
		return this.compareTo((Rational)o);
	    }
	    if (o instanceof Binary) {
		Rational other = new Rational(((Binary)o).get_DecNum(), 1);
		return this.compareTo(other);
	    }
	    if (o instanceof Hexadecimal) {
		Rational other = new Rational(((Hexadecimal)o).get_DecNum(), 1);
		return this.compareTo(other);
	    }
	    else {
		throw new ClassCastException("\n compareTo() input does not implement Comparable");
	    }
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

    public static void main(String[] args) {
        Rational r = new Rational(1, 1);
        Rational s = new Rational(7, 20);
	Rational t = new Rational(14, 40);
	System.out.println ("Fraction 1:\t" + r);
	System.out.println ("Fraction 2:\t"+ s);
	System.out.println ("Fraction 3:\t" +t);
        System.out.println("Comparing Fraction 2 to Fraction 1:\t" + s.compareTo(r)); //should return -13
	System.out.println("Checking to see if Fraction 2 is equal to Fraction 1\t" + s.equals(r)); // should return false
	System.out.println("Checking to see if Fraction 2 is equal to Fraction 3\t" + s.equals(t)); //should return true
    }
}
