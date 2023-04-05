package Tree;

import java.util.Random;

public class BinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
            left = null;
            right = null;
        }
    }

    Node root;

    public BinaryTree(){
        root = null;
    }

    // 알고리즘 6-2 이진 검색 트리에서 검색
    public Node treeSearch(Node t, int x){
        if (t == null ){
            System.out.println("검색 결과 없음 ");
            return null;
        }
        if (t.val == x){
            System.out.println("검색된 노드 : " + t.val);
            return t;
        }

        if ( x < t.val){
            return treeSearch(t.left,x);
        }
        else {
            return treeSearch(t.right,x);
        }


    }

    // 알고리즘 6-3 이진 검색 트리에서 삽입
    public Node treeInsertRecursive(Node t, int x){

        if (t == null) {
            return new Node(x);
        }
        if (x < t.val){
            t.left = treeInsertRecursive(t.left, x);
        }
        else {
            t.right = treeInsertRecursive(t.right,x);
        }
        return t;

    }


    // 알고리즘 6-4 이진 검색 트리에서 삽입(비재귀 버전)
    public void treeInsertNotRecursive(Node t, int x){
        Node newNode = new Node(x);
        if(root == null){
            root = newNode;
        }
        // p == parent Node, tmp == current Node
        else {
            Node tmp = t;
            Node p = null;

            while(tmp != null){
                p = tmp;
                if ( x < tmp.val){
                    tmp = tmp.left;
                }
                else {
                    tmp = tmp.right;
                }
            }

            if ( x < p.val){
                p.left = newNode;
            }
            else {
                p.right = newNode;
            }

        }
    }

    public void treeDelete(Node t, int r, int p){
        Node rnode = treeSearch(root, r);
        Node pnode = treeSearch(root, p);

        if (rnode.val == t.val) {
            root = deleteNode(root);
        }

        else if (rnode == pnode.left){
            pnode.left = deleteNode(rnode);
        }

        else {
            pnode.right = deleteNode(rnode);
        }
    }

    

    public Node deleteNode(Node r ){
        if(r.right == null && r.left == null) {
            return null;
        }
        else if ( r.left == null && r.right != null){
            return r.right;
        }

        else if ( r.left != null && r.right == null) {
            return r.left;
        }

        else {
            Node s = r.right;
            Node parent = null;

            while(s.left != null) {
                parent = s;
                s = s.left;}
            
                r.val = s.val;

                if (s == r.right) {
                    r.right = s.right;
                } else {
                    parent.left = s.right;

                }
            return r;
            }

    }


    public void addRecursive(int value){
        root = treeInsertRecursive(root, value);
    }

    public void addNotRecursive(int value){
        root = treeInsertRecursive(root, value);
    }

    public void search(int value) {
        treeSearch(root, value);
    }

    public void delete(int nValue, int pValue){
        treeDelete(root,nValue,pValue);
    }


    public void display(Node t){
        if (t != null){
            display(t.left);
            System.out.println("Node :" + t.val);
            display(t.right);
        }
    }


    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    i--;
                }
            }
        }
        for (int nums: arr
             ) {
            binaryTree.addRecursive(nums);
        }

//        binaryTree.search(4);

        binaryTree.display(binaryTree.root);

//        binaryTree.delete(28,15);

//        binaryTree.display(binaryTree.root);

    }
}
