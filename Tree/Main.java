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

    public static int count(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

    public static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static int max(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }

    public static int countLeaves(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }
    public static void main(String[] args){
        TreeNode root = null;
        int[] values = {5, 3, 8, 1, 4, 7, 9};
        for(int value : values){
            root = insert(root, value);
        }
        System.out.println("节点数：" + count(root));
        System.out.println("高度：" + height(root));
        System.out.println("最大数：" + max(root));
        System.out.println("叶子节点数：" + countLeaves(root));
    }
}