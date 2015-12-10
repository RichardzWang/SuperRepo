// Richard Wang
// APCS1 pd9
// HW45 -- .
// 2015-12-09

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
	String retStr = "[";
	for( int i = 0; i < _size; i++ ) {
	    retStr += _data[i] + ",";
	}
	//shave off trailing comma
	if ( retStr.length() > 1 )
	    retStr = retStr.substring( 0, retStr.length()-1 );
	retStr += "]";
	return retStr;
    }

		
    //double capacity of this SuperArray
    private void expand() {
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal) { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	if (_size == _data.length) 
	    expand();
	    
	_lastPos += 1;
	_size += 1;
	_data[_lastPos] = newVal;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	if (index < _size && index > -1) {
	    for (int i = _lastPos; i > index - 1; i--) {
	        _data[i + 1] = _data[i];
	    }
	    _data[index] = newVal;
	    _lastPos++;
	    _size++;
	}
	else
	    System.out.println("error: index out of range");	
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
        if (index < _size && index > -1) {
	    for (int i = index; i < _lastPos; i++) {
		_data[i] = _data[i+1];
	    }
	    _data[_lastPos] = null;
	    _lastPos--;
	    _size--;
	}
	else
	    System.out.println("error: index out of range");	
    }
    
    public int linSearch(Comparable item) {
	for (int c = 0; c < _size ; c++){
	    if (_data[c].equals(item)){
		return c;
	    }
	}
	return -1;
    }

    public boolean isSorted() {
	for (int c = 0; c < _size -1; c++) {
	    if ((_data[c].compareTo(_data[c+1])) > 0) {
		return false;
	    }
	}
	return true;
    }

    //return number of meaningful items in _data
    public int size() { return _size; }

    //main method for testing
    public static void main( String[] args ) {
	SuperArray curtis = new SuperArray();
	Comparable a = new Rational(121,12);
	Comparable b = new Binary(16);
	Comparable c = new Hexadecimal(13);
	curtis.add(a);
	curtis.add(b);
	curtis.add(c);
	
	System.out.println(curtis);
	System.out.println(curtis.linSearch(a));
	System.out.println(a.compareTo(b));
	System.out.println(b.compareTo(c));
	System.out.println(curtis.isSorted());

    }//end main
		
}//end class
