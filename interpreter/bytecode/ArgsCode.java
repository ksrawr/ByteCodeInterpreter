package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
	
	public int arg;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		virtualMachine.newFrame(arg);
	}

	@Override
	public void init(String[] args) {
		arg = Integer.parseInt(args[0]);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("ARGS " + arg + "\n");
	}

	
}
