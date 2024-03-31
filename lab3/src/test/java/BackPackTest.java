import org.junit.Test;

import static org.junit.Assert.*;

public class BackPackTest {

    //测试空背包情况
    @Test
    public void testEmptyArrays() {
        int[] weights = {};
        int[] values = {};
        int capacity = 10;
        int expected = 0;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试仅含一个物品且装得下的情况
    @Test
    public void testSingleItem1() {
        int[] weights = {2};
        int[] values = {5};
        int capacity = 2;
        int expected = 5;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试恰好可以全部装下的情况
    @Test
    public void testFullCapacity() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 14;
        int expected = 18;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试没有容积情况
    @Test
    public void testExceedCapacity() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 0;
        int expected = 0;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试重量含1情况
    @Test
    public void testZeroWeight() {
        int[] weights = {1, 1, 1, 1};
        int[] values = {3, 1, 5, 6};
        int capacity = 3;
        int expected = 14;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试价值含0情况
    @Test
    public void testZeroValues() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 0, 5, 6};
        int capacity = 9;
        int expected = 11;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试出现自定义异常情况--重量含负数
    @Test(expected = NegativeException.class)
    public void testNegativeWeights() {
        int[] weights = {2, -3, 4};
        int[] values = {1, 1, 5};
        int capacity = 4;
        int expected = 5;
        int result = BackPack.knapsack(weights, values, capacity);
    }

    //测试出现自定义异常情况--价值含负数
    @Test(expected = NegativeException.class)
    public void testNegativeValues() {
        int[] weights = {2, 3, 4};
        int[] values = {1, -1, 5};
        int capacity = 4;
        int expected = 5;
        int result = BackPack.knapsack(weights, values, capacity);
    }

    //测试出现自定义异常情况--容积含负数
    @Test(expected = NegativeException.class)
    public void testNegativeCapacity() {
        int[] weights = {2, 3, 4};
        int[] values = {1, 1, 5};
        int capacity = -4;
        int expected = 0;
        int result = BackPack.knapsack(weights, values, capacity);
    }

    //测试出现自定义异常情况--数组长度不匹配
    @Test(expected = NegativeException.class)
    public void testErrorLength() {
        int[] weights = {};
        int[] values = {1, 1, 5};
        int capacity = 5;
        int expected = 7;
        int result = BackPack.knapsack(weights, values, capacity);
    }

    //测试重量与价值相等情况
    @Test
    public void testEqualWeightsAndValues() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {2, 3, 4, 5};
        int capacity = 6;
        int expected = 6;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试乱序情况
    @Test
    public void testUnsortedArray() {
        int[] weights = {5, 3, 4, 2};
        int[] values = {6, 4, 5, 3};
        int capacity = 6;
        int expected = 8;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试极值情况
    //若使用Integer.MaxValue会超出虚拟机数组的内存限制
    @Test
    public void testBoundaryWeightAndValue() {
        int[] weights = {10000000, 1};
        int[] values = {1, 10000000};
        int capacity = 10000000;
        int expected = 10000000;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试大量数据情况1--大容积
    @Test
    public void testLargeData1(){
        int[] weights = {334, 66, 565, 384, 797, 10, 654, 610, 472, 358, 391, 782, 183, 1, 775, 632, 434, 476, 352, 883, 867, 973, 509, 725, 743, 611, 220, 478, 621, 550, 477, 800, 468, 227, 794, 192, 569, 814, 620, 579, 734, 943, 83, 585, 964, 677, 862, 78, 857, 813, 750, 107, 962, 283, 344, 680, 490, 830, 679, 477, 408, 760, 877, 60, 429, 692, 474, 833, 699, 254, 619, 305, 238, 814, 844, 38, 966, 892, 566, 432, 483, 893, 345, 245, 887, 404, 82, 281, 399, 105, 870, 62, 122, 101, 669, 781, 808, 603, 879, 587};
        int[] values = {62, 98, 12, 21, 81, 60, 76, 72, 98, 86, 17, 76, 83, 25, 38, 37, 23, 70, 65, 76, 48, 8, 76, 56, 8, 51, 63, 16, 87, 20, 69, 30, 12, 63, 89, 48, 69, 44, 87, 86, 37, 51, 70, 8, 89, 5, 5, 42, 78, 63, 44, 56, 50, 94, 21, 74, 92, 7, 97, 38, 6, 50, 38, 86, 55, 41, 41, 49, 96, 68, 35, 91, 60, 72, 57, 39, 90, 29, 97, 94, 32, 42, 56, 10, 71, 81, 68, 66, 35, 93, 89, 90, 53, 17, 65, 21, 32, 16, 26, 29};
        int capacity = 20000;
        int expected = 3722;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }

    //测试大量数据情况2--小容积
    @Test
    public void testLargeData2() {
        int[] weights = {840, 113, 483, 489, 20, 630, 790, 643, 831, 654, 95, 719, 65, 699, 545, 586, 174, 348, 977, 242, 931, 297, 414, 169, 706, 867, 39, 474, 546, 9, 392, 186, 135, 454, 444, 640, 351, 851, 571, 820, 34, 747, 94, 403, 441, 841, 934, 457, 816, 595, 472, 5, 996, 82, 555, 152, 173, 463, 135, 29, 676, 143, 943, 298, 462, 864, 96, 590, 646, 41, 159, 496, 838, 501, 831, 414, 231, 128, 328, 283, 43, 800, 48, 518, 705, 900, 230, 945, 481, 832, 377, 576, 108, 511, 900, 862, 357, 159, 789, 979};
        int[] values = {80, 60, 79, 75, 67, 31, 99, 53, 3, 62, 70, 50, 84, 35, 50, 7, 16, 87, 85, 54, 33, 50, 50, 18, 43, 47, 1, 24, 89, 91, 31, 38, 11, 24, 30, 73, 35, 67, 15, 28, 54, 93, 64, 13, 77, 27, 65, 0, 2, 19, 40, 64, 98, 67, 39, 35, 37, 94, 11, 3, 99, 72, 60, 81, 40, 63, 80, 23, 21, 2, 17, 91, 79, 82, 14, 76, 92, 29, 28, 74, 81, 61, 94, 50, 32, 0, 99, 44, 5, 10, 32, 27, 95, 96, 9, 13, 66, 1, 66, 89};
        int capacity = 1000;
        int expected = 1046;
        assertEquals(expected, BackPack.knapsack(weights, values, capacity));
    }
}