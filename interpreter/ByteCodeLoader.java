
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import interpreter.bytecode.ByteCode;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    //private Program program; (IS THIS IS A TYPO?????)
    private ArrayList<ByteCode> program; 

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        program = new ArrayList<ByteCode>();
        		
        String line = "";
        
        // Read each line via method .readLine()
        while ((( line = this.byteSource.readLine() )) != null ) {
        	StringTokenizer tokenizer = new StringTokenizer(line);
        	String byteCodeClass = CodeTable.getClassName(tokenizer.nextToken());
        	
        	String[] byteCodeArgs = new String[ tokenizer.countTokens() ];
        	
        	int i = 0;
        	while( tokenizer.hasMoreTokens() ) {
        		byteCodeArgs[i] = tokenizer.nextToken();
        		//System.out.println(tokenizer.nextToken());
        		i++;
        	}
        	
        	try {
        		ByteCode bytecode = (ByteCode)(Class.forName("interpreter.bytecode."+byteCodeClass).getDeclaredConstructor().newInstance()); 
        		bytecode.init(byteCodeArgs);
        		
        		program.add(bytecode);
        	}
        	catch (Exception e) {
        		System.out.println("~***~ " + e );
        	}
        }
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
    	Program prog = new Program();
    	prog.loadList(program);
    	prog.resolveAddrs();
    	
       return prog;
    }
}
