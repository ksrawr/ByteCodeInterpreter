package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelCode extends ByteCode {
	
	public String label;
	public int addr;
	
	@Override
	public void execute(VirtualMachine virtualMachine) {
		
		
	}

	@Override
	public void init(String[] args) {
		label = args[0];
		
	}
	
	public String getAddrLabel() {
		return label;
	}
	
	public void setAddr(int addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("LABEL " + label + "\n");
	}
	
}
