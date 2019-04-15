package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack; // NOTE: THIS IS THE STACK!!!
    private Stack<Integer> framePointer; 

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
    	/**
    	 * Void function used to dump the current stack of the 
    	 * RuntimeStack. When printing the runtime stack make sure
    	 * to include divisions between frames. If a frame is
    	 * empty, this must be shown as well.
    	 */
    	// Print all the elements that are cleaned up on the
    	// framePointer stack and runTimeStack.
    	// Note: Iterate size() - 1 or else ArrayOutOfBounds
    	for(int i = 0; i < framePointer.size() - 1; i++){
            System.out.print("[");
            for(int j = framePointer.get(i); j < framePointer.get(j++) - 1; j++){
            	if(runTimeStack.size() > 0) {
            		System.out.print(runTimeStack.get(j) + ",");
            	} 
            }
            if(runTimeStack.size() > 0) {
                System.out.print(runTimeStack.get(framePointer.get(i)) + "]");
            } else {
            	System.out.print("]");
            }
        }
        System.out.print("[");
        for(int i = framePointer.lastElement(); i < runTimeStack.size() - 1; i++){
                System.out.print(runTimeStack.get(i) + ",");
        }
        if(runTimeStack.size() > 0) {
        	System.out.print(runTimeStack.get(runTimeStack.size() - 1) + "]\n");
        } else {
        	System.out.print("]\n");
        }
    }
    
    public int peek() {
    	return runTimeStack.get(runTimeStack.size() - 1);
    }
    
    public int pop() {
    	//INVALID: 
    	//"return runTimeStack.remove(runTimeStack.size() - 1 );
    	//when cleaning up the runTimeStack after returning, we cannot pop
    	//if nothing is there.
    	if(runTimeStack.size() > 0) {
    		return runTimeStack.remove(runTimeStack.size() - 1 );
    	}
    	return 0;
    }
    
    public int push( int i ) {
    	runTimeStack.add(i);
    	return i;
    }
    
    public void newFrameAt(int offset) {
    	/**
    	 * creates a new frame in the RuntimeStack class. The
    	 * parameter offset used to denote how many slots down
    	 * from the top of RuntimeStack for starting a new frame.
    	 */
    	//ERROR: Need to to validate before pushing on framePointer
    	//cannot simply "framePointer.push(runTimeStack.size() - offset);"
    	
    	if(runTimeStack.size() - offset != framePointer.lastElement()) {
    		framePointer.push(runTimeStack.size() - offset);
    	}
    }
    
    public void popFrame() {
    	/**
    	 * we pop the top frame when we return from a function.
    	 * Before popping, the function�s return value is at the
    	 * top of the stack, so we�ll save the value, the pop the
    	 * top frame and then push the return value back to the
    	 * stack. It is assumed return values are at the top of
    	 * the stack.
    	 */
    	// Keeps throwing exception error on ArrayIndexBounds
    	
    	int topValue = runTimeStack.get(runTimeStack.size() - 1);
    	int frameLocation = 0;
    	int top = (runTimeStack.size()-1);
    	    	
    	// Check before popping 
    	if( framePointer.peek() != 0) {  
    		frameLocation = framePointer.pop();
    	}
    	// Clean up all pushed arguments and inputs
    	for(int i = top; i >= frameLocation; i--){
    		runTimeStack.remove(i);
    	}
    	
    	runTimeStack.add(topValue);
    }
    
    public int store(int offset) {
    	/**
    	 * Used to store values into variables. Store will pop the
    	 * top value of the stack and replace the value at the
    	 * given offset in the current frame. The value stored is
    	 * returned.
    	 */
    	
    	int value = runTimeStack.remove(runTimeStack.size() - 1);
    	// INVALID: runTimeStack.add(offset);
    	// use ArrayList method: set to replace at index .set(index, e);
    	// Note: framePointer.peek() is the current frame
    	runTimeStack.set(offset + framePointer.peek(), value);
    	return value;
    }
    
    public int load(int offset) {
    	/**
    	 * Used to load variables onto the RuntimeStack from a
    	 * given offset within the current frame. This means we
    	 * will go to the offset in the current frame, copy the
    	 * value and push it to the top of the stack. No values
    	 * should be removed with loads.
    	 */	
    	
    	// Copy value of offset in the current frame and push it to the top
    	runTimeStack.add(runTimeStack.get(offset + framePointer.peek()));
    	return runTimeStack.get(offset + framePointer.peek());
    }
    
    public Integer push(Integer val) {
    	/**
    	 * Used to load liters onto the RuntimeStack. For example,
    	 * LIT 5 or LIT 0 will call push with val being 5 or val
    	 * being 0.
    	 */
    	runTimeStack.add(val);
    	return val;
    }
}
