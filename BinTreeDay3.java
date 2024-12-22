import java.util.*;
public class BinTreeDay3{
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

    static class Info{
        int hd;
        Node node;
        public Info(Node node, int hd){
            this.hd = hd;
            this.node = node;
        }
    }
    public static void TopView(Node root){
        if(root == null) return;
        Queue <Info> q = new LinkedList<>();
        HashMap <Node, Integer> map = new HashMap<>();
        int min = 0;
        int max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)){
                    map.put(curr.node, curr.hd);
                }
    
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.max(min, curr.hd-1);
                }
    
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        
        for(int i = min; i<=max; i++){
            System.out.print(map.get(i)+" ");
        }
    }
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BuildTree.idx = -1;
        Node root = BuildTree.buildTree(nodes);
        TopView(root);
    }
}