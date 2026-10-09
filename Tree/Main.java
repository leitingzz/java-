package Tree;

public class Main {
    public static void  inorderPrint(TreeNode root){
        if(root == null){
            return;
        }
        inorderPrint(root.left);
        System.out.println(root.data);
        inorderPrint(root.right);
    }

    public static boolean search(TreeNode node, int target){
        if(node == null){
            return false;
        }

        if(target == node.data){
            return true;
        }

        if(target > node.data){
            return search(node.right, target);
        }else{
            return search(node.left, target);
        }
    }

    public static TreeNode insert(TreeNode node, int data){
        if(node == null){
            return new TreeNode(data);
        }

        if(node.data > data){
            node.left = insert(node.left, data);
        }else if(node.data < data){
            node.right = insert(node.right, data);
        }

        return node;
    }

    public static void main(String[] args){
        TreeNode root = null;
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 8);
        root = insert(root, 1);
        root = insert(root, 4);
        root = insert(root, 7);
        root = insert(root, 9);
        inorderPrint(root);
        System.out.println(search(root, 4));
        System.out.println(search(root, 6));
    }
}