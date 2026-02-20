import java.util.ArrayList;
import java.util.List;

/**
 * AVL: balance factor = height(left) - height(right) must be in [-1,0,1].
 */
public class AVLTree {
    static class Node {
        int key;
        Node left, right;
        int height; // height of node
        Node(int key) { this.key = key; this.height = 1; }
    }

    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
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

    // ---------- internal helpers ----------
    private Node insert(Node n, int key) {
        if (n == null) return new Node(key);

        if (key < n.key) n.left = insert(n.left, key);
        else if (key > n.key) n.right = insert(n.right, key);
        else return n; // no duplicates

        updateHeight(n);
        return rebalance(n);
    }

    private Node delete(Node n, int key) {
        if (n == null) return null;

        if (key < n.key) n.left = delete(n.left, key);
        else if (key > n.key) n.right = delete(n.right, key);
        else {
            // node found
            if (n.left == null || n.right == null) {
                n = (n.left != null) ? n.left : n.right;
            } else {
                Node succ = minNode(n.right);
                n.key = succ.key;
                n.right = delete(n.right, succ.key);
            }
        }

        if (n == null) return null;

        updateHeight(n);
        return rebalance(n);
    }

    private Node minNode(Node n) {
        while (n.left != null) n = n.left;
        return n;
    }

    private int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int balanceFactor(Node n) {
        return height(n.left) - height(n.right);
    }

    private Node rebalance(Node n) {
        int bf = balanceFactor(n);

        // Left heavy
        if (bf > 1) {
            if (balanceFactor(n.left) < 0) {
                n.left = rotateLeft(n.left);      // LR case
            }
            return rotateRight(n);                // LL case
        }

        // Right heavy
        if (bf < -1) {
            if (balanceFactor(n.right) > 0) {
                n.right = rotateRight(n.right);   // RL case
            }
            return rotateLeft(n);                 // RR case
        }

        return n;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        updateHeight(x);
        updateHeight(y);
        return y;
    }
}
