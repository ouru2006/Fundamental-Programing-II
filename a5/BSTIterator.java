import java.util.LinkedList;

/**
 * Ru Ou
 * V00835123
 * Assignment #5
 */

public class BSTIterator implements java.util.Iterator<WordRefs> {
    private BSTRefBased t;
    private WordRefs currentItem;
    private LinkedList<WordRefs> list;

	/**
	*set the BSTRefBased t
	*call the method setInorder()
	*/
    public BSTIterator(BSTRefBased t) {
        this.t = t;
        currentItem = null;
        list = new LinkedList<WordRefs>();
        setInorder();
    }

	/**
	*if the list is empty, then return false
	*else return ture
	*/
    public boolean hasNext() {
        return !list.isEmpty();
    }

	/**
	*set currentItem as the result called from remove
	*/
    public WordRefs next() throws java.util.NoSuchElementException {
        currentItem=list.remove();
        return currentItem;
    }

	/**
	*throw UnsupportedOperationException
	*/
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

	/**
	*clear the list
	*then call the preorder() methode for t
	*/
    public void setPreorder() {
        list.clear();
        preorder(t.getRoot());
    }

	/**
	*clear the list
	*then call the inorder() methode for t
	*/
    public void setInorder() {
        list.clear();
        inorder(t.getRoot());
    }

	/**
	*clear the list
	*then call the postorder() methode for t
	*/
    public void setPostorder() {
    	list.clear();
        postorder(t.getRoot());
    }

	/**
	*if the node is not empty
	*recursive method to add root, left item, and right item into list
	*/
    private void preorder(TreeNode node) {
    	if(node!=null){
    		list.add(node.item);
    		preorder(node.left);
    		preorder(node.right);
    	}
    }

	/**
	*if the node is not empty
	*recursive method to add left item,root,right item into list
	*/
    private void inorder(TreeNode node) {
    	if (node != null) {
            inorder(node.left);
            list.add(node.item);
            inorder(node.right);
        }
    }

	/**
	*if the node is not empty
	*recursive method to add left item,right item, root into list
	*/
    private void postorder(TreeNode node) {
    	if (node != null) {
            postorder(node.left);
            postorder(node.right);
            list.add(node.item);
        }
    }
}
