public class BinTreeDay5{

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
          this.data = data;
          this.left = null;
          this.right = null;
        }
    }
    
    static class BuildTree{
      static int idx = -1;
      public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx] == -1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
      }
    }
    
    //sum of nodes
    
    public static int sumNode(Node root){
      if(root == null) return 0;
      int leftChild = sumNode(root.left);
      int rightChild = sumNode(root.right);
      int data = root.data;
      int newLeftVal = root.left == null ? 0: root.left.data;
      int newRightVal = root.right == null ? 0: root.right.data;
      root.data = leftChild + rightChild + newLeftVal + newRightVal;
      return data;
    }
    
    public static int preOrder(Node root){
      if(root == null) return -1;
      System.out.print(root.data+" ");
      preOrder(root.left);
      preOrder(root.right);
      return root.data;
    }
    
    public static boolean isBalance(Node root){
      if(root == null) return true;
      if(Height(root) == -1) return false;
      return true;
    }
    public static int Height(Node root){
      if(root == null) return 0;
      
      int leftNode = Height(root.left);
      int rightNode = Height(root.right);
      
      if(leftNode == -1 || rightNode == -1) return -1;
      
      if(Math.max(leftNode, rightNode)>0) return -1;
      
      return Math.max(leftNode, rightNode) + 1;
    }
    
    
    public static void main(String args[]){
      int nodes [] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
      BuildTree tree = new BuildTree();
      Node root = tree.buildTree(nodes);
      System.out.println(isBalance(root));
    }
}