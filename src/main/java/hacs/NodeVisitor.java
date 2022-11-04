package hacs;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

abstract public class NodeVisitor {
	public NodeVisitor() {
	}
	public NodeVisitor(Object visitee) {
	}
	abstract public void visitFacade(Facade facade);

	abstract public void visitCourse(Course course);

	abstract public void visitAssignment(Assignment assignment);

}