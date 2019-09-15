package br.com.projuris;

public class MyFindArray implements FindArray {

    @Override
    public int findArray(int[] array, int[] subArray) {
        if (array == null || subArray == null)
            return -1;
        int pos = -1, item = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j : subArray) {
                if (array[i] == j) {
                    if (item == j) {
                        pos = i;
                        break;
                    } else if (item == -1) {
                        // Encontra a primeira ocorrência e salva o item.
                        pos = i;
                        item = j;
                        break;
                    }
                }
            }
        }
        return pos;
    }

}