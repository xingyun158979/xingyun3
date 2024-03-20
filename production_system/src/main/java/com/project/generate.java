package com.project;

import java.util.Random;

public class generate {
    public static String generateExpress(int max) {

        Random ran = new Random();

        String[] sign = {"+", "-", "×", "÷"};//运算符
        String e1="" , e2="" , e3="" , e4="";
        String s1= sign[ran.nextInt(4)],s2=sign[ran.nextInt(4)], s3=sign[ran.nextInt(4)];

        String[] num = {e1, e2, e3, e4};//存数字
       String[] sign1={s1,s2,s3};//存运算符


        int[] e = {0, 1};
             for (int i = 0; i < num.length; i++)
        {
            int y = e[ran.nextInt(2)];

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


            StringBuilder str = new StringBuilder();
            int[] signNum = {1, 2, 3};//控制选择的运算符(0-3)//no[rd.nextInt(3)}
            int j;
            for (j = 0; j < signNum[ran.nextInt(3)]; j++) {//调整j的范围可以控制运算符的数目
                str.append(num[j]).append(" ");
                str.append(sign1[j]).append(" ");//操作数与运算符需用空格隔开，以便后续区分÷和/
            }
            str.append(num[j]).append(" ");


            return str.toString();
        }



        public static String fractionGenerate(int max) {
        //生成分数，包含真分数
                Random ran = new Random();
                 int num=ran.nextInt(max);
                 int den=ran.nextInt(max);
                 while (den==0){den=ran.nextInt(max);}
                 while (num==0){num=ran.nextInt(max);}
            return num + "/" + den;
        }

    public static String numberGenerate(int max) {
        //生成整数
        Random ran = new Random();
        return String.valueOf(ran.nextInt(max));
    }

    }
