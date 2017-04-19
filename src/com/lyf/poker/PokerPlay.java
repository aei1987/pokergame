package com.lyf.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PokerPlay {
	
	public static final String[] TYPES = {"方片", "梅花", "红桃", "黑桃"};
	public static final String[] NUMBERS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	
	private List<Card> poker = null;
	private List<Player> players = null;
	
	public PokerPlay() {
		this.poker = new ArrayList<Card>();
		this.players = new ArrayList<Player>();
	}
	
	public void createPoker() {
		System.out.println("扑克牌创建中");
		for(int i = 0; i < TYPES.length; i++) {
			for(int j = 0; j < NUMBERS.length; j++) {
				poker.add(new Card(TYPES[i], NUMBERS[j]));
			}
		}
		System.out.println("扑克牌创建成功");
	}
	
	public void showPoker() {
		for (Card card : poker) {
			System.out.print(card.getType() + card.getNumber() + " ");
		}
		System.out.println();
	}
	
	public void shufflePoker() {
		System.out.println("开始洗牌");
		Collections.shuffle(poker);
		System.out.println("洗牌结束");
	}
	
	public void addPlayer() {
		int id;
		String name;
		System.out.println("开始添加玩家");
		Scanner console = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			while(true) {
				System.out.println("请输入第" + (i+1) + "位玩家的ID");
				try {
					id = console.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("请输入整型数据ID");
					console = new Scanner(System.in);
					continue;
				} 
			}
			System.out.println("请输入第" + (i+1) + "位玩家的姓名");
			name  = console.next();
			players.add(new Player(id, name));
		}
		console.close();
		System.out.println("玩家添加结束");
	}
	
	public void showPlayer() {
		for (Player player : players) {
			System.out.println("欢迎玩家" + player.getName());
		}
	}
	
	public void dealCard() {
		System.out.println("开始发牌");
		for(int i = 0, k = 0; i < 4; i++,k--) {
			for(int j = 0; j < players.size(); j++,k++) {
				System.out.println("玩家" + players.get(j).getName() + "拿牌:" + poker.get(i+k).getType() + poker.get(i+k).getNumber());
				players.get(j).getCards().add(poker.get(i+k));
			}
		}
		System.out.println("发牌结束");
	}
	
	public void showPlayerCard() {
		for (Player player : players) {
			System.out.print("玩家" + player.getName() + "手牌为：[");
			for(Card card : player.getCards()) {
				System.out.print(card.getType() + card.getNumber() + " ");
			}
			System.out.println("]");
		}
	}
	
	public void compareWinner() {
		Card max = new Card("方片", "2");
		int winner = 0;
		for(int i = 0; i < players.size(); i++) {
			Collections.sort(players.get(i).getCards());
			Collections.reverse(players.get(i).getCards());
			Card maxCard = players.get(i).getCards().get(0);
			System.out.println("玩家" + players.get(i).getName() + "最大手牌为:" + maxCard.getType() + maxCard.getNumber());
			if(max.compareTo(maxCard) < 0) {
				max = maxCard;
				winner = i;
			}
		}
		System.out.println("玩家" + players.get(winner).getName() + "获胜");
	}
	
	public static void main(String[] args) {
		PokerPlay pokerplay = new PokerPlay();
		pokerplay.createPoker();
		pokerplay.showPoker();
		pokerplay.shufflePoker();
		pokerplay.showPoker();
		pokerplay.addPlayer();
		pokerplay.showPlayer();
		pokerplay.dealCard();
		pokerplay.showPlayerCard();
		pokerplay.compareWinner();
	}
	
}
