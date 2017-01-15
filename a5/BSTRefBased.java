import java.util.Iterator;
/**
 * Ru Ou
 * V00835123
 * Assignment #5
 */
public class BSTRefBased extends AbstractBinaryTree 
    implements Iterable<WordRefs>
{
    private TreeNode root;

	/**
	*set the root as null
	*/
    public BSTRefBased() {
        root = null;
    }

	/**
	*set left and right child of root,
	*which call the method attachLeftSubtree()
	*/
    public BSTRefBased(WordRefs item,
        AbstractBinaryTree left,
        AbstractBinaryTree right)
    {
        root = new TreeNode(item, null, null);
        if (left != null) {
            attachLeftSubtree(left);
        }

        if (right != null) {
            attachRightSubtree(right);
        }
    }

	/**
	*check if the root is empty
	*if it is empty, then return true
	*else return false
	*/
    public boolean isEmpty() {
        return (root == null);
    }

	/**
	*empty the root
	*/
    public void makeEmpty() {
        root = null;
    }

	/**
	*output the root
	*/
    protected TreeNode getRoot() {
        return root;
    }

	/**
	*set the root as the input node
	*/
    protected void setRoot(TreeNode r) {
        this.root = r;
    }

	/**
	*get the root's item
	*if the root is empty,then throw exception
	*/
    public WordRefs getRootItem() throws TreeException {
        if (root == null) {
            throw new TreeException("getRootItem() on empty tree");
        }

        return root.item;
    }

	/**
	*if the root is empty, set a new node with the input item
	*else set the root's item as the input item
	*/
    public void setRootItem(WordRefs item) {
        if (root == null) {
            root = new TreeNode(item);
        } else {
            root.item = item;
        }
    }

	/**
	*if the root is empty,then throw Exception
	*if it is not empty and root's left child is not empty,
	*then throw Exception
	*set the input item into root's left child 
	*/
    public void attachLeft(WordRefs item) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("attachLeft to empty tree");
        }

        if (!isEmpty() && root.left != null) {
            throw new TreeException("attachLeft to occupied left child");
        }

        root.left = new TreeNode(item, null, null);

        return;
    } 

	/**
	*if the root is empty,then throw Exception
	*if it is not empty and root's left child is not empty,
	*then throw Exception
	*set the input root into root's left child 
	*empty the input tree
	*/
    public void attachLeftSubtree(AbstractBinaryTree left) {
        if (isEmpty()) {
            throw new TreeException("attachLeftSubtree to empty tree");
        }

        if (!isEmpty() && root.left != null) {
            throw new 
                TreeException("attachLeftSubtree to occupied right child");
        }

        root.left = left.getRoot();
        left.makeEmpty();

        return;    
    }

	/**
	*if the root is empty,then throw Exception
	*if it is not empty and root's right child is not empty,
	*then throw Exception
	*set the input item into root's right child 
	*/
    public void attachRight(WordRefs item) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("attachRight to empty tree");
        }

        if (!isEmpty() && root.right != null) {
            throw new TreeException("attachRight to occupied right child");
        }

        root.right = new TreeNode(item, null, null);

        return;
    } 

	/**
	*if the root is empty,then throw Exception
	*if it is not empty and root's right child is not empty,
	*then throw Exception
	*set the input root into root's right child 
	*empty the input tree
	*/
    public void attachRightSubtree(AbstractBinaryTree right) {
        if (isEmpty()) {
            throw new TreeException("attachRightSubtree to empty tree");
        }

        if (!isEmpty() && root.right != null) {
            throw new 
                TreeException("attachRightSubtree to occupied right child");
        }

        root.right = right.getRoot();
        right.makeEmpty();

        return;
    }

	/**
	*if root is empty, throw Exception
	*return the root's left child and then empty it
	*/
    public AbstractBinaryTree detachLeftSubtree()
        throws TreeException 
    {
        if (root == null) {
            throw new TreeException("detachLeftSubtree on empty tree");
        }

        BSTRefBased result = new BSTRefBased();
        result.setRoot(root.left);
        root.left = null;

        return result;
    }

	/**
	*if root is empty, throw Exception
	*return the root's right child and then empty it
	*/
    public AbstractBinaryTree detachRightSubtree()
        throws TreeException
    {
        if (root == null) {
            throw new TreeException("detachLeftSubtree on empty tree");
        }

        BSTRefBased result = new BSTRefBased();
        result.setRoot(root.right);
        root.right = null;

        return result;
    }

	/**
	*a method inputs the word and calls insertItem(root,word)method
	*/
    public void insert(String word) {
    	root=insertItem(root,word);

    }

	/**
	*a recursive method
	*if the root is empty, add the word and return it
	*if the root item is larger than the word,then come to left subside
	*if the root item is less than the word,then come to right subside
	*/
    protected TreeNode insertItem(TreeNode r, String word) {
    	//the base
    	if(r==null){
    		return new TreeNode(new WordRefs(word));
    	}else
    	//recursion
    	if(r.item.getWord().compareTo(word)>0){
    		r.left= insertItem(r.left,word);
    	}else{
    		r.right= insertItem(r.right,word);
    	}
       	return r;
    }

	/**
	*a method inputs the word and calls retrieveItem(TreeNode r, String word)
	*to find the place
	*if the word is not in the node or root is empty,then return null
	*else return the wordrefs
	*/
    public WordRefs retrieve(String word) {
    	if(root==null){
    		return null;
    	}
    	TreeNode result=retrieveItem(root,word);
    	if(!result.item.getWord().equals(word)){
        	return null;
        }else{
        	return result.item;
        }
    }

	/**
	*a recursive method
	*if find the position or cannot find the word in the node, then return current root
	*if the word is large less than the root.item.word, then come to left subside
	*else come to right subside
	*/
    protected TreeNode retrieveItem(TreeNode r, String word) {
    	//the base
    	if(r.item.getWord().compareTo(word)==0){
    		return r;
    	}else 
    	//recursion
    	if(r.item.getWord().compareTo(word)>0){
    		if(r.left==null)
    			return r;
    		return  retrieveItem(r.left,word);
    	}else{
    		if(r.right==null)
    			return r;
    		return  retrieveItem(r.right,word);
    	}
       	
      
    }

	/**
	*a method calls deleteItem(TreeNode r, String word)
	*to delete words
	*/
    public void delete(String word) {
    	while(retrieve(word)!=null){
    		root=deleteItem(root, word);
		}
    }

	/**
	*a recursive method 
	*if find the item and the item is base, then delete directly
	*else call the method deleteNode(r)
	*if the word is large less than the root.item.word, then come to left subside
	*else come to right subside
	*/
    protected TreeNode deleteItem(TreeNode r, String word) {
        //the base
    	if(r.item.getWord().compareTo(word)==0){
    		
    		TreeNode newRoot=deleteNode(r);
    		return newRoot;
    		
    	}else
    	//recursion
    	if(r.item.getWord().compareTo(word)>0){
    		
    		TreeNode newLeft= deleteItem(r.left,word);
    		r.left=newLeft;
    	}else{
    		
    		TreeNode newRight= deleteItem(r.right,word);
    		r.right=newRight;
    	}
       	return r;
    }

	 

    /**
    *a method to delete the word if the word is root
    *from textbool p.610-612
    */
    protected TreeNode deleteNode(TreeNode node) {
    	
    	if(node.left==null&&node.right==null){
    		return null;
    	}else if(node.left==null^node.right==null){
    		if(node.right==null){
    			return node.left;
    		}else{
    			return node.right;
    		}
    	}else{
    		TreeNode temp=node.left;
    		TreeNode replacementItem=findLeftMost(node.right);
    		TreeNode replacementRChild=deleteLeftMost(node.right);
    		node=replacementItem;
    		node.right=replacementRChild;  
    		node.left=temp; 		
    		return node;
    	}
    }
	
	
	/**
	*a method to find the left most item 
	*a recursive method
	*/
    protected TreeNode findLeftMost(TreeNode node) {
    	
    	//base
    	if(node.left==null){
    		return node;
    	}else{
    		//recursion
    		return findLeftMost(node.left);
    	}     
    }

	/**
	*a method to find the left most item and delete it
	*a recursive method
	*/
    protected TreeNode deleteLeftMost(TreeNode node) {
    	
    	if(node.left==null){
    		return node.right;
    		
    	}else{
    		//recursion
    		TreeNode temp= deleteLeftMost(node.left);
    		node.left=temp;
    		return node;
    	}
        
    }

	/**
	*input the this tree into class BSTIterator
	*then return the Iterator<WordRefs> result
	*/
    public Iterator<WordRefs> iterator() {
        return new BSTIterator(this);
    }


    public static void main(String args[]) {
        BSTRefBased t;
        AbstractBinaryTree tt;
        int i;
        boolean result;
        String message;

        message = "Test 1: inserting 'humpty' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            result = t.getRootItem().getWord().equals("humpty");
        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));

        message = "Test 2: inserting 'humpty', 'dumpty', 'sat' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            
            result = t.getRootItem().getWord().equals("humpty");
            tt = t.detachLeftSubtree();
            result &= tt.getRootItem().getWord().equals("dumpty");
            tt = t.detachRightSubtree();
            result &= tt.getRootItem().getWord().equals("sat");

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        message = "Test 3: retrieve 'sat' -- ";
        t = new BSTRefBased();
        try {
        	t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            
            result = t.retrieve("sat").getWord().equals("sat");
            

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        message = "Test 4: retrieve a word that does not in the node -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            result = t.retrieve("a")==null;
            

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        message = "Test 5: delete 'sat' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            t.delete("sat");
            result = t.retrieve("sat")==null;
            

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        message = "Test 6: delete 'sat' and 'dumpty' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            t.delete("sat");
            t.delete("dumpty");
            result = t.retrieve("sat")==null;
            result&= t.retrieve("dumpty")==null;

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        message = "Test 7: delete the root -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            t.delete("humpty");
            result = t.retrieve("humpty")==null;

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        message = "Test 8: delete 'a' -- ";
        t = new BSTRefBased();
        try {;
            t.insert("humpty");
            t.insert("a");
            t.insert("dumpty");
            t.insert("sat");
            t.delete("humpty");
            t.delete("a");
            result = t.retrieve("humpty")==null;
            result &= t.retrieve("a")==null;

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        
        message = "Test 9: general test -- ";
        t = new BSTRefBased();
        try {
            t.insert("Shall");
            t.insert("i");
            t.insert("compare");
            t.insert("thee");
            t.insert("to");
            t.insert("a");
            t.insert("summer's");
            t.insert("day");
            t.insert("art");
            t.insert("more");
            t.insert("lovely");
            t.insert("and");
            t.insert("more");
            t.insert("temperate");
            t.insert("rough");
            t.insert("winds");
            t.insert("do");
            t.insert("shake");
            t.insert("the");
            t.insert("darling");
            t.insert("buds");
            t.insert("of");
            t.insert("may");
            t.insert("and");
            t.insert("summer's");
            t.insert("lease");
            t.insert("hath");
            t.insert("all");
            t.insert("too");
            t.insert("short");
            t.insert("a");
            t.insert("date");
            t.insert("sometime");
            t.insert("too");
            t.insert("hot");
            t.insert("the");
            t.insert("eye");
            t.insert("of");

			t.delete("a");
            t.delete("the");
            t.delete("i");
            t.delete("it");
            t.delete("is");
     

            result =t.retrieve("Shall")!=null;
            result &=t.retrieve("i")==null;
            result &=t.retrieve("compare")!=null;
            result &=t.retrieve("thee")!=null;
            
            result &= t.retrieve("to")!=null;
            
            result &=t.retrieve("a")==null;
            result &=t.retrieve("summer's")!=null;
            result &=t.retrieve("day")!=null;
            result &=t.retrieve("art")!=null;
            result &=t.retrieve("more")!=null;
            result &=t.retrieve("lovely")!=null;
            result &=t.retrieve("and")!=null;
            result &=t.retrieve("more")!=null;
            result &=t.retrieve("temperate")!=null;
            result &=t.retrieve("rough")!=null;
            result &=t.retrieve("winds")!=null;
            result &=t.retrieve("do")!=null;
            result &=t.retrieve("shake")!=null;
            result &=t.retrieve("darling")!=null;
            result &=t.retrieve("buds")!=null;
            result &=t.retrieve("of")!=null;
            result &=t.retrieve("may")!=null;
            result &=t.retrieve("and")!=null;
            result &=t.retrieve("summer's")!=null;
            result &=t.retrieve("lease")!=null;
            result &=t.retrieve("hath")!=null;
            result &=t.retrieve("all")!=null;
            result &=t.retrieve("too")!=null;
            result &=t.retrieve("short")!=null;
            result &=t.retrieve("date")!=null;
            result &=t.retrieve("sometime")!=null;
            result &=t.retrieve("too")!=null;
            result &=t.retrieve("hot")!=null;
            result &=t.retrieve("the")==null;

        } catch (Exception e) {
            result = false;
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
    }
} 
