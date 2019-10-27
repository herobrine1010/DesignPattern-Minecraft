package design;


import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("======= Welcome to Minecraft! ========");
        System.out.println("======================================");
        System.out.println("*          1. 查看背包物品             *");
        System.out.println("*          9. 进入矿区                 *");
        System.out.println("*          9. 进入农场farm             *");
        System.out.println("*          9. 一天过去了...            *");
        System.out.println("*          9. 一天过去了...            *");
        System.out.println("*          9. 一天过去了...            *");
        System.out.println("*          9. 一天过去了...            *");
        System.out.println("*          0. 退出                    *");
        System.out.println("======================================");
        System.out.println("请选择：");

        mainMenuLoop:
        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "0":
                    System.out.println("再见～");
                    break mainMenuLoop;
                default:
                    System.out.println("输入不合法，请重试");
            }
        }

        scanner.close();
    }
}

