package tui;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuickMathUI {

	public static int random(final int min, final int max) {
		final Random random = new Random();
		final int n = Math.abs((max + 1) - min);
		return Math.min(max, max) + (n == 0 ? 0 : random.nextInt(n));
	}

	public static void main(String[] args) {
		boolean isRunning = true;
		while(isRunning) {
			doMath();
		}

	}
	
	private static void doMath() {
		int random1 = getGenerateNumber();
		int random2 = getGenerateNumber();
		String operation = getGenerateOperation();

		String question = getGenerateQuestion(random1, operation, random2);
		int right = getRightMath(random1, operation, random2);
		
		System.out.println(question);
		Scanner s = new Scanner(System.in);

		int answer = registerInput();
		if (answer == right) {
			System.out.println("\f");
			System.out.println("Correct!");
		}else {
			System.out.println("Wrong!");
		}
	}
	
	/**
	 * Gets user input as an integer
	 */
	private static int registerInput() {
		Scanner keyboard = new Scanner(System.in);
		while (!keyboard.hasNextInt()) {
			System.out.println("Input skal være et tal - prøv igen");
			keyboard.nextLine();
		}
		return keyboard.nextInt();

	}

	private static String getGenerateQuestion(int random1, String operation, int random2) {
		String question = null;
		question = random1 + operation + random2;

		return question;
	}
	
	private static int getRightMath(int random1, String operation, int random2) {
		int temp = 0;
		
		if (operation.equals("*")) {
			temp = random1 * random2;
		} else if (operation.equals("/")) {
			temp = random1 / random2;
		} else if (operation.equals("-")) {
			temp = random1 - random2;
		} else if (operation.equals("+")) {
			temp = random1 + random2;
		}
		
		return temp;
	}
	
	private static String getGenerateOperation() {
		Random random = new Random();
		String operation = null;
		String[] ops = new String[] { "*", "/", "-", "+" };
		operation = ops[random.nextInt(ops.length)];

		return operation;
	}

	private static int getGenerateNumber() {
		int temp = 0;
		temp = QuickMathUI.random(-12, 12); // Randomize number from -12 to 12
		return temp;
	}

}
