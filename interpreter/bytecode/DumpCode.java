package interpreter.bytecode;

import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
	
	public boolean isDumping;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		virtualMachine.setDump(isDumping);
	}

	@Override
	public void init(String[] args) {
		if(args[0].equals("ON")) {
			isDumping = true;
		}
		else {
			isDumping = false;
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return ("DUMP " + n + "\n");
		return null;
	}
	
}
