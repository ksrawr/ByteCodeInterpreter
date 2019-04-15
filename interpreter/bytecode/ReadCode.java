package interpreter.bytecode;

import java.util.Scanner;

import interpreter.VirtualMachine;

public class ReadCode extends ByteCode {
	
	public boolean checkNumber = true;
	public int n;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		/*while(checkNumber) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Please enter a number: ");
				n = sc.nextInt();
			}
			catch (InputMismatchException e ){
				System.out.println("Invalid input. Try again");
			}
			checkNumber = false;
		}
		virtualMachine.pushRunStack(n);*/
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		n = sc.nextInt();
		virtualMachine.pushRunStack(n);
	}

	@Override
	public void init(String[] args) {
		// We ask user for so need for intialization
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("READ " + n + "\n");
	}
	
}
