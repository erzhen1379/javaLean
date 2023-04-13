package leaning.structure.tree;

/**
 * 编写一个ArrayBinaryTree，实现顺序存储二叉树
 */
public class ArrayBinaryTree {
    private int[] arr;  //顺序数据节点的数据

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载preOder方法
     * 优点：不需要每次都传个0
     */
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 完成顺序存储二叉树的前序遍历
     *
     * @param index
     */
    public void preOrder(int index) {
        //判断数组是否为空
        if (arr == null && arr.length == 0) {
            System.out.println("数组为空，不能遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
