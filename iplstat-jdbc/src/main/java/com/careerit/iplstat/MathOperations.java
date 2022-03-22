package com.careerit.iplstat;

import java.util.ArrayList;
import java.util.List;

public class MathOperations {

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public int[] getPrimes(int lb, int ub) {
		List<Integer> rs = new ArrayList<>();
		for (int i = lb; i < ub; i++) {
			if (i > 1 && i < 4) {
				rs.add(i);
			} else if (i >= 4) {
				boolean flag = true;
				for (int n = 2; n <= i / 2; n++) {
					if (i % n == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					rs.add(i);
				}
			}
		}
		return rs.stream().mapToInt(i->i).toArray();
	}

	public int max(int a, int b, int c) {
		return max(max(a, b), c);
	}

	public int reverse(int num) {
		int rs = 0;
		while (num != 0) {
			rs = rs * 10 + num % 10;
			num = num / 10;
		}
		return rs;
	}
}
