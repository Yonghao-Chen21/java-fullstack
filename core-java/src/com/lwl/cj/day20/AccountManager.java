package com.lwl.cj.day20;

class C1 extends Exception {

}

class C2 extends C1 {

}

class C3 extends C2 {

}

class C4 extends Exception {

}

class One {

	void m1() throws C2 {

	}
}

class Two extends One {
	@Override
	void m1() throws C2 {

	}
}

class MaxCountException extends RuntimeException {
	public MaxCountException(String message) {
		super(message);
	}
}

class Account {

	int count = 0;

	public double getBalance() {
		count++;
		if (count > 3) {
			throw new MaxCountException("You have reached max number attempts");
		}
		return 9999;
	}
}

public class AccountManager {
	public static void main(String[] args) {

		Account acc = new Account();
		try {
			acc.getBalance();
			acc.getBalance();
			acc.getBalance();
			acc.getBalance();
		} catch (MaxCountException e) {
			e.printStackTrace();
		}
	}
}
