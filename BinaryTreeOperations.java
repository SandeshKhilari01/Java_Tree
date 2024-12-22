public class BinaryTreeOperations{
    public static class Node{
        int data;
        Node left;
        Node right;
    
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
    static class BinaryTreeOp{
        static int idx = -1;
        public static Node Tree(int[] nodes){
            idx++;
            if(nodes[idx] == -1) return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = Tree(nodes);
            newNode.right = Tree(nodes);
            return newNode;
        }
    }

    public static int countNodes(Node root){
        if(root == null) return 0;
        int leftcount = countNodes(root.left);
        int rightcount = countNodes(root.right);
        return (leftcount + rightcount + 1);

    }
    public static int SumNodes(Node root){
        if(root == null) return 0;
        int leftSum = SumNodes(root.left);
        int rightSum = SumNodes(root.right);
        int sumofNodes = leftSum + rightSum + root.data;
        return sumofNodes;
    }
    public static int height(Node root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int myheight = Math.max(leftHeight, rightHeight);
        return myheight+1;
    }
    public static int diameter(Node root){
        if(root == null) return 0;
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;
        int mydiameter = Math.max(Math.max(dia1, dia2), dia3);
        return mydiameter;
    }
    static class TreeInfo{
        int ht;
        int dia;
        TreeInfo(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }
    public static TreeInfo diameter1(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }
        // Tree Height
        TreeInfo left = diameter1(root.left);
        TreeInfo right = diameter1(root.right);
        int myHeight = Math.max(left.ht, right.ht) + 1;

        // Tree Diameter
        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht + 1;
        int myDia = (Math.max(Math.max(dia1, dia2), dia3));

        TreeInfo tree = new TreeInfo(myHeight, myDia);
        return tree;
    }
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTreeOp tree = new BinaryTreeOp();
        Node root = tree.Tree(nodes);
        System.out.println(root.data);
        System.out.println(countNodes(root));
        System.out.println(SumNodes(root));
        System.out.println(height(root));
        System.out.println(diameter(root));
        System.out.println(diameter1(root).dia);
    }
}