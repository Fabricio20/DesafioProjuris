package br.com.projuris;

import org.junit.Test;

public class FindArrayTests {

    @Test
    public void findArrayShouldReturnTwo() {
        MyFindArray myFindArray = new MyFindArray();
        int[] array = {4, 9, 3, 7, 8};
        int[] subArray = {3, 7};
        assert myFindArray.findArray(array, subArray) == 2;
    }

    @Test
    public void findArrayShouldReturnZero() {
        MyFindArray myFindArray = new MyFindArray();
        int[] array = {1, 3, 5};
        int[] subArray = {1};
        assert myFindArray.findArray(array, subArray) == 0;
    }

    @Test
    public void findArrayShouldReturnFive() {
        MyFindArray myFindArray = new MyFindArray();
        int[] array = {4, 9, 3, 7, 8, 3, 7, 1};
        int[] subArray = {3, 7};
        assert myFindArray.findArray(array, subArray) == 5;
    }

    @Test
    public void findArrayShouldReturnNegativeOneOnInvalidParameters() {
        MyFindArray myFindArray = new MyFindArray();
        assert myFindArray.findArray(null, new int[]{1, 2}) == -1;
        assert myFindArray.findArray(new int[]{1, 2}, null) == -1;
    }

    @Test
    public void findArrayShouldReturnNegativeOne() {
        MyFindArray myFindArray = new MyFindArray();
        int[] array = {2, 4, 8, 16, 32, 64, 128, 256, 512};
        int[] subArray = {3, 6};
        assert myFindArray.findArray(array, subArray) == -1;
    }

}