package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
	
	public String label;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		if(label == null) {
			virtualMachine.setPC(virtualMachine.popReturnAddr());
		} 
		else {
			virtualMachine.setPC(virtualMachine.popReturnAddr());
		}
		virtualMachine.popFrame();
	}

	@Override
	public void init(String[] args) {
		// Sometimes there are no arguments when we parse the token
		if(args.length > 0) {
			label = args[0];
		}
		else {
			label = null;
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("RETURN " + label + "\n");
	}
	
}
