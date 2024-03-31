import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.*;

public class BubbleSortTest {

    //测试空数组情况
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试单元素情况
    @Test
    public void testSingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试简单含负数数组
    @Test
    public void testArrayWithNegativeNumbers() {
        int[] arr = {-5, -3, -9, -1, -7};
        int[] expected = {-9, -7, -5, -3, -1};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试简单乱序数组
    @Test
    public void testUnsortedArray() {
        int[] arr = {5, 3, 9, -1, 7, 0};
        int[] expected = {-1, 0, 3, 5, 7, 9};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试已升序情况1--简单
    @Test
    public void testSortedArray1() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试已升序情况2--复杂
    @Test
    public void testSortedArray2() {
        int[] arr = genRamdomArray(1000);
        Arrays.sort(arr);
        int[] expected = new int[arr.length];
        System.arraycopy(arr, 0, expected, 0, arr.length);
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试含重复元素情况1--简单
    @Test
    public void testArrayWithDuplicates1() {
        int[] arr = {3, 2, 3, 5, 7, 9, 9};
        int[] expected = {2, 3, 3, 5, 7, 9, 9};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试含重复元素情况2--极端
    @Test
    public void testArrayWithDuplicates2() {
        int[] arr = new int[1000];
        Random random = new Random();
        int tmp = random.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp;
        }
        int[] expected = new int[arr.length];
        System.arraycopy(arr, 0, expected, 0, arr.length);
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试逆序数组情况1--只含正数，简单
    @Test
    public void testReverseSortedArray1() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试逆序数组情况2--含负数，简单
    @Test
    public void testReverseSortedArray2() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
        int[] expected = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试逆序数组情况3--含负数和重复元素，简单
    @Test
    public void testReverseSortedArray3() {
        int[] arr = {10, 9, 9, 8, 7, 6, 5, 5, 4, 3, 2, 1, 0, 0, -1, -2, -3, -4, -4, -5};
        int[] expected = {-5, -4, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9, 10};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试逆序数组情况4--复杂
    //不知道Mujava是否通过
    @Test
    public void testReverseSortedArray4() {
        int[] arr = genRamdomArray(1000);
        int[] expected = new int[arr.length];
        System.arraycopy(arr, 0, expected, 0, arr.length);
        //int数组转为integer数组
        Integer[] integerArray = Arrays.stream(arr)
                .boxed()
                .toArray(size -> new Integer[size]);
        //对integer数组降序
        Arrays.sort(integerArray, Comparator.reverseOrder());
        //integer数组转为int数组
        arr = Arrays.stream(integerArray)
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(expected);
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试超大数组1
    @Test
    public void testLargeArray1() {
        int[] arr = genRamdomArray(1000);
        int[] expected = new int[arr.length];
        System.arraycopy(arr, 0, expected, 0, arr.length);
        Arrays.sort(expected);
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试超大数组2
    @Test
    public void testLargeArray2() {
        int[] arr = genRamdomArray(1000);
        int[] expected = new int[arr.length];
        System.arraycopy(arr, 0, expected, 0, arr.length);
        Arrays.sort(expected);
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //测试超大数组3--限时1000ms
    @Test(timeout = 1000)
    public void testLargeArray3() {
        int[] arr = genRamdomArray(10000);
        //System.out.println(Arrays.toString(arr));
        int[] expected = new int[arr.length];
        System.arraycopy(arr, 0, expected, 0, arr.length);
        Arrays.sort(expected);
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    //生成随机数组方法
    public int[] genRamdomArray(int size){
        int[] arr = new int[size];
        Random ramdom = new Random();
        for(int i=0; i<size; i++){
            arr[i] = ramdom.nextInt();
        }
        return arr;
    }

}