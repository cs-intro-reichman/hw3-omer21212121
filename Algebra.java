// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int val ues.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2>0){
		for (int i = 0; i<x2; i++){
			
		x1++;
		}} else {
			for (int i=0; i>x2; i--){
				x1--;
			}
		}
			
		return x1;
	}


	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2>0){
			for (int i = 0; i<x2; i++ ){
				x1--;
			}} else {
				for(int i =0; i>x2; i--) {
					x1++;
				}

			}

		
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int x = 0;
		if (x2>0){
			for(int i = 0; i<x2; i++) {
				x = plus(x, x1);
			}} else {
				for(int i = 0; i>x2; i--) {
					x = minus(x, x1);
				}}

		return x;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
    int t = 1;
    for (int i = 0; i < n; i++) {
        t = times(t, x);
    }
    return t;
}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 == 0){
			System.out.println("Error: Cannot divide by zero");
			return 0;
		}
		
		int k = 0;
		int i = 0;
		int symbol = 1;
		
		if ((x2<0 && x1>0) || (x2>0 && x1<0)){
			symbol = -1;
		}
		if (x2<0){
			x2 = minus(0, x2);
		}
		if (x1<0){
			x1 = minus(0, x1);
		}
		
		while (plus(k, x2) <= x1){
			k = plus(k, x2);
			i++;
		}
		
		int result = times(symbol, i);
		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int y = div(x1, x2);
		int t = times(y, x2);
		int result = minus(x1, t);
		
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int n = 0;
		while (times(plus(n, 1), plus(n, 1)) <= x) {
			n = plus(n, 1);
		}
		return n;
	}	  	  
}