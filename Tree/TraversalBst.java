import java.util.LinkedList;
import java.util.Queue;

/**
 * Kelas Node digunakan untuk merepresentasikan sebuah node dalam Binary Search Tree (BST).
 */
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

/**
 * Kelas BinarySearchTree menyediakan implementasi untuk Binary Search Tree.
 */
public class TraversalBst {

    Node root;

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    /**
     * Melakukan traversal in-order pada BST.
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    /**
     * Melakukan traversal post-order pada BST.
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * Melakukan traversal level-order (Breadth-First Search) pada BST.
     */
    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        TraversalBst bst = new TraversalBst();
        
        // Membuat struktur BST
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        System.out.println("In-Order traversal:");
        bst.inOrder(bst.root);
        System.out.println();

        System.out.println("Post-Order traversal:");
        bst.postOrder(bst.root);
        System.out.println();

        System.out.println("Level-Order traversal:");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}
