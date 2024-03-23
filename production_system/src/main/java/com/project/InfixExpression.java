package com.project;

import java.util.ArrayList;
import java.util.List;

public class InfixExpression {
//采用类似入栈出栈的方法(此处用集合代替栈),将中缀表达式转换成后缀表达式然后进行计算
          public static List<String> getSuffixExpressions(List<String> l)//将中缀表达式转换成后缀表达式后存到一个集合中并返回
          {
                  List<String> list1= new ArrayList<>();//存放符号
                  List<String> list2= new ArrayList<>();//存放后缀表达式
                   for (String item : l){
                       if (!(item.equals("+")||item.equals("-")||item.equals("×")||item.equals("÷")||item.equals("(")||item.equals(")"))) {
                           list2.add(item);//识别是否为数字
                       }else if (item.equals("(")){
                           list1.add(item);
                       }else if(item.equals(")")){
                            while(!list1.get(list1.size()-1).equals("(")&&!list1.isEmpty()){
                                list2.add(list1.get(list1.size()-1));
                                list1.remove(list1.size()-1);
                            }
                            list1.remove(list1.size()-1);
                       }else {
                           while (!list1.isEmpty()&&Operation.getValue(list1.get(list1.size()-1))>=Operation.getValue(item)){
                               //判断是否栈空或者优先级够不够
                               list2.add(list1.get(list1.size()-1));
                               list1.remove(list1.size()-1);
                           }
                           list1.add(item);
                       }
                   }
                   while (!list1.isEmpty()){
                       list2.add(list1.get(list1.size()-1));
                       list1.remove(list1.size()-1);
                   }
                  return list2;
          }

          public static String resultCal(List<String> list){
              List<String> list3 = new ArrayList<>();//存放数字
                for (String ele : list){
                    if (!(ele.equals("+")||ele.equals("-")||ele.equals("×")||ele.equals("÷"))){
                        list3.add(ele);//不是符号则入栈
                }else {
                    String num2=list3.get(list3.size()-1);list3.remove(list3.size()-1);//取尾元素并删除，即出栈
                    String num1=list3.get(list3.size()-1);list3.remove(list3.size()-1);
                    String res;//存放两数运算的结果
                    res=calculate.numberCalculate(num1,num2,ele);
                    if(res==null){
                        return null;//出现负数则返回null
                    }
                    list3.add(res);
                    }
                }
                    return list3.get(list3.size()-1);
          }

          static class Operation{
              public  static  int getValue(String ess){
                  int res= 0;//为符号添加优先权值
                  switch (ess){
                      case "+", "-":
                          res=1;
                          break;
                      case "×", "÷":
                          res=2;
                          break;
                      default:
                          break;
                  }
                  return  res;
              }
          }
}
