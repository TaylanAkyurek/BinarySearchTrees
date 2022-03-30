public class BinarySearchTree
{
    Node root;

    // Node structure containing the subtrees
	static class Node
	{
		// Your code here
    int item;
    Node left;
    Node right;

	};

    // Constructor
    public BinarySearchTree()
    {
        // Your code here
        this.root=null;
    }

    // Insert new item into the binary tree
    public void insert(int data)
    {
        // Your code here
        Node newNode = new Node();
        newNode.item = data;
        if(root==null){
        root=newNode;
        return;
        }
        Node temp=root;

        while(temp!=null){
          
          if(data==temp.item){
            return;
          }
          if(data<temp.item){
            if(temp.left==null){
              temp.left=newNode;
              return;
            }
            temp=temp.left;
            
          }
          if(data>temp.item){
            if(temp.right==null){
              temp.right=newNode;
              return;
            }
            temp=temp.right;

          }

        }
    }
    public int height(Node node){

      if(node==null){
        return -1;
      }
      else{
        return 1+Math.max(height(node.left),height(node.right));
      }

    }
public boolean checkBalanced(Node node,boolean a)
    {
        // Your code here

      if(node==null){
        return true;
      }  
      if(a==false){
        return false;
      }
      if(Math.abs(height(node.left)-height(node.right))>1){
        a=false;
      }
      if(checkBalanced(node.left,a)==false){
        return false;
      }
      if(checkBalanced(node.right,a)==false){
        return false;
      }
       return true;
    }
    // Check if the tree is balanced or not
    public boolean isBalanced()
    {
        // Your code here
      return checkBalanced(root, true);
    }

	
	// Remove an item from the tree
	public void remove(int item)
	{
		// Your code here
    Node temp=root;
    Node parent=root;
    while(temp!=null){
          if(temp.item==item){
            break;
          }
          
          if(item<temp.item){
            parent=temp;
            temp=temp.left;
            
          }
          if(temp==null){
          return;
        }
          if(item>temp.item){
           parent=temp;
            temp=temp.right;

          }
        }
         if(temp==null){
            return;
         }
         
        if(temp.right==null&&temp.left==null){
          if(parent.left!=null&&parent.left.item==temp.item){
            parent.left=null;
            temp=null;
            return;
          }
          if(parent.right!=null&&parent.right.item==temp.item){
            parent.right=null;
            temp=null;

            return;
          }
        }
        Node temp2=temp;    
       
       if(height(temp2)==1){
         temp2=temp2.left;
         temp.item=temp2.item;
         temp.left=null;
         temp2=null;
         return;
       }
        temp2=temp2.right;
        Node parent2=temp2;
        while(temp2.left!=null){
          parent2=temp2;
          temp2=temp2.left;
        }
        temp.item=temp2.item;
        if(temp2.right!=null){
          parent2.left=temp2.right;
        }
        else{
          parent2.left=null;
        }
        temp2=null;
	}
	
	// Compare two trees. Return true if both trees are same
	public boolean compareTo(BinarySearchTree tree)
	{
		// Your code here
        
		     return compareTrees(this.root, tree.root);

	}
  public boolean compareTrees(Node root1, Node root2){
 
    if(root1==null&&root2==null){
      return true;
    }
    if(root1==null&&root2!=null){
      return false;
    }
    if(root1!=null&&root2==null){
      return false;
    }

    if(compareTrees(root1.left,root2.left)==false || compareTrees(root1.right,root2.right)==false || root1.item!=root2.item){
        return false;
      }
      return true;

  }
	
	// Given function to print the tree
	public void printInOrder(Node node)
	{
		if (node != null)
		{
			printInOrder(node.left);
			System.out.print(node.item + " ");
			printInOrder(node.right);
		}
    }
}
