package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {

	@Override
	public void execute(VirtualMachine virtualMachine) {
		
		virtualMachine.halt();
	}

	@Override
	public void init(String[] args) {
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("HALT \n");
	}
	
}
