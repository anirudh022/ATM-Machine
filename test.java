import java.util.*;
	public class Atm {
		public static void main(String[] args) {
			System.out.println("Welcome to ATM servce");
			int c=2;
			Scanner sc= new Scanner(System.in);
			HashMap<Integer, Integer> amnt= new HashMap<Integer, Integer>();
			amnt.put(2000, 10);
			amnt.put(500, 10);
			amnt.put(200, 10);
			amnt.put(100, 10);
			int total=28000;
			System.out.println("Initial Amount: Rs."+total+"\n");
			while(c!=0) {
				System.out.println("\nEnter action to be performed");
				System.out.println("Withdraw: 1");
				System.out.println("Add Money: 2");
				System.out.println("Check ATM Balance: 3");
				System.out.println("Exit: 0");
				c= sc.nextInt();
				if(c==1) {
					System.out.println("\nEnter ammount to withdraw: ");
					int cash= sc.nextInt();
						if(cash>total) {
						System.out.println("Insuffecient Balance. Try to withdraw a bit less money.");
					}else{
						Integer min= Collections.min(amnt.keySet());
						if(cash % min!=0){
							System.out.println("Sorry, Can't withdraw this much amount. \nPlease Enter amount ");
						}else {
							System.out.println("Cash Withdraw:");
							ArrayList<Integer> denom= new ArrayList<Integer>(amnt.keySet());
							Collections.sort(denom, Collections.reverseOrder());
							for(int i: denom){
								if(cash>=i){
									int n=cash/i;
									if(n<=amnt.get(i)) {
										System.out.println(i+": "+n);
										total=total-i*n;
										amnt.put(i,amnt.get(i)-n);
										cash=cash-i*n;
									}else {
										n=amnt.get(i);
										System.out.println(i+": "+n);
										total=total-i*n;
										amnt.put(i,amnt.get(i)-n);
										cash=cash-i*n;
									}
								}
							}
								
						}
					}
				}	
				else if(c==2) {
					System.out.println("\nEnter added Amount as per denominations:");
					for(int a : amnt.keySet()) {
						System.out.print("Enter no. of "+a+" notes: ");
						int n= sc.nextInt();
						total=total+a*n;
						amnt.put(a, amnt.get(a)+n);
					}
					System.out.println("Total Amount: Rs."+total+"\n");
				}
				else if(c==3){
					System.out.println("\nATM Balance: ");
					for(int i : amnt.keySet()) {
						System.out.println(i+": "+amnt.get(i));
					}
					System.out.println("Total Balance: "+total);
				}
				else if(c==0) {
					System.out.println("Exit! \nThank you for using our service");
				}
			else {
					System.out.println("\nEnter correct Choice\n");
				}
			}
		}
	}