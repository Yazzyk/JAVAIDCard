package com.test;

import javax.swing.JOptionPane;

//输入身份证号码，判断其合法性。如合法，显示出该号码所属省份、出生年月、年龄、性别、属相、星座以及天干地支。
//身份证号的编码规则： 
//前1-2位数字表示：所在省（直辖市、自治区）的代码； 
//第3-4位数字表示：所在地级市（自治州）的代码； 
//第5-6位数字表示：所在区（县、自治县、县级市）的代码； 
//第7-14位数字表示：出生年、月、日； 
//第15-16位数字表示：所在地的派出所的代码； 
//第17位数字表示性别：奇数表示男性，偶数表示女性； 
//第18位数字是校检码：是用来检验身份证的正确性。校检码可以是0-9的数字，有时也用X表示。
//
//合法性算法： 
//第一步：
//将身份证号码的第1位数字与7相乘；
//将身份证号码的第2位数字与9相乘；
//将身份证号码的第3位数字与10相乘；
//将身份证号码的第4位数字与5相乘；
//将身份证号码的第5位数字与8相乘；
//将身份证号码的第6位数字与4相乘；
//将身份证号码的第7位数字与2相乘；
//将身份证号码的第8位数字与1相乘；
//将身份证号码的第9位数字与6相乘；
//将身份证号码的第10位数字与3相乘；
//将身份证号码的第11位数字与7相乘；
//将身份证号码的第12位数字与9相乘；
//将身份证号码的第13位数字与10相乘；
//将身份证号码的第14位数字与5相乘；
//将身份证号码的第15位数字与8相乘；
//将身份证号码的第16位数字与4相乘；
//将身份证号码的第17位数字与2相乘。 
//第二步：
//将第一步身份证号码1~17位相乘的结果求和，全部加起来。 
//第三步：
//用第二步计算出来的结果除以11，
//这样就会出现余数为0，余数为1，余数为2，余数为3，余数为4，余数为5，余数为6，余数为7，余数为8，余数为9，余数为10
//共11种可能性。 
//第四步：如果余数为0，那对应的最后一位身份证的号码为1；
//如果余数为1，那对应的最后一位身份证的号码为0；
//如果余数为2，那对应的最后一位身份证的号码为X;
//如果余数为3，那对应的最后一位身份证的号码为9；
//如果余数为4，那对应的最后一位身份证的号码为8；
//如果余数为5，那对应的最后一位身份证的号码为7；
//如果余数为6，那对应的最后一位身份证的号码为6；
//如果余数为7，那对应的最后一位身份证的号码为5；
//如果余数为8，那对应的最后一位身份证的号码为4；
//如果余数为9，那对应的最后一位身份证的号码为3；
//如果余数为10，那对应的最后一位身份证的号码为2。
public class IDcard {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        try {
            String input = JOptionPane.showInputDialog("请输入身份证");
            char nums[] = new char[input.length()];
            nums = input.toCharArray();
            Algorithm al = new Algorithm();
            // 合法性计算
            if (input.length() != 18 | !al.real(nums)) {
                System.out.println("身份证号码不正确");
                JOptionPane.showConfirmDialog(null, "身份证号码不正确", "错误", JOptionPane.CANCEL_OPTION);
                System.exit(0);
            } else {
                // 省份
                String privince = al.province(nums[0], nums[1]);
                System.out.println(privince);

                // 出生日期
                int birth = al.birth(nums[6], nums[7], nums[8], nums[9], nums[10], nums[11], nums[12], nums[13]);
                System.out.println("出生日期:" + birth);

                // 年龄
                int age = al.age(birth);
                System.out.println("年龄：" + age);

                // 性别
                String sex = "";
                if (al.sex(nums[16])) {
                    sex = "男";
                } else {
                    sex = "女";
                }
                System.out.println("性别：" + sex);

                // 星座
                String constellation = al.constellation(birth);
                System.out.println("星座:" + constellation);

                // 天干地支
                String HB = al.heavenlyBranch(birth);
                System.out.println("天干地支：" + HB);

                // 属相
                String zodiac = al.signOfTheZodiac(birth);
                System.out.println("属相：" + zodiac);

                // 信息框
                JOptionPane.showConfirmDialog(null,
                        "省份:" + privince + "\n" + "出生日期:"
                                + birth
                                + "\n" + "年龄:" + age + "\n" + "性别:" + sex + "\n" + "星座:" + constellation + "\n"
                                + "天干地支:" + HB + "\n" + "属相：" + zodiac,
                        "身份证信息", JOptionPane.CANCEL_OPTION);
            }

        } catch (Exception e) {
            System.out.println("Error:" + e);
            JOptionPane.showConfirmDialog(null, e, "Error", JOptionPane.CANCEL_OPTION);
        } finally {
            System.exit(0);
        }
    }

}
