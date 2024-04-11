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
		 * Traverses the binary search tree (BST) using pre-order (node, left, right)
		 * @param root The node from which the rest of the tree will be traversed
		 */
		public void preOrderTraversal(Node root){
			if (root != null) {
				System.out.print(root.value + " ");
				preOrderTraversal(root.left);
				preOrderTraversal(root.right);
			}
		}


		/**
		 * Traverses the BST using in-order traversal (left, node, right)
		 * @param root The node from which the rest of the BST will be traversed
		 */
		public void inOrderTraversal(Node root){
			if(root != null){
				inOrderTraversal(root.left);
				System.out.println(root.value + " ");
				inOrderTraversal(root.right);
			}
	   }


		/**
		 * Traverses the BST using in post-order traversal (left, right, node)
		 * @param root the node from which the rest of the BST will be traversed
		 */
		public void postOrderTraversal(Node root){
			if (root != null) {
				postOrderTraversal(root.left);
				postOrderTraversal(root.right);
				System.out.print(root.value + " ");
			}
	   }

		/**
		 * Finds a value in the BST
		 * @param root The node to start traversing
		 * @param key The value to find in the tree
		 * @return A boolean that represents if the value was found
		 */
	   public boolean find(Node root, int key){
			if(root == null){ // if root is null, the value has not been found
				return false;
			}
			if(root.value == key){
				return true;
			} else if(key < root.value){
				return find(root.left, key);
			} else {
				return find(root.right, key);
			} // in-order traversal
	   }

		/**
		 *
		 * @param root
		 * @return
		 */
		public int getMin(Node root){

	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){

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



	public class TreeDemo{
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
