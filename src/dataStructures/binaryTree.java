package dataStructures;

public class binaryTree {
    private TreeNode root;

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insert a node in BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Delete a node from BST
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private TreeNode deleteRec(TreeNode root, int data) {
        if (root == null) return root;

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // In-order Traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order Traversal
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order Traversal
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Find a node in BST
    public boolean find(int data) {
        return findRec(root, data);
    }

    private boolean findRec(TreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (data == root.data) {
            return true;
        }
        return data < root.data ? findRec(root.left, data) : findRec(root.right, data);
    }
    public static void demo(){
        binaryTree tree = new binaryTree();  // Assuming BinaryTree is already imported and available

        // Adding elements to the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Binary Tree after adding elements:");
        tree.inorder();  // Display the tree in inorder

        // Deleting an element
        tree.delete(20);
        System.out.println("Binary Tree after deleting element 20:");
        tree.inorder();  // Display the tree in inorder after deletion

        // Finding an element
        boolean found = tree.find(60);
        System.out.println("Element 60 found in the tree: " + found);

        // Display different traversals
        System.out.println("Inorder traversal of the tree:");
        tree.inorder();
        System.out.println("Preorder traversal of the tree:");
        tree.preorder();
        System.out.println("Postorder traversal of the tree:");
        tree.postorder();
    }
}
