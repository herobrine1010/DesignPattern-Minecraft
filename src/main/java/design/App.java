package design;


import java.util.Scanner;

public class App
{

    private static Scanner scanner= new Scanner(System.in);






    public static void main( String[] args ) {


        System.out.println("======================================");
        System.out.println("======= Welcome to Minecraft! =======");
        System.out.println("======================================");
        System.out.println("*          1. 查看背包物品           *");
        System.out.println("*          9. 进入矿区           *");
        System.out.println("*          9. 进入农场farm           *");
        System.out.println("*          9. 一天过去了...           *");
        System.out.println("*          9. 一天过去了...           *");
        System.out.println("*          9. 一天过去了...           *");
        System.out.println("*          9. 一天过去了...           *");
        System.out.println("*          0. 退出                   *");
        System.out.println("======================================");
        System.out.println("请选择：");

        String input = "0";
        if (scanner.hasNext()) {
            input = scanner.next();
        }
        while (!input.equals("0")) {

            switch (input) {

                default:
                    System.out.println("非合法输入，请重新输入：");
                    break;
            }
            if (scanner.hasNext()) {
                input = scanner.next();
            }

            scanner.close();
        }
    }
}
