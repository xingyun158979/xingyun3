package com.project;


public class Main {
    public static void main(String[] args) {

         int count=0,maxValue=0;
        String subjectPath=null,answerPath=null;
          for(int i=0;i<args.length;i++){
              switch (args[i]) {
                  case "-n" -> count = Integer.parseInt(args[i + 1]);
                  case "-r" -> maxValue = Integer.parseInt(args[i + 1]);
                  case "-e" -> subjectPath = args[i + 1];
                  case "-a" -> answerPath = args[i + 1];
              }
         }

          if(count>0&&maxValue>0) {
              generate.repeat(count,maxValue,"src/txtFile/Exercises.txt","src/txtFile/Answers.txt");
        }else if(count<0||maxValue<0) {
              System.out.println("请输入正整数");
        } else if(subjectPath!=null&&answerPath!=null){
               checkAnswer.checkA(subjectPath,answerPath,"src/txtFile/Grade.txt");
       }
    }
}