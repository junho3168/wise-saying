package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        List<Quote> quotes = new ArrayList<>(); // 명언 리스트
        Scanner scanner = new Scanner(System.in);
        int quoteId = 1; // 고유 번호

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                System.out.println("종료합니다.");
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine().trim();

                System.out.print("작가 : ");
                String author = scanner.nextLine().trim();

                quotes.add(new Quote(quoteId, content, author)); // 명언 객체 저장
                System.out.println(quoteId + "번 명언이 등록되었습니다.");
                quoteId++; // 고유 번호 증가
            } else if (cmd.equals("목록")) {
                if (quotes.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (int i = quotes.size() - 1; i >= 0; i--) { // 최신 순서로 출력
                        Quote quote = quotes.get(i);
                        System.out.printf("%d / %s / %s\n", quote.getId(), quote.getAuthor(), quote.getContent());
                    }
                }
            } else if (cmd.startsWith("삭제?id=")) {
                // 삭제 명령 처리
                try {
                    int idToDelete = Integer.parseInt(cmd.split("=")[1]); // 삭제할 ID 추출
                    boolean found = false;

                    for (int i = 0; i < quotes.size(); i++) {
                        if (quotes.get(i).getId() == idToDelete) {
                            quotes.remove(i); // 해당 명언 삭제
                            System.out.println(idToDelete + "번 명언이 삭제되었습니다.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(idToDelete + "번 명언은 존재하지 않습니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 형식입니다. 예: 삭제?id=1");
                }
            } else if (cmd.startsWith("수정?id=")) {
                // 수정 명령 처리
                try {
                    int idToModify = Integer.parseInt(cmd.split("=")[1]); // 수정할 ID 추출
                    Quote foundQuote = null;

                    for (Quote quote : quotes) {
                        if (quote.getId() == idToModify) {
                            foundQuote = quote;
                            break;
                        }
                    }

                    if (foundQuote == null) {
                        System.out.println(idToModify + "번 명언은 존재하지 않습니다.");
                    } else {
                        // 기존 명언과 작가 출력
                        System.out.println("명언(기존) : " + foundQuote.getContent());
                        System.out.print("명언 : ");
                        String newContent = scanner.nextLine().trim();

                        System.out.println("작가(기존) : " + foundQuote.getAuthor());
                        System.out.print("작가 : ");
                        String newAuthor = scanner.nextLine().trim();

                        // 수정
                        foundQuote.setContent(newContent);
                        foundQuote.setAuthor(newAuthor);
                        System.out.println(idToModify + "번 명언이 수정되었습니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 형식입니다. 예: 수정?id=1");
                }
            } else {
                System.out.println("알 수 없는 명령입니다.");
            }
        }

        scanner.close();
    }
}

// 명언 클래스
class Quote {
    private int id;          // 고유 번호
    private String content;  // 명언 내용
    private String author;   // 작가

    public Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
