public class BSTDay1{
  static class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
      this.data = data;
    }
  }
  public static Node insert(Node root, int val){
    if(root == null){
      root = new Node(val);
      return root;
    }
    if(root.data>val){
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }
  public static void inorder(Node root){
    if(root == null) return;
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }
  
  public static boolean searchKey(Node root, int key){
    if(root == null) return false;
    if(root.data>key){
      return searchKey(root.left,key);
    } else if(root.data == key){
       return true;
    } else {
      return searchKey(root.right, key);
    }
    
  }
  public static Node delete(Node root, int key){
    if(root.left == null && root.right == null) return null;
    if(root.left == null){
      return root.right;
    } else if(root.right == null) {
      return root.left;
    }
    
    Node IS = inorderSuccessor(root.right);
    root.data = IS.data;
    root.right = delete(root.right, IS.data);
    return root;
  }
  public static Node inorderSuccessor(Node root){
    while(root.left!=null){
      root = root.left;
    }
    return root;
  }
  public static void main(String args[]){
    int val[] = {5, 1, 3, 4, 2, 6};
    Node root = null;
    for(int i = 0; i<val.length; i++){
      root = insert(root, val[i]);
    }
    inorder(root);
    System.out.println();
    delete(root, 9);
    inorder(root);
  }
}