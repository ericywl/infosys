package BinarySearchTree;

public class BinarySearchTree {
    public static  Node root;
    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(char id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if (id == current.data) {
                return;
            }
            else {
                if(id<=current.data){
                    current = current.left;
                    if(current==null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    current = current.right;
                    if(current==null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void preOrder(Node root){
        if(root!=null){
            System.out.print(" " + root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" " + root.data);
        }
    }

}

class Node{
    char data;
    Node left;
    Node right;
    public Node(char data){
        this.data = data;
        left = null;
        right = null;
    }
}

