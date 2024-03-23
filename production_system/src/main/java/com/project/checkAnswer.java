package com.project;

import cn.hutool.core.io.FileUtil;
import java.io.File;
import java.util.*;

public class checkAnswer {
              public static void  checkA(String exeFile,String answerFile,String gradeFile){
                  File file1 = FileUtil.file(exeFile);//表达式文件
                  File file2 = FileUtil.file(answerFile);//答案文件
                   if (!file1.exists() || !file2.exists())
                   {
                       System.out.println("输入的文件不存在");//文件不存在就报错
                       return;
                   }
                  List<String> expression = FileUtil.readLines(file1, "UTF-8");//读取
                  List<String> answer = FileUtil.readLines(file2, "UTF-8");

                  Queue<Integer> correctAnswer = new LinkedList<>();//正确题目的队列
                  Queue<Integer> wrongAnswer = new LinkedList<>();//错误题目的队列
                  for (int j=0;j<expression.size();j++) {
                      String[] temp;
                      temp = expression.get(j).split(" ");//去除空格
                      List<String> infix = new ArrayList<>();
                      Collections.addAll(infix, temp);
                      infix.remove(0);//去除题号
                      StringBuilder infixTemp = new StringBuilder();
                      for (String s : infix) {
                          infixTemp.append(s);
                      }//将集合转换为字符串
                      List<String> infix2 = checkAnswer.getInfixExpression(infixTemp.toString());//将连在数字旁的括号拆开并存到集合中
                      String result =InfixExpression.resultCal(InfixExpression.getSuffixExpressions(infix2));//计算结果
                      if (Objects.equals(result, answer.get(j))){
                          correctAnswer.add(j+1);//答案一致则将题号加入队列
                      }else {
                          wrongAnswer.add(j+1);
                      }
                  }
                  File grade = FileUtil.file(gradeFile);//判断对错文件

                  String cor="";
                  String wro="";
                  cor +="correct: "+correctAnswer.size()+correctAnswer+"\n";//按要求中的格式
                  wro +="wrong: "+wrongAnswer.size()+wrongAnswer+"\n";

                  FileUtil.appendUtf8String(cor,grade);//存入对应文档
                  FileUtil.appendUtf8String(wro,grade);
                  System.out.println("correct: "+correctAnswer.size()+correctAnswer);//打印结果
                  System.out.println("wrong: "+wrongAnswer.size()+wrongAnswer);
              }

    public static List<String> getInfixExpression(String str){
                  //将得到的表达式按照中缀表达式的分割后存入集合中
        List<String> infixExpression=new ArrayList<>();
        int i=0;
        StringBuilder A;
        String b= str.replace(" ","");//去除括号
        do{
            if(b.charAt(i)=='+'||b.charAt(i)=='-'||b.charAt(i)=='×'||b.charAt(i)=='÷'||b.charAt(i)=='('||b.charAt(i)==')')
            {
                infixExpression.add(""+b.charAt(i));
                i++;
            }
            else{
                A = new StringBuilder();
                while((b.charAt(i)>=48&&b.charAt(i)<=57)||b.charAt(i)=='\''||b.charAt(i)=='/')
                {
                    A.append(b.charAt(i));
                    i++;
                    if(i>=b.length())
                      break;
                }
                infixExpression.add(A.toString());
            }
        }while(i<b.length());
        return infixExpression;
    }
}
