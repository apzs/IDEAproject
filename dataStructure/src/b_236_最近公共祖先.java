import java.util.Stack;

public class b_236_最近公共祖先 {
    static node root = null;

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
        Stack<node> s1 = new Stack<>();
        def_search(root,15,s,s1);
        Stack<node> s2 = new Stack<>();
        def_search(root,16,s,s2);

        int size1 = s1.size();
        int size2 = s2.size();
        while (size1!=size2){
            if (size1>size2){
                s1.pop();
                size1--;
            }else {
                s2.pop();
                size2--;
            }
        }
        while (s1.peek() != s2.peek()){
            s1.pop();
            s2.pop();
        }
        System.out.println(s1.peek().value);
    }

    /**
     * 类似于后续遍历 left<father<right
     * @param a 要构建的二叉树对应的数组
     * @param l 左孩子
     * @param r 右孩子
     */
    static node buildBinaryTree(int[] a,int l,int r){
        if (l>r){
            return null;
        }
        node head = new node(a[r]);
        if (l==r){
            return head;
        }
        //二分法查找左孩子和右孩子
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
    static void def_search(node n,int val,Stack<node> s,Stack<node> ss){
        if(n==null){
            return;
        }
        s.push(n);
        if (n.value ==val){
            for (int i = 0; i < s.size(); i++) {
                node n1 = s.get(i);
               ss.push(n1);
            }
            s.pop();
            //由于此时没有将该节点出栈，所以该程序在找到该节点后少出栈一次导致根节点10未出栈，可以在此添加 s.pop();
            return;
        }
        def_search(n.left, val, s,ss);
        def_search(n.right, val, s,ss);
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
