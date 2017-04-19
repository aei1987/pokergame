package com.lyf.poker;

public class Card implements Comparable<Card> {
	
	private String type;
	private String number;
	
	public Card(String type, String number) {
		this.type = type;
		this.number = number;
	}
	
	public String toString() {
		return type + number;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getNumber() {
		return this.number;
	}

	@Override
	public int compareTo(Card o) {
		int flag = 0;
		int[] flagType = new int[2];
		int[] flagNumber = new int[2];
		for(int i=0; i < 13; i++) {
			if(this.number.equals(PokerPlay.NUMBERS[i])) {
				flagNumber[0] = i;
			}
		}
		for(int i=0; i < 13; i++) {
			if(o.number.equals(PokerPlay.NUMBERS[i])) {
				flagNumber[1] = i;
			}
		}
		
		if(flagNumber[0] == flagNumber[1]) {
			for(int i = 0; i < 4; i++) {
				if(this.type.equals(PokerPlay.TYPES[i])) {
					flagType[0] = i;
				}
			}
			for(int i = 0; i < 4; i++) {
				if(o.type.equals(PokerPlay.TYPES[i])) {
					flagType[1] = i;
				}
			}
			if(flagType[0] > flagType[1]) {
				flag = 1;
			} else {
				flag = -1;
			}
		} 
		else if(flagNumber[0] > flagNumber[1]) {
			flag = 1;
		} else {
			flag = -1;
		}
		return flag;
	}
	
}
