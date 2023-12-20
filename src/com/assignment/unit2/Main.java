package com.assignment.unit2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static <K,V> void main(String[] args) {
        //Quà có giá trị
        GiftConfig gift1 = new GiftConfig("GIFT1","gift1",false,1.5,2);
        GiftConfig gift2 = new GiftConfig("GIFT2","gift2",false,10.5,2);
        GiftConfig gift3 = new GiftConfig("GIFT3","gift3",false,27.5,7);
        GiftConfig gift4 = new GiftConfig("GIFT4","gift4",false,25,6);
        GiftConfig gift5 = new GiftConfig("GIFT5","gift5",false,50,10);

        //Quà không giá trị
        GiftConfig giftFree = new GiftConfig("GIFTFREE","giftfree",true,100,0);

        //Player
        Player player1 = new Player("p1","tung");
        Player player2 = new Player("p2","nam");
        Player player3 = new Player("p3","trung");
        Player player4 = new Player("p4","thang");

        List<GiftConfig> gifts = new ArrayList<>();
        List<GiftConfig> freeGifts = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        List<GiftHistory> histories = new ArrayList<>();

        gifts.add(gift1);
        gifts.add(gift2);
        gifts.add(gift3);
        gifts.add(gift4);
        gifts.add(gift5);
        freeGifts.add(giftFree);

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

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
                    GiftHistory history = new GiftHistory();
                    players.forEach( player -> {
                        if (player.getPlayerCode().equals(id)) {
                            history.setPlayerCode(player.getPlayerCode());
                        }
                    } );

                    if (history.getPlayerCode() == null)
                        {System.out.println("Người chơi không tồn tại");break;}
                    else {
                        GiftConfig gift;
                        gift = randomSelectGift(gifts);
                        if (gift == null) {
                            freeGifts.getFirst().setLimitPlayer(freeGifts.getFirst().getLimitPlayer()+1);
                            gift = freeGifts.getFirst();
                        }
                        history.setGiftCode(gift.getGiftcode());
                        System.out.println("Đã phát quà");
                    }
                    histories.add(history);
                    histories.forEach(GiftHistory::output);
                  /*  gifts.forEach(GiftConfig::output);
                    freeGifts.forEach(GiftConfig::output);*/
                    break;
                case 2:
                    System.out.println("Nhập vào ID player muốn kiểm tra");
                    id = sc.nextLine();
                    Set<String> playerCode = new HashSet<>();
                    histories.forEach(x -> playerCode.add(x.getPlayerCode()));
                    playerCode.forEach(x-> {
                        if (x.equals(id)) {
                            players.forEach(player -> {
                                if (player.getPlayerCode().equals(x)){
                                    System.out.println(x+":"+player.getPlayerName());
                                }
                            });
                            Map<String, Integer> giftCount = new HashMap<>();

                            histories.forEach(player -> {
                                if (player.getPlayerCode().equals(x)) {
                                    String key = player.getGiftCode();
                                    int count =0;
                                    if (giftCount.get(key) != null){
                                        giftCount.put(key,giftCount.get(key)+1);
                                    } else {
                                        giftCount.put(key, count);
                                    }
                                }
                            });
                            Set<String> setCount = giftCount.keySet();
                            setCount.forEach(s -> System.out.println("Tên quà: "+s+": Số lượng:"+giftCount.get(s)));
                        }
                    });


                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static GiftConfig  randomSelectGift(List<GiftConfig> lists){
        Random random = new Random();
        int i = ThreadLocalRandom.current().nextInt(lists.size());
        GiftConfig gift = lists.get(i);
        if(gift.getLimitPlayer() < gift.getLimitTotal()){
            gift.setLimitPlayer(gift.getLimitPlayer()+1);
            return gift;
        }
        return null;
    }
}
