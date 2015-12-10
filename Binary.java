//Richard Wang
//APCS1 pd9
//HW45 -- .
//2015-12-09

//skeleton file for class Binary

public class Binary implements Comparable{

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	_decNum = 0;
	_binNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	_decNum = n;
	_binNum = decToBin(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	_decNum = binToDec(s);
	_binNum = s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	String retStr = "";
	while (n>0) {
	    retStr = (n % 2) + retStr;
	    n /= 2;
	}
	return retStr;
    }

    public int get_DecNum() {
	return _decNum;
    }

    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	if (n == 0) { //base case - pre says n >= 0
	    return "";
	} 
	else {
	    return decToBinR(n/2) +(n % 2) ;
	}
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	int ret = 0;
	for (int c = 0  ; c < s.length() ; c++) {
	    ret += Integer.parseInt(s.substring(c,c+1))*((int)(Math.pow(2,s.length() - 1 - c)));
	}
	return ret;
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	if (s.length() <= 1) { //length of 1 means 2^0, units
	    return Integer.parseInt(s);
	} else {
	    return ((int)Math.pow(2,s.length()-1)) * Integer.parseInt(s.substring(0,1)) + binToDecR(s.substring(1));
	}
	
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/ 
	boolean retboo = this == other; //checks for alias
	if (!retboo) {
	    retboo = _binNum.equals(((Binary)other)._binNum); //checks if other has the equal binary value (No need to use instanceof because of precondition)
	}
	return retboo;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object o ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	Rational rat = new Rational(_decNum,1); // This method uses Rational's compareTo
	if (o == null) { //null is a primitive
	    throw new NullPointerException("\n compareTo() input is null");
	}
	if (!(o instanceof Comparable)) {
	    throw new ClassCastException("\n compareTo() input does not implement Comparable");
	}
	else {
	    if (o instanceof Rational) { //Case 1: Rational
		return rat.compareTo((Rational)o);
	    }
	    if (o instanceof Binary) { //Case 2: Binary
		Rational other = new Rational(((Binary)o).get_DecNum(), 1);
		return rat.compareTo(other);
	    }
	    if (o instanceof Hexadecimal) { //Case 3: Hexadecimal
		Rational other = new Rational(((Hexadecimal)o).get_DecNum(), 1);
		return rat.compareTo(other);
	    }
	    else { //Safety
		throw new ClassCastException("\n compareTo() input does not implement Comparable");
	    }
	}
    }


    //main method for testing
    public static void main( String[] args ) {

	Binary gur = new Binary(10);
	Binary hur = new Binary(2);
	System.out.println(hur.compareTo(gur));


    }//end main()

} //end class
