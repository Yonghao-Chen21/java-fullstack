package com.lwl.cj.day14;

interface MathService{

		boolean isPrime(int num);
		default int[] generatePrime(int n) {
			
			return null;
		}
		
		default int countPrimeInRange(int lb,int ub) {
			//Logic 
			return 0;
		}
		
		//static method for interface is allowed and you don't need to add default
		public static int factorial(int num) {
			return 0;
		}
		
		static int sum(int... arr) {
			return 0;
		}
			
}

class MathServiceImpl implements MathService{

	@Override
	public boolean isPrime(int num) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
public class InterfaceMethods {

	
		public static void main(String[] args) {
			
				MathService obj = new MathServiceImpl();
				obj.isPrime(123);
				MathService.factorial(10); //static methods are not override, it calls the declared type.
				//extends a class or abstract class, you can call 
				//subclassclassname.staticmethodfromsupperclass, but not for interface.
				
		}
	

}
