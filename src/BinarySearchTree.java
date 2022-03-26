public class BinarySearchTree {
    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int item){
            data = item;
            left = right = null;
        }
    }
    private static TreeNode root;
    public void setRoot(TreeNode r){
        root=r;
    }

    // constructor
    public BinarySearchTree(){
        root=null;
    }

    public static TreeNode ArrayToTree(int array[], int low, int high){
        //Error: the given array is null or empty
        if(array==null||array.length==0){
            System.out.println("Error: <the given array is null or empty, please choose another array>");
            System.exit(0);
        }

        //Base case
        if(low>high){
            return null;
        }
        else {
            // to make a balanced BST, we need to find the middle value and set it to be the root.
            int middle = (low + high) / 2;
            //Error: when (low + high) / 2 is out of boundary, the program cannot be executed.
            if((low + high)/2<0||(low + high)/2>high){
                System.out.println("Error: <the index is out of the boundary of given array>");
                System.exit(2);
            }
            TreeNode newNode = new TreeNode(array[middle]);

            //recursively call the ArrayToTree() method to set the left and right parts of the root
            newNode.left = ArrayToTree(array, low, middle - 1);
            newNode.right = ArrayToTree(array, middle + 1, high);

            // return the root
            return newNode;
        }
    }

    //Pre-Order
    public void preOrder(TreeNode node)  {

        // When the root is null, the BST doesn't exist
        if(root==null){
            System.out.println("Error: <the root of BST is null>");
            System.exit(1);
        }
        if (node == null) {
            return;
        }
        // firstly, we print the root
        System.out.print(node.data+" ");
        // we then traverse the left subtree
        preOrder(node.left);
        // we finally traverse the right subtree
        preOrder(node.right);
    }
    public void preorder_traversal(){
        preOrder(root);
    }

    //In-Order
    public void inOrder(TreeNode node)  {

        // When the root is null, the BST doesn't exist
        if(root==null){
            System.out.println("Error: <the root of BST is null>");
            System.exit(1);
        }

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public void inorder_traversal(){
        inOrder(root);
    }

    //Post-Order
    public void postOrder(TreeNode node)  {

        // When the root is null, the BST doesn't exist
        if(root==null){
            System.out.println("Error: <the root of BST is null>");
            System.exit(1);
        }

        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    public void postorder_traversal(){
        postOrder(root);
    }


    // The main class is used to check the correctness of the program
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int n = array.length;
        tree.setRoot(tree.ArrayToTree(array, 0, n-1));
        root = ArrayToTree(array,0,array.length-1);
        tree.preorder_traversal();
        System.out.println("");
        tree.inorder_traversal();
        System.out.println("");
        tree.postorder_traversal();
    }

}
