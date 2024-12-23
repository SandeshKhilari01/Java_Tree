import java.util.*;
public class BinTreeDay4{
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
            Node newNode = new Node (nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static List<Integer> kLevel(Node root, int level, int k){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        if(level == k){
            ans.add(root.data);
            return ans;
        }
        ans.addAll(kLevel(root.left, level+1, k));
        ans.addAll(kLevel(root.right, level+1, k));
        return ans;
    } 

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null) return false;

        path.add(root);

        if(root.data == n) return true;

        boolean leftPath = getPath(root.left, n, path);
        boolean rightPath = getPath(root.right, n, path);

        if(leftPath || rightPath) return true;

        path.remove(path.size()-1);

        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for(;i < path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node ans = path1.get(i-1);
        return ans;
    }
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BuildTree tree = new BuildTree();
        Node root = tree.buildTree(nodes);
        System.out.println(lca(root, 4, 5).data);
    }
}