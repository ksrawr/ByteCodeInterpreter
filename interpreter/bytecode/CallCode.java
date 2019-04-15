package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends ByteCode {
	public String label;
	public int addr;
	
	@Override
	public void execute(VirtualMachine virtualMachine) {
		virtualMachine.pushReturnAddr(virtualMachine.getPC());
		// Note: (addr - 1) to correct current bytecode execution
		virtualMachine.setPC(addr - 1);
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
		return ("CALL " + label + "\n");
	}
}
