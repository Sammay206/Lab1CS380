class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
       *A method to print out the binary tree in pre-order
       *@param The root Node of a binary tree
       */
	   public void preOrderTraversal(Node root){
		if(root == null){
         return;
      }
      
      //print current node value
      System.out.print(root.value);
      
      //traverse left subtree
      preOrderTraversal(root.left);
      
      //traverse right subtree
      preOrderTraversal(root.right);
		   
	   }

	   
	   
	   /**
       *A method to print out the binary tree in-order
       *@param The root Node of a binary tree
       */
	   public void inOrderTraversal(Node root){
	      if(root == null){
            return;
         }
         
         //traverse left subtree
         inOrderTraversal(root.left);
         
         //print current node value
         System.out.print(root.value + " ");
         
         //traverse right subtree
         inOrderTraversal(root.right);
	   }
	   
	   
	   
	   /**
       *A method to print out the binary tree post-order
       *@param The root Node of a binary tree
       */
	  
	   public void postOrderTraversal(Node root){
         if(root == null){
            return;
         }
         
         //traverse left subtree
         postOrderTraversal(root.left);
         
         //traverse right subtree
         postOrderTraversal(root.right);
         
         //print current node value
         System.out.print(root.value + " ");
		   
	   }
	   
	   
	   
	   /**
       *A method to find a node in the tree
       *@param The root Node of a binary tree, the value of a node to find
       *@return a boolean true if the node is found in the tree
       */
	   public boolean find(Node root, int key){
         if(root.value == key) return true;
         if(root.value < key){
            if(root.right == null) return false;
            return find(root.right, key);
         }
         if(root.value > key){
            if(root.left == null) return false;
            return find(root.left, key);
         }
         return false;
         
	   }
	   
	   
	   
	   /**
       *A method to find the smallest node in the tree
       *@param The root Node of a binary tree
       *@return the value of the smallest node in the tree
       */
	   public int getMin(Node root){
         while(root.left != null){
            root = root.left;
	      }
         
         return root.value;

	      
	   }
	  
	  
	  
	   /**
       *A method to find the largest node in the tree
       *@param The root Node of a binary tree
       *@return the value of the largest node in the tree
       */
	   public int getMax(Node root){
         while(root.right != null){
            root = root.right;
	      }
         
         return root.value;
      }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
