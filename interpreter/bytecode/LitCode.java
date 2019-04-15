package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
	
	public int val;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		virtualMachine.LIT(val);
	}

	@Override
	public void init(String[] args) {
		val = Integer.parseInt(args[0]);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("LIT " + val + "\n");
	}
	
}