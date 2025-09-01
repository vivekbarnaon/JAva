// Build a BST
// values[] = {5,1,3,4,2,7}
import java.util.*;
public class Bst1 {
    static class Node {
        int data;
        Node left;
        Node right;

        // constructor
        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // inorder traversal (sorted output)
    public static void inorder(Node root) {
        // base case
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // search function
    public static boolean search(Node root, int key) { /// O(h)
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // delete function
    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else { // voila
            // case 1: leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2: Single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3: both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    // inorder successor (minimum in right subtree)
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    //print range
    public static void printInRange(Node root, int k1,int k2){
        if(root == null){
            return;
        }
        //case 1:
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }
        //case 2:
        else if(root.data <k1){
            printInRange(root.left,k1,k2);
        }
        else{
            printInRange(root.right,k1,k2);
        }
    }
    public static void printPath(ArrayList<Integer>path){
        for(int i =0; i<path.size();i++){
            System.out.print(path.get(i)+"->");

        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root,ArrayList<Integer>path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int values[] = {8,5, 3, 1,4,6,10,11,14};
        Node root = null;

        // insert all values into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // print inorder traversal
        inorder(root);
        System.out.println();
        printRoot2Leaf(root,new ArrayList<>());
    }
}
