package exercises.chapter4;

public class JTreeNode<T> {
    
	private T mValue;
    private JTreeNode<T> mLeft;
    private JTreeNode<T> mRight;

    public JTreeNode(T value) {
        mValue = value;
    }
    
    public T getValue() {
    	return mValue;
    }

    public JTreeNode<T> getLeftChild() {
        return mLeft;
    }

    public void setLeftChild(JTreeNode<T> leftChild) {
        mLeft = leftChild;
    }

    public JTreeNode<T> getRightChild() {
        return mRight;
    }

    public void setRightChild(JTreeNode<T> rightChild) {
        mRight = rightChild;
    }

}