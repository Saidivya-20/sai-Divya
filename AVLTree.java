// Node class for AVL Tree
class AVLNode {
    int key, height;
    AVLNode left, right;

    public AVLNode(int key) {
        this.key = key;
        this.height = 1; // New node is initially added at leaf
    }
}

// AVL Tree class
class AVLTree {
    private AVLNode root;

    // Get the height of the node
    int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Get balance factor
    int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // New root
    }

    // Left rotate
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // New root
    }

    // Insert a node
    AVLNode insert(AVLNode node, int key) {
        // Step 1: Perform normal BST insert
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys not allowed

        // Step 2: Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Step 3: Get balance factor
        int balance = getBalance(node);

        // Step 4: Balance the tree
        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the (unchanged) node pointer
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // In-order traversal
    void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    // Public method to display tree
    public void display() {
        System.out.print("In-order Traversal: ");
        inOrder(root);
        System.out.println();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // Will cause rotation
        tree.insert(40);
        tree.insert(50);
        tree.insert(25); // Will cause double rotation

        tree.display();  // Expected Balanced AVL Tree
    }
}
