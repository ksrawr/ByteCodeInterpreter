package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
	
	public int offset;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		virtualMachine.storeRunStack(offset);
		
	}

	@Override
	public void init(String[] args) {
		offset = Integer.parseInt(args[0]);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("STORE " + offset + "\n");
	}
	
}
