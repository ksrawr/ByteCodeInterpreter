package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
	
	public int n;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		//Pop n times
		for(int i = 0; i < n; i++) {
			virtualMachine.popRunStack();
		}
	}

	@Override
	public void init(String[] args) {
		n = Integer.parseInt(args[0]);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("POP " + n + "\n");
	}
	
}
