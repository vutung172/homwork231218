package com.assignment.unit2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GiftConfig gift1 = new GiftConfig("sv1","gift1",false,1.5,2,2);
        Player player1 = new Player("p1","tung");

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Trả quà");
            System.out.println("2. Xem lịch sử");
            System.out.println("3. Thoát");
            int c = Integer.parseInt(sc.nextLine());
            switch (c){
                case 1:
                    System.out.println("Mời nhập mã người chơi");
                    String id = sc.nextLine();

                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
