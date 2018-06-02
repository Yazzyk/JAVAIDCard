package com.test;

import java.util.Calendar;

public class Algorithm {
    public String province(char nums1, char nums2) {
        int num = Integer.parseInt(String.valueOf(nums1)) * 10 + Integer.parseInt(String.valueOf(nums2));
        String pro = new String();
        // 省份判断
        switch (num) {
            case 11:
                pro = "北京市";
                break;
            case 12:
                pro = "天津市";
                break;
            case 13:
                pro = "河北市";
                break;
            case 14:
                pro = "山西省";
                break;
            case 15:
                pro = "内蒙古";
                break;
            case 21:
                pro = "辽宁省";
                break;
            case 22:
                pro = "吉林省";
                break;
            case 23:
                pro = "黑龙江";
                break;
            case 31:
                pro = "上海市";
                break;
            case 32:
                pro = "江苏省";
                break;
            case 33:
                pro = "江苏省";
                break;
            case 34:
                pro = "安徽省";
                break;
            case 35:
                pro = "福建省";
                break;
            case 36:
                pro = "江西省";
                break;
            case 37:
                pro = "山东省";
                break;
            case 41:
                pro = "河南省";
                break;
            case 42:
                pro = "湖北省";
                break;
            case 43:
                pro = "湖南省";
                break;
            case 44:
                pro = "广东省";
                break;
            case 45:
                pro = "广西省";
                break;
            case 46:
                pro = "海南省";
                break;
            case 50:
                pro = "重庆省";
                break;
            case 51:
                pro = "四川省";
                break;
            case 52:
                pro = "贵州省";
                break;
            case 53:
                pro = "云南省";
                break;
            case 54:
                pro = "西藏自治区";
                break;
            case 61:
                pro = "陕西省";
                break;
            case 62:
                pro = "甘肃省";
                break;
            case 63:
                pro = "青海省";
                break;
            case 64:
                pro = "宁夏回族自治区";
                break;
            case 65:
                pro = "新疆维吾尔自治区";
                break;
            case 71:
                pro = "台湾省";
                break;
            case 81:
                pro = "香港特别行政区";
                break;
            case 82:
                pro = "澳门特别行政区";
                break;
            default:
                pro = "身份证不正确";
        }
        return pro;
    }

    // 计算出生日期
    public int birth(char num1, char num2, char num3, char num4, char num5, char num6, char num7, char num8) {
        int year = Integer.parseInt(String.valueOf(num1)) * 1000 + Integer.parseInt(String.valueOf(num2)) * 100
                + Integer.parseInt(String.valueOf(num3)) * 10 + Integer.parseInt(String.valueOf(num4));
        int month = Integer.parseInt(String.valueOf(num5)) * 10 + Integer.parseInt(String.valueOf(num6));
        int days = Integer.parseInt(String.valueOf(num7)) * 10 + Integer.valueOf(String.valueOf(num8));
        int birth = year * 10000 + month * 100 + days;
        return birth;
    }

    // 计算年龄
    public int age(int birth) {
        int age = 0;
        // 当前日期
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DATE);
        int monthDay = month * 100 + day;
        // 处理生日
        // 19990209
        // 1999
        // 0209
        int birthYear = birth / 10000;
        int birthMonthDay = birth - birthYear * 10000;
        // 计算年龄
        if (birthMonthDay > monthDay) {
            year--;
            age = year - birthYear;
        } else {
            age = year - birthYear;
        }
        return age;
    }

    // 判断男女
    public boolean sex(int s) {
        boolean sex = true;
        if (s % 2 != 0) {
            sex = true;
        } else {
            sex = false;
        }
        return sex;
    }

    // 星座
    public String constellation(int birth) {
        // 对出生日期处理
        String X = "";
        int birthYear = birth / 10000;
        int birthMonthDay = birth - birthYear * 10000;
        if (birthMonthDay >= 121 & birthMonthDay <= 219) {
            X = "水瓶座";
        } else if (birthMonthDay >= 220 & birthMonthDay <= 320) {
            X = "双鱼座";
        } else if (birthMonthDay >= 321 & birthMonthDay <= 420) {
            X = "白羊座";
        } else if (birthMonthDay >= 421 & birthMonthDay <= 521) {
            X = "金牛座";
        } else if (birthMonthDay >= 522 & birthMonthDay <= 621) {
            X = "双子座";
        } else if (birthMonthDay >= 622 & birthMonthDay <= 722) {
            X = "巨蟹座";
        } else if (birthMonthDay >= 723 & birthMonthDay <= 823) {
            X = "狮子座";
        } else if (birthMonthDay >= 824 & birthMonthDay <= 923) {
            X = "处女座";
        } else if (birthMonthDay >= 924 & birthMonthDay <= 1023) {
            X = "天秤座";
        } else if (birthMonthDay >= 1024 & birthMonthDay <= 1122) {
            X = "天蝎座";
        } else if (birthMonthDay >= 1123 & birthMonthDay <= 1221) {
            X = "射手座";
        } else if ((birthMonthDay >= 1222 & birthMonthDay <= 1231) || (birthMonthDay >= 101 & birthMonthDay <= 120)) {
            X = "摩羯座";
        }
        return X;
    }

    // 天干地支
    public String heavenlyBranch(int birth) {
        String heavenlyBranch[][] = {{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"},
                {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"}};
        String HS = "";
        String EB = "";
        int year = birth / 10000;

        int heavenlyStem = year % 10 - 3;
        int earthlyBranches = year % 12 - 3;
        HS = heavenlyBranch[0][heavenlyStem - 1];
        EB = heavenlyBranch[1][earthlyBranches - 1];

        return HS + EB + "年";
    }

    // 属相
    public String signOfTheZodiac(int birth) {
        int year = birth / 10000;
        String zodiac = "";
        if (year < 1900) {
            zodiac = "超出范围";
        } else {
            String years[] = {"鼠", "牛", "虎", "兔", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
            zodiac = years[(year - 1900) % 12];
        }
        return zodiac;
    }

    // 判断号码合法性
    public boolean real(char nums[]) {
        int arr[] = new int[17];
        boolean legitimate = true;
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = Integer.parseInt(String.valueOf(nums[i]));
        }
        int sum = arr[0] * 7 + arr[1] * 9 + arr[2] * 10 + arr[3] * 5 + arr[4] * 8 + arr[5] * 4 + arr[6] * 2 + arr[7] * 1 + arr[8] * 6 + arr[9] * 3 + arr[10] * 7
                + arr[11] * 9 + arr[12] * 10 + arr[13] * 5 + arr[14] * 8 + arr[15] * 4 + arr[16] * 2;
        int remainder = sum % 11;
        char manrissa = '0';
        switch (remainder) {
            case 1:
                manrissa = '0';
                break;
            case 2:
                manrissa = 'X';
                break;
            case 3:
                manrissa = '9';
                break;
            case 4:
                manrissa = '8';
                break;
            case 5:
                manrissa = '7';
                break;
            case 6:
                manrissa = '6';
                break;
            case 7:
                manrissa = '5';
                break;
            case 8:
                manrissa = '4';
                break;
            case 9:
                manrissa = '3';
                break;
            case 10:
                manrissa = '2';
                break;
        }
        if (manrissa == nums[17]) {
            legitimate = true;
        } else {
            legitimate = false;
        }
        return legitimate;
    }

}
