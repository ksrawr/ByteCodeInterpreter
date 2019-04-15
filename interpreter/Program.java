package interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import interpreter.ByteCodeLoader;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.CallCode;
import interpreter.bytecode.FalseBranchCode;
import interpreter.bytecode.GotoCode;
import interpreter.bytecode.LabelCode;

public class Program {

    private ArrayList<ByteCode> program;
	private HashMap<String, Integer> labels;

    public Program() {
        program = new ArrayList<>();
        labels = new HashMap<String, Integer>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    
    public void loadList(ArrayList<ByteCode> list) {
    	program = list;
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     * 
     * 
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
    	// Check if program contains an "instanceof" LABEL
    	for(int i = 0; i < program.size(); i++ ) {
    		if(program.get(i) instanceof LabelCode ) {
    			LabelCode l_code = (LabelCode)program.get(i);
    			labels.put(l_code.getAddrLabel(), i);
    		}
    	}
    	// Correct Addresses of all label like objects by fetching appropriate
    	// pc in labels
    	for(int i = 0; i < program.size(); i++) {
    		if(program.get(i) instanceof FalseBranchCode) {
    			FalseBranchCode fb_code = (FalseBranchCode)program.get(i);
    			fb_code.setAddr(labels.get(fb_code.getAddrLabel()));
    		}
    		if(program.get(i) instanceof GotoCode) {
    			GotoCode gt_code = (GotoCode)program.get(i);
    			gt_code.setAddr(labels.get(gt_code.getAddrLabel()));
    			
    		}
    		if(program.get(i) instanceof CallCode) {
    			CallCode cc_code = (CallCode)program.get(i);
    			cc_code.setAddr(labels.get(cc_code.getAddrLabel()));
    		}
    	}
    }




}
