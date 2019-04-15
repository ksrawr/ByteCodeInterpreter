package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
	
	public int val;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		virtualMachine.load(val);
		
	}

	@Override
	public void init(String[] args) {
		val = Integer.parseInt(args[0]);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("LOAD " + val + "\n");
	}
	
}
