package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
	Player[] player=new Player[4];
	Card[] deck=new Card[52];
	int Highscore=0;
	public void generatedeck() {
		
		for(int i=0;i<52;i++){
			int c=i+1;
			if(i<13) {
				if(c>=10)
					{c=10;}
				deck[i]=new Card(0,i,c);
			}
			if(i>=13&&i<26) {
				c=c-13;
				if(c>=10)
					{c=10;}
				deck[i]=new Card(1,i-13,c);
			}
			if(i>=26&&i<39) {
				c=c-26;
				if(c>=10)
					{c=10;}
				deck[i]=new Card(2,i-26,c);
			}
			if(i>=39&&i<52) {
				c=c-39;
				if(c>=10)
					{c=10;}
				deck[i]=new Card(3,i-39,c);
			}	
		}
		}
		public Card drawcard() {
			Random rand=new Random();
			int randomchoice=rand.nextInt(52);
			while(true) {
				if(deck[randomchoice]==null) {
					randomchoice=rand.nextInt(52);
				}
				else
				{
					Card newcard=deck[randomchoice];
					deck[randomchoice]=null;
					return newcard;
					
				}
			}
		}
		public void setinfo() {
			Scanner p=new Scanner(System.in);
			player[3]=new Player("Dealer");
			player[3].getHandcard()[0]=this.drawcard();
			player[3].getHandcard()[1]=this.drawcard();
			player[3].Score=player[3].getHandcard()[0].getValue()+player[3].getHandcard()[1].getValue();
			for(int i=0;i<3;i++) {
				
				System.out.println("Enter Player "+ (i+1) +" Name:");
				player[i]=new Player(p.next());
				player[i].getHandcard()[0]=this.drawcard();
				player[i].getHandcard()[1]=this.drawcard();
				player[i].Score=player[i].getHandcard()[0].getValue()+player[i].getHandcard()[1].getValue();
			}
			
		}
		
		public void updateHighScore() {
			
			 for(int i=0;i<3 ;i++) {
				 if(player[i].Score>Highscore) {
					if(player[i].Score<=21) {
						Highscore=player[i].Score;
					}
				}
			}
		}
	
			
	}


