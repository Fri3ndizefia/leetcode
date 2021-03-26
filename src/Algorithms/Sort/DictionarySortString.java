package Algorithms.Sort;

import java.util.*;

/**
 * 重写Collections.sort 实现字典序排序
 * 实际上 Collections的sort方法就是实现字典序排序
 */

public class DictionarySortString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < n; ++i) {
                String s = scanner.next();
                list.add(s);
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    char[] chars1 = o1.toCharArray();
                    char[] chars2 = o2.toCharArray();
                    int i = 0;
                    while (i < chars1.length && i < chars2.length) {
                        if (chars1[i] > chars2[i]) {
                            return 1;
                        } else if (chars1[i] < chars2[i]) {
                            return -1;
                        } else {
                            ++i;
                        }
                    }
                    if (i == chars1.length) {
                        return -1;
                    }
                    if (i == chars2.length) {
                        return 1;
                    }
                    return 0;
                }
            });

            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
