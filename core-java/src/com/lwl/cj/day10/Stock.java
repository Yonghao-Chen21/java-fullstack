package com.lwl.cj.day10;

import java.time.LocalDate;
import java.util.Objects;

public class Stock {
	
		private LocalDate date;
		private String code;
		private double price;
		private double actReturn;
		
		
		@Override
		public int hashCode() {
			return Objects.hash(actReturn, code, date, price);
		}

		@Override
		//equals(Object) overwrite: 1. == 2. if null 3. getCalss() 4. type casting to class 5. compare elements.
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Stock other = (Stock) obj;
			return Double.doubleToLongBits(actReturn) == Double.doubleToLongBits(other.actReturn)
					&& Objects.equals(code, other.code) && Objects.equals(date, other.date)
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
		}

		public Stock(LocalDate date, String code, double price, double actReturn) {
			super();
			this.date = date;
			this.code = code;
			this.price = price;
			this.actReturn = actReturn;
		}
		
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getActReturn() {
			return actReturn;
		}
		public void setActReturn(double actReturn) {
			this.actReturn = actReturn;
		}
		
		
		
}
