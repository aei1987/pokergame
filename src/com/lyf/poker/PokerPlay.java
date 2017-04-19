package com.lyf.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PokerPlay {
	
	public static final String[] TYPES = {"��Ƭ", "÷��", "����", "����"};
	public static final String[] NUMBERS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	
	private List<Card> poker = null;
	private List<Player> players = null;
	
	public PokerPlay() {
		this.poker = new ArrayList<Card>();
		this.players = new ArrayList<Player>();
	}
	
	public void createPoker() {
		System.out.println("�˿��ƴ�����");
		for(int i = 0; i < TYPES.length; i++) {
			for(int j = 0; j < NUMBERS.length; j++) {
				poker.add(new Card(TYPES[i], NUMBERS[j]));
			}
		}
		System.out.println("�˿��ƴ����ɹ�");
	}
	
	public void showPoker() {
		for (Card card : poker) {
			System.out.print(card.getType() + card.getNumber() + " ");
		}
		System.out.println();
	}
	
	public void shufflePoker() {
		System.out.println("��ʼϴ��");
		Collections.shuffle(poker);
		System.out.println("ϴ�ƽ���");
	}
	
	public void addPlayer() {
		int id;
		String name;
		System.out.println("��ʼ������");
		Scanner console = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			while(true) {
				System.out.println("�������" + (i+1) + "λ��ҵ�ID");
				try {
					id = console.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("��������������ID");
					console = new Scanner(System.in);
					continue;
				} 
			}
			System.out.println("�������" + (i+1) + "λ��ҵ�����");
			name  = console.next();
			players.add(new Player(id, name));
		}
		console.close();
		System.out.println("�����ӽ���");
	}
	
	public void showPlayer() {
		for (Player player : players) {
			System.out.println("��ӭ���" + player.getName());
		}
	}
	
	public void dealCard() {
		System.out.println("��ʼ����");
		for(int i = 0, k = 0; i < 4; i++,k--) {
			for(int j = 0; j < players.size(); j++,k++) {
				System.out.println("���" + players.get(j).getName() + "����:" + poker.get(i+k).getType() + poker.get(i+k).getNumber());
				players.get(j).getCards().add(poker.get(i+k));
			}
		}
		System.out.println("���ƽ���");
	}
	
	public void showPlayerCard() {
		for (Player player : players) {
			System.out.print("���" + player.getName() + "����Ϊ��[");
			for(Card card : player.getCards()) {
				System.out.print(card.getType() + card.getNumber() + " ");
			}
			System.out.println("]");
		}
	}
	
	public void compareWinner() {
		Card max = new Card("��Ƭ", "2");
		int winner = 0;
		for(int i = 0; i < players.size(); i++) {
			Collections.sort(players.get(i).getCards());
			Collections.reverse(players.get(i).getCards());
			Card maxCard = players.get(i).getCards().get(0);
			System.out.println("���" + players.get(i).getName() + "�������Ϊ:" + maxCard.getType() + maxCard.getNumber());
			if(max.compareTo(maxCard) < 0) {
				max = maxCard;
				winner = i;
			}
		}
		System.out.println("���" + players.get(winner).getName() + "��ʤ");
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
