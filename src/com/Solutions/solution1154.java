package com.Solutions;

/**
 * 距离今年有多少天？
 * 闰年知识
 * 四年一闰， 百年不闰， 四百年再闰。
 */

public class solution1154 {
    public int dayOfYear(String date){
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; ++i) {
            day += daysOfMonth[i];
        }
        /**
         * 闰年判定
         * 如果是 400 倍数，则闰年
         * 如果是 100 倍数，不是4 的倍数，不是闰
         * 如果不是 100 倍数， 是 4 倍数，则是闰
         */
        if ((year % 400 == 0 ) || (year % 100 != 0 && year % 4 == 0)) {
            if(month > 2){
                day += 1;
            }
        }
        return day;

    }
}
