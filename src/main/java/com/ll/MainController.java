package com.ll;

import java.util.Scanner;

public class MainController {
    private QuoteService service;

    public MainController() {
        this.service = new QuoteService();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            switch (cmd) {
                case "종료":
                    System.out.println("종료합니다.");
                    return;
                case "등록":
                    handleRegister(scanner);
                    break;
                case "목록":
                    service.listQuotes();
                    break;
                default:
                    if (cmd.startsWith("삭제?id=")) {
                        handleDelete(cmd);
                    } else if (cmd.startsWith("수정?id=")) {
                        handleModify(cmd, scanner);
                    } else {
                        System.out.println("알 수 없는 명령입니다.");
                    }
            }
        }
    }

    private void handleRegister(Scanner scanner) {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();
        service.addQuote(content, author);
    }

    private void handleDelete(String cmd) {
        try {
            int id = Integer.parseInt(cmd.split("=")[1]);
            service.deleteQuote(id);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식입니다. 예: 삭제?id=1");
        }
    }

    private void handleModify(String cmd, Scanner scanner) {
        try {
            int id = Integer.parseInt(cmd.split("=")[1]);
            System.out.print("명언 : ");
            String newContent = scanner.nextLine().trim();
            System.out.print("작가 : ");
            String newAuthor = scanner.nextLine().trim();
            service.modifyQuote(id, newContent, newAuthor);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식입니다. 예: 수정?id=1");
        }
    }
}

