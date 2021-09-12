import java.util.Stack;

public class ttt {
    static node root = null;
    private static Stack<node> s1;

    public static void main(String[] args) {
//    int[] a = {6,7,4,2,5,0,8,1,3};
//        int[] a = {1,3,2,5,4,7,8,11,10,6};
        int[] a = {2,6,5,14,16,15,10};
/**
 *               10
 *            /     \
 *           5      15
 *          / \    /  \
 *         2   6  14  16
 */
        root = buildBinaryTree(a,0,a.length-1);
        Stack<node> s = new Stack<>();
        s1 = new Stack<>();
        fun(root,14,s,s1);
        for (int i = 0; i < s1.size(); i++) {
            System.out.println(s1.get(i).value);
        }
    }

    static node buildBinaryTree(int[] a,int l,int r){
        if (l>r){
            return null;
        }
        node head = new node(a[r]);
        if (l==r){
            return head;
        }

        int left = l;
        int right = r-1;
        while (left<=right){
            int mid =(left+right)/2;
            if (a[mid]<a[r]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        head.left = buildBinaryTree(a,l,right);
        head.right= buildBinaryTree(a,right+1,r-1);
        return head;
    }

    /**
     *
     * @param n 根节点
     * @param val 要寻找的节点的值
     * @param s   临时栈
     * @param ss  用于存放要求的节点的路径
     */
    static void fun(node n,int val,Stack<node> s,Stack<node> ss){
//        System.out.println(n.value);
        if (n.value ==val){
            s.push(n);
            for (int i = 0; i < s.size(); i++) {
                node n1 = s.get(i);
                ss.push(n1);
            }
            return;
        }
        if(n.left==null && n.right==null){
            return;
        }
        s.push(n);

        fun(n.left, val, s,ss);
        fun(n.right, val, s,ss);
        s.pop();
    }

    static class node{
        int value;
        node left=null;
        node right=null;

        public node(int value) {
            this.value = value;
        }
    }
}

