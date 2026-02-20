import java.util.ArrayList;
import java.util.List;

/**
 * BST properties: left < node < right (no duplicates). :contentReference[oaicite:9]{index=9}
 */
public class BinarySearchTree {
    static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node n, int key) {
        if (n == null) return new Node(key);
        if (key < n.key) n.left = insert(n.left, key);
        else if (key > n.key) n.right = insert(n.right, key);
        return n;
    }

    public boolean contains(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) cur = cur.left;
            else if (key > cur.key) cur = cur.right;
            else return true;
        }
        return false;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node n, int key) {
        if (n == null) return null;
        if (key < n.key) n.left = delete(n.left, key);
        else if (key > n.key) n.right = delete(n.right, key);
        else {
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;
            Node succ = minNode(n.right);
            n.key = succ.key;
            n.right = delete(n.right, succ.key);
        }
        return n;
    }

    private Node minNode(Node n) {
        while (n.left != null) n = n.left;
        return n;
    }

    public List<Integer> inorder() {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(Node n, List<Integer> res) {
        if (n == null) return;
        inorder(n.left, res);
        res.add(n.key);
        inorder(n.right, res);
    }
}
