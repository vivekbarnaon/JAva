//Build a BST
//values[] = {5,1,3,4,2,7}


public class Bst1 {
    static class Node{
        int data;
        Node left;
        Node right;

        //constructor
        Node (int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //left subtree
            root.left = insert(root.left,val);
        } else {
            root.right = insert(root.right,val);
        }
        return root;
    }

    // is a yes or no sorted array
    public static void inorder(Node root){
        //base case
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){ /// O(h)
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left,key);
        } else {
            return search(root.right,key);
        }
    }
    public static void main(String[] args){
        int values[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        Node root = null;

        // one by one traverse a arrays values
        // and every time insert a values in bst
        for(int i = 0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        // print a inorder traversal
        inorder(root);
        System.out.println();

        if(search(root,1)){
            System.out.println("found");
        } else {
            System.out.print("Not found");
        }
    }
}