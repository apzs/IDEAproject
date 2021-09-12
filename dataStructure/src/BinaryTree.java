

public class BinaryTree {

    private int m;

    public static void main(String[] args) {
//        int[] posArr = {1,2,3,4,5,6,7};
        int[] posArr = {1,3,2,5,4,7,8,11,10,6};
        Node head = posArrayToBST1(posArr);
        pre(head);
    }

    public static Node posArrayToBST1(int[] posArr) {
        return pocess1(posArr,0,posArr.length-1);
    }
    //目前在使用posArr[L...R]这些数字来建树，建好后返回头结点
    public static Node pocess1(int[] posArr, int L, int R) {
        if(L>R) {
            return null;
        }
        //[L...R] [R]
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        int m = L-1;
//		for (int i = L; i < R; i++) {
//			if (posArr[i]<posArr[R]) {
//				M = i;
//			}
//		}
        int left = L;
        int right= R-1;
        while (left<=right) {
            int mid = (left+right)/2;
            //mid = left + (right-left)/2
            //mid = left + (right-left)>>1
            if (posArr[mid]<posArr[R]) {
                m = left;
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        head.left = pocess1(posArr, L, m);
        head.right= pocess1(posArr, m+1, R-1);
        return head;
    }

    public static void pre(Node head) {
        if(head==null){
            return;
        }
        pre(head.left);
        pre(head.right);
        System.out.println(head.value);
    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

