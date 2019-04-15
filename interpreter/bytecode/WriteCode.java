package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {

	@Override
	public void execute(VirtualMachine virtualMachine) {
		System.out.println(virtualMachine.peekRunStack());
		
	}

	@Override
	public void init(String[] args) {
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("WRITE \n");
	}
	
}
