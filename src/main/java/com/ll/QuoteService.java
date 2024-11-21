package com.ll;

import java.util.ArrayList;
import java.util.List;

public class QuoteService {
        private List<Quote> quotes = new ArrayList<>();
        private int quoteId = 1;

        public void addQuote(String content, String author) {
            quotes.add(new Quote(quoteId++, content, author));
            System.out.println((quoteId - 1) + "번 명언이 등록되었습니다.");
        }

        public void listQuotes() {
            if (quotes.isEmpty()) {
                System.out.println("등록된 명언이 없습니다.");
            } else {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = quotes.size() - 1; i >= 0; i--) { // 최신순
                    Quote q = quotes.get(i);
                    System.out.printf("%d / %s / %s\n", q.getId(), q.getAuthor(), q.getContent());
                }
            }
        }

        public void deleteQuote(int id) {
            boolean found = false;
            for (int i = 0; i < quotes.size(); i++) {
                if (quotes.get(i).getId() == id) {
                    quotes.remove(i);
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(id + "번 명언은 존재하지 않습니다.");
            }
        }

        public void modifyQuote(int id, String newContent, String newAuthor) {
            for (Quote quote : quotes) {
                if (quote.getId() == id) {
                    quote.setContent(newContent);
                    quote.setAuthor(newAuthor);
                    System.out.println(id + "번 명언이 수정되었습니다.");
                    return;
                }
            }
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

