package interpreter;

import java.util.Stack;

import interpreter.bytecode.ByteCode;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping;
    //private int dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    // executeProgram() generated to fix error on Interpreter.java
    // Interpreter void run()
	public void executeProgram() {
		// Note: we increment pc(program_code) +1 after every 
		// ByteCode is executed meaning CALLS, FALSEBRANCHES,
		// and GOTO should go to 1 offset before their desired pc
		pc = 0;
		runStack = new RunTimeStack();
		returnAddrs = new Stack<Integer>();
		isRunning = true;
		isDumping = true;
		while(isRunning){
			ByteCode code = program.getCode(pc);
			code.execute(this);
			//runTimeStack.dump(); // Used to dump runstack state.
			if(isDumping) {
				System.out.print(code.toString());
				runStack.dump();
			}
			pc++;
		}
	}
	
	// Execute ByteCode Program VM Functions (e.g. "STORE", "LOAD",...)
	// Note: You may have to use methods from the RuneTimeStack in order
	// to complete these VM methods. 
	public void halt() {
		isRunning = false;
	}
	
	public int popRunStack() {
		return runStack.pop();
	}
	
	public int storeRunStack(int offset) {
		return runStack.store(offset);
	}
	
	public int pushRunStack(int i) {
		return runStack.push(i);
	}
	
	public void LIT(int v) {
		runStack.push(v);
	}
	
	public void newFrame(int offset) {
		runStack.newFrameAt(offset);
	}
	
	public void popFrame() {
		runStack.popFrame();
	}
	
	public void load(int v) {
		runStack.load(v);
	}
	
	public int peekRunStack() {
		return runStack.peek();
	}
	
	public int popReturnAddr() {
		return returnAddrs.pop();
	}
	
	public int pushReturnAddr(int pos) {
		return returnAddrs.push(pos);
	}
	public void setPC(int addr) {
		this.pc = addr;
	}
	
	public int getPC() {
		return pc;
	}
	public void setDump(boolean isDumping) {
		this.isDumping = isDumping;
	}
}
