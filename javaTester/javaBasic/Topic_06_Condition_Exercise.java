package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	
	
	public void TC_01() {
		int number = scanner.nextInt();
		
		if (number % 2 == 0) {
			System.out.println("Số: " + number + " là số chẵn");
		} else {
			System.out.println("Số: " + number + " là số lẻ");
		}
				
	}
	
	
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA > numberB) {
			System.out.println(numberA + " lớn hơn " + numberB);
		} else if (numberA < numberB) {
			System.out.println(numberA + " nhỏ hơn " + numberB);
		}else {
			System.out.println(numberA + " bằng " + numberB);
		}
	}
	
	public void TC_03() {
		
	}
	
	@Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA >numberC) {
			System.out.println(numberA + " là số lớn nhất");
		} else if (numberB > numberC){
			System.out.println(numberB + " là số lớn nhất");
		} else {
			System.out.println(numberC + " là số lớn nhất");
		}
	}
}
















































