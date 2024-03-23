package com.project;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class generate {
    public static List<String> generateExpress(int max) {

        Random ran = new Random();

        String[] sign = {"+", "-", "×", "÷"};//运算符
        String e1="" , e2="" , e3="" , e4="";//初始化
        String s1= sign[ran.nextInt(4)],s2=sign[ran.nextInt(4)], s3=sign[ran.nextInt(4)];
        /* 符号初始化 */

        String[] num = {e1, e2, e3, e4};//存数字
       String[] sign1={s1,s2,s3};//存运算符
        List<String> a=new ArrayList<>();//存放算式

        int[] e = {0, 1};//
             for (int i = 0; i < num.length; i++)
        {
            int y = e[ran.nextInt(2)];//y随机赋值成0或者1，为0则生成整数，否则生成分数

            if (y == 0) {
                num[i]=numberGenerate(max);//随机生成整数
            }
            else {num[i] = fractionGenerate(max);//随机生成分数（包括真分数）
            }
        }

           for (int i = 0; i < sign1.length; i++)//判断÷号后面的数字是否为0，实则重新生成，直到不为0
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

              return a;
        }


        public static String listToString(int i,List<String> expression) {
            StringBuilder str = new StringBuilder();
            str.append(i+1);
            str.append(": ");
            //list转换成String并在开头添加题号和符号前后添加空格
            for (String s : expression) {
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
                 int num=ran.nextInt(max);int den=ran.nextInt(max);
                 while (den==0){den=ran.nextInt(max);}//控制分子分母不为0
                 while (num==0){num=ran.nextInt(max);}
            return calculate.Simplify(num, den);//返回化简后的值
        }

    public static String numberGenerate(int max) {
        //生成整数
        Random ran = new Random();
        return String.valueOf(ran.nextInt(max));//随机生成整数
    }

     public static void repeat(int count,int max,String exeFile,String ansFile){
        //count为生成题目的数量，max为数字的最大范围，exeFile和ansFile分别为要存入的表达式文件路径和答案路径
         String string,result;//string存放表达式，result存放结果

         for (int i = 0; i <count;i++)
         {   List<String> list;

             list=generate.generateExpress(max);
             result= InfixExpression.resultCal(InfixExpression.getSuffixExpressions(list));
             while (result==null){//结果出现负数，重新生成表达式直到没有负数产生
                 list=generate.generateExpress(max);
                 result= InfixExpression.resultCal(InfixExpression.getSuffixExpressions(list));
             }
             string = generate.listToString(i,list);//将表达式添加空格和题号



             File file1 = FileUtil.file(exeFile);File file2 = FileUtil.file(ansFile);//将路径变成文件对象
             if (!file1.exists() || !file2.exists())
             {
                 System.out.println("输入的文件不存在");//文件不存在就报错
                 return;
             }
             System.out.println(string+" = ");//打印表达式
             FileUtil.appendUtf8String(string+"\n",file1);FileUtil.appendUtf8String(result+"\n",file2);//写入文件
         }
     }
    }
