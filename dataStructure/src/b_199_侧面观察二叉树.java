import java.util.LinkedList;
import java.util.Queue;

/**
 * 从右往左看一颗二叉树
 */
public class b_199_侧面观察二叉树{
    static node root = null;

    public static void main(String[] args) {
        int[] a = {2,6,5,14,16,15,10};
/**
 *               10
 *            /     \
 *           5      15
 *          / \    /  \
 *         2   6  14  16
 */
        root = buildBinaryTree(a,0,a.length-1);

        int visitLen = (int) (Math.log(a.length)/Math.log(2)+1);
        int[] visit = new int[visitLen];
        bfs_search(root,visit);
        for (int i = 0; i < visit.length; i++) {
            System.out.println(visit[i]);
        }
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

    private static void bfs_search(node n,int[] visit){
        Queue<edge> q = new LinkedList<>();
        q.add(new edge(n,0));
        visit[0] = n.value;
        while (!q.isEmpty()){
           edge e = q.peek();
           node n1 = e.no;
           int level = e.level;
           //一直更新该节点所在层的值，最后保存的是最后一次更新的值，即该层的最右边节点的值
           visit[level] = n1.value;
           if (n1.left!=null){
               q.add(new edge(n1.left,level+1));
           }
           if (n1.right!=null) {
               q.add(new edge(n1.right, level+1));
           }
           q.poll();
        }
    }

    static class node{
        int value;
        node left=null;
        node right=null;

        public node(int value) {
            this.value = value;
        }
    }
    static class edge{
        node no;
        int level;

        public edge(node no, int level) {
            this.no = no;
            this.level = level;
        }
    }
}

