package com.project;

public class calculate {
//num分子，den分母
    public static String Simplify(int num,int den){
    int remainder;//余数
    int quotient;//商

    if(num/den == 0) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0 && den % i == 0) {
                num = num / i;
                den = den / i;
                i = 1;//当取到公约数时i置为0
            }
        }
        return num + "/" + den;
    }else{
       remainder = num%den;//余数
       quotient = num/den;//商
       if(remainder == 0){//刚好整除
           return quotient + "";
       } else{
           //约分
           for (int i = 1; i <= remainder; i++) {
               if (remainder % i == 0 && den % i == 0) {
                   remainder = remainder / i;
                   den = den / i;
                   i = 1;//当取到公约数时i置为0
               }
           }
           return quotient+"'"+ remainder + "/" + den;
       }





    }

 }

    public static  String numConvert(String num){
        //判断num是整数，分数，还是带分数，最后统一转换为分数
        boolean flag1 = num.contains("/");
        if(!flag1){
            //判断为整数
            return num+"/"+1;
        }else {
            boolean flag2 = num.contains("'");//判断是否为带分数
            if (!flag2){
                //不是带分数则为真分数，直接返回
                return num;
            }else {
                //是带分数
                //1、分割字符
                String[] xin1 = num.split("'");
                int real_num1 = Integer.parseInt(xin1[0]);//得到带分数的整数部分
                String[] xin2 = xin1[1].split("/");
                int fenMu = Integer.parseInt(xin2[1]);
                int fanZine = Integer.parseInt(xin2[0]);
                fanZine = fanZine+fenMu*real_num1;
                return fanZine+"/"+fenMu;
            }
        }

    }
    //num1,num2
    public static String  numberCalculate(String num1,String num2,String sign){

        //1、判断是整数还是分数，带分数？并进行转换成分数，如: 22/11
        String num1_temp =  numConvert(num1);
        String num2_temp = numConvert(num2);
        //2、切割并进行运算
        String[]num1_arr = num1_temp.split("/");
        int num_11 = Integer.parseInt(num1_arr[0]);//第一个数分子
        int num_12 = Integer.parseInt(num1_arr[1]);//第一个数分母

        String[]num2_arr = num2_temp.split("/");
        int num_21 = Integer.parseInt(num2_arr[0]);//第二个数分子
        int num_22 = Integer.parseInt(num2_arr[1]);//第二个数分母

        switch (sign) {
            case "+":
                return Simplify(((num_11 * num_22) + (num_21 * num_12)), ((num_12 * num_22)));
            case "-":
                if (((num_11 * num_22) - (num_21 * num_12)) < 0) {

                    return null;
                }
                return Simplify(((num_11 * num_22) - (num_21 * num_12)), ((num_12 * num_22)));
            case "×":

                return Simplify((num_11 * num_21), (num_12 * num_22));
            case "÷":
                return Simplify(num_11 * num_22, num_12 * num_21);
        }
        return "";
    }
}
