package com.ll;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int age = 50;
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        //스캐너 생성 (키보드 입력 스캔, 파이썬 인풋같은거)
        Scanner scanner = new Scanner(System.in);


        System.out.print("명령) ");
        String cmd = scanner.nextLine();

        System.out.println("입력된 명령어 : %s".formatted(cmd));

        scanner.close();
        System.out.println("종료합니다");
    }
}