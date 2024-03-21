package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class generate {
    public static String generateExpress(int max) {

        Random ran = new Random();

        String[] sign = {"+", "-", "×", "÷"};//运算符
        String e1="" , e2="" , e3="" , e4="";
        String s1= sign[ran.nextInt(4)],s2=sign[ran.nextInt(4)], s3=sign[ran.nextInt(4)];

        String[] num = {e1, e2, e3, e4};//存数字
       String[] sign1={s1,s2,s3};//存运算符
        List<String> a=new ArrayList<>();//存放算式

        int[] e = {0, 1};//
             for (int i = 0; i < num.length; i++)
        {
            int y = e[ran.nextInt(2)];//y随机赋值成0或者1

            if (y == 0) {
                num[i]=numberGenerate(max);//随机生成整数
            }
            else {num[i] = fractionGenerate(max);//随机生成分数
            }
        }

           for (int i = 0; i < sign1.length; i++)
           {   if (sign1[i].equals("÷"))
                {
                    while (num[i+1].equals("0"))
                    {num[i+1]=numberGenerate(max);}
                }
           }



            int[] signNum = {1, 2, 3};//控制选择的运算符(0-3)
            int j;    int x= ran.nextInt(3);//记录随机生成的符号数

            for (j = 0; j < signNum[x]; j++) {//调整j的范围可以控制运算符的数目
                a.add(num[j]);
               a.add(sign1[j]);
            }
            a.add(num[j]);

                  int q= ran.nextInt(2);
                  //q为1则添加括号
                  if (q==1) {
                      //添加括号
                      int[] left1 = {0, 2};
                      int l1 = ran.nextInt(2);
                      int[] left2 = {0, 2, 4};
                      int l2 = ran.nextInt(3);
                      //根据符号数量生成括号
                      if (x == 1) {
                          a.add(left1[l1], "(");
                          a.add(left1[l1] + 4, ")");
                      } else if (x == 2) {
                          a.add(left2[l2], "(");
                          a.add(left2[l2] + 4, ")");

                      }
                  }

        StringBuilder str = new StringBuilder();
                 //list转换成String并在符号前后加空格
        for (String s : a) {
            if (s.equals("+") || s.equals("-") || s.equals("×") || s.equals("÷")) {
                str.append(" ").append(s).append(" ");
            } else {
                str.append(s);
            }
        }

            return str.toString();
        }



        public static String fractionGenerate(int max) {
        //生成分数，包含真分数
                Random ran = new Random();
                 int num=ran.nextInt(max);
                 int den=ran.nextInt(max);
                 while (den==0){den=ran.nextInt(max);}
                 while (num==0){num=ran.nextInt(max);}
            return calculate.Simplify(num, den);
        }

    public static String numberGenerate(int max) {
        //生成整数
        Random ran = new Random();
        return String.valueOf(ran.nextInt(max));
    }

    }
