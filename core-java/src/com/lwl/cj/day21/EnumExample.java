package com.lwl.cj.day21;

enum Day{
	SUNDAY(7), MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6);
   
	private int num;

	private Day(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
}

class EnumTest {
    Day day;
    
    public EnumTest(Day day) {
        this.day = day;
    }
    
    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
}
public class EnumExample {
	
	public static void main(String[] args) {
		
			EnumTest obj1 = new EnumTest(Day.THURSDAY);
			obj1.tellItLikeItIs();
			
			for(Day d:Day.values()) {
				System.out.println(d.getNum()+". "+d);
			}
		
	}
}
