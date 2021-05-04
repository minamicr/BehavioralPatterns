package br.com.cod3r.chain.billsDispenser;

public class Client {

	public static void main(String[] args) {
		Dispenser atm = new Dispenser();
		System.out.println("Withdrawing 230");
		atm.withdraw(230);
		System.out.println("-----------");
		System.out.println("Withdrawing 66");
		atm.withdraw(66);
		System.out.println("-----------");

		System.out.println("Withdrawing 251");
		Dispenser customAtm = new Dispenser(new Bill(51), new Bill(41),
				new Bill(31), new Bill(21), new Bill(11), new Bill(1));
		customAtm.withdraw(251);

	}
}
