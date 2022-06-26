 package blackjack;

import java.util.Scanner;

public class BlackJack {
	static Game game=new Game();
	
	public static void main(String args[]) {
		GUI gui = new GUI();
		game.generatedeck();
		game.setinfo();
		gui.runGUI(game.deck
				,game.player[0].getHandcard()
				,game.player[1].getHandcard()
				,game.player[2].getHandcard()
				,game.player[3].getHandcard());
		playerturn(gui);
		dealerturn(gui);
		gameResults();
	}
	public static void addcard(int i,int j) {//this fucntion to add random card to player hand if he hit
			Card drawedcard=game.drawcard();
			game.player[i].getHandcard()[j]=drawedcard;

	}
	public static void playerturn(GUI gui) { /*this fucntion to ask the player if he want to hit 
	or stand and if he hit it add random card to his hand and it update his score and update the highscore and check if he busted or blackjack*/
		Scanner answer=new Scanner(System.in);
		for(int i=0;i<3;i++) {
			int j=2; //this counter start from 2 because the player start with 2 cards in handcard[0] and handcard[1]
			while(true){
				//the player press 1 to hit and 0 to stand
				System.out.println("Player " +(i+1)+ " Do You Want To Hit(1) Or Stand(0) ?");
				int input=answer.nextInt();
				if(input==1) {
					addcard(i, j);
					game.player[i].Score+=game.player[i].getHandcard()[j].getValue();
					gui.updatePlayerHand(game.player[i].getHandcard()[j],i);
					game.updateHighScore();
					j++;
				}
				
				else if(input==0) {
					break;
				}
				if(game.player[i].Score>21) {
					System.out.println(game.player[i].getName()+" is Busted");
					game.player[i].busted=true;
					break;
				}
			    else if(game.player[i].Score==21) {
			    	System.out.println(game.player[i].getName()+" is BlackJack");
			    	game.player[i].blackjack=true;
					break;
			    }
			}}
		}
		
		
		public static void dealerturn(GUI gui) { /*this fucnction to make the dealer draw cards 
		and check if the game is push or not and check who is the winner and if the dealer busted*/
			
			int bustd=0; //first if all player are busted the dealer dont have to draw any cards and he is the winner!
			for(int i=0;i<3;i++){
				if(game.player[i].busted==true)
					bustd++;
			}
			if(bustd==3){
				System.out.println("Dealer Win");
			}
			else if(game.player[3].Score<game.Highscore&&game.Highscore==21){
				int j=2;
				while(true){
					addcard(3, j);
					game.player[3].Score+=game.player[3].getHandcard()[j].getValue();
					gui.updateDealerHand(game.player[3].getHandcard()[j],game.deck);
					game.updateHighScore();
					j++;
					if(game.player[3].Score>21){/*this condition to check if the dealer is busted 
					or blackjack and check if the game is push and who is the winner!*/
						
						System.out.println("Dealer busted");
						int x=0;
						for(int i=0;i<3;i++){
							if(game.player[i].Score==game.Highscore){
								x++;
							}
						}
						if(x>1){
							System.out.println("Push!");
							}
						else{ 
							for(int i=0;i<3;i++){
								if(game.player[i].Score==game.Highscore){
									System.out.println(game.player[i].getName()+" Win");}
								}	
							}
						break;
					}
					if(game.player[3].Score==21){
						System.out.println("Dealer is BlackJack");
						System.out.println("Push!");
						break;
					}
				}
			}
			
					else if(game.player[3].Score>game.Highscore&&game.Highscore<21){
						System.out.println("Dealer Win");
					}
					else if(game.player[3].Score<=game.Highscore&&game.Highscore<21){
						int j=2;
					while(true){
						addcard(3, j);
						game.player[3].Score+=game.player[3].getHandcard()[j].getValue();
						gui.updateDealerHand(game.player[3].getHandcard()[j],game.deck);
						game.updateHighScore();
						j++;
					if(game.player[3].Score>21){
						System.out.println("Dealer busted");
						int x=0;
						for(int i=0;i<3;i++){
							if(game.player[i].Score==game.Highscore){
								x++;
							}
						}
						if(x>1){
							System.out.println("Push!");
						}
						else{ 
							for(int i=0;i<3;i++){
								if(game.player[i].Score==game.Highscore)
									System.out.println(game.player[i].getName()+" Win");}	
						}
						break;
					}
					if(game.player[3].Score==21){
						System.out.println("Dealer is BlackJack");
						System.out.println("Dealer Win");
						break;
					}
				}
				}
				}

				
		
	public static void gameResults(){//this fucntion to display the leaderboard
		System.out.println("Game Results:");
		for(int i=0;i<4;i++){
			
			System.out.println(game.player[i].getName()+" Score:"+game.player[i].Score);
			
		}

	}	
	
	
}
