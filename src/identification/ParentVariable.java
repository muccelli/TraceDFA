
package identification;

import cnf.Variable;
import automata.DFABuilder;


/**
 * This boolean variable represents a parent relation.
 * It is true if, for any vertex with color i, the child reached by label a
 * has color j. Variable y with three subscripts (a,i,j).
 */
public class ParentVariable
		extends EncodingVariable {


	// >>> Fields

	private final String label;  // a
	private final int parentId;  // i
	private final int childId;   // j


	// >>> Public functions
	
	/**
	 * Constructor
	 * @param label The label of an arc
	 * @param parentId The numeric id of the parent vertex
	 * @param childId The numeric id of the child vertex
	 * @param val The boolean value
	 */
	public ParentVariable(String label, int parentId, int childId, boolean val) {
		super("y_" + label + "," + Integer.toString(parentId) + "," +
				Integer.toString(childId), val);
		this.label = label;
		this.parentId = parentId;
		this.childId = childId;
	}


	/**
	 * Constructor
	 * @param label The label of an arc
	 * @param parentId The numeric id of the parent vertex
	 * @param childId The numeric id of the child vertex
	 */
	public ParentVariable(String label, int parentId, int childId) {
		this(label, parentId, childId, false);
	}


	/**
	 * Add an arc to the DFA if this variable is true.
	 * @param dfa A partial DFA
	 */
	@Override
	public void actionOnDFA(DFABuilder<String> dfa) { 
		dfa.newArc(parentId, label, childId);
	}
}
