package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
	
	public String operator;

	@Override
	public void execute(VirtualMachine virtualMachine) {
		int firstOprnd = virtualMachine.popRunStack();
		int secondOprnd = virtualMachine.popRunStack();
		
		// NOTE: do not be me and debug this for hours
		// and realize that you forgot the operands 
		// were switched... 
		switch ( operator ) {
		case "+":
            virtualMachine.pushRunStack(secondOprnd + firstOprnd);
            break;
        case "-":
            virtualMachine.pushRunStack(secondOprnd - firstOprnd);
            break;
        case "*":
            virtualMachine.pushRunStack(secondOprnd * firstOprnd);
            break;
        case "/":
            virtualMachine.pushRunStack(secondOprnd / firstOprnd);
            break;
        case "<":
            if (secondOprnd < firstOprnd) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
        case "<=":
            if (secondOprnd <= firstOprnd) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
        case ">":
            if (secondOprnd > firstOprnd) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
        case ">=":
            if (secondOprnd >= firstOprnd) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
        case "==":
            if (secondOprnd == firstOprnd) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
        case "!=":
            if (firstOprnd != secondOprnd) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
        case "|":
            if ((firstOprnd == 1) || (secondOprnd == 1)) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
        case "&":
            if ((firstOprnd == 1) && (secondOprnd == 1)) {
                virtualMachine.pushRunStack(1);
            } 
            else {
                virtualMachine.pushRunStack(0);
            }
            break;
		}
		
	}

	@Override
	public void init(String[] args) {
		operator = args[0];
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("BOP " + operator + "\n");
	}
	
}
