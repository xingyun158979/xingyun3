package com.project;


public class Main {
    public static void main(String[] args) {

         int count=0,maxValue=0;
        String subjectPath=null,answerPath=null;
          for(int i=0;i<args.length;i++){
            if(args[i].equals("-n")){
          count=Integer.parseInt(args[i+1]);
              }else if(args[i].equals("-r"))
          {
            maxValue=Integer.parseInt(args[i+1]);
           }else if(args[i].equals("-e")){
           subjectPath=args[i+1];

           }else if(args[i].equals("-a")){
           answerPath=args[i+1];
           }
         }

          if(count>0&&maxValue>0) {
              generate.repeat(count,maxValue);
        }else if(subjectPath!=null&&answerPath!=null){
               checkAnswer.checkA(subjectPath,answerPath);
       }
    }
}