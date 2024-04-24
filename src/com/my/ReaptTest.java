package com.my;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ReaptTest {
    public static void main(String[] args) {
        System.out.println("Task: remove 3 or more consecutive character repeatedly");
        Scanner scan =  new Scanner(System.in);
        System.out.println("Please input a String :");
        String input = scan.nextLine();
        scan.close();
        System.out.println("The execution results are as follows :");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dealStrTask(input);
                System.out.println("定时任务结束，线程终止");
                this.cancel(); // 取消定时任务
                System.exit(0); // 终止JVM
            }
        }, 5 * 1000); // 延迟指定秒数后执行
    }

        //remove 3 or more consecutive character repeatedly
        public static void dealStrTask(String result) {
            while(true){
                int len = result.length();
                for (int i=0;i<len;i++){
                    char character = result.charAt(i);
                    if(i+2>=len){
                        break;
                    }
                    if (character == result.charAt(i+1) && character == result.charAt(i+2)){
                        result = result.replace(""+character+character+character,"");
                        System.out.println(result);
                        break;
                    }
                }
                try {
                    TimeUnit.MICROSECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
