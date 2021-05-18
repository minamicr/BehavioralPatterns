package br.com.cod3r.observer.party;


import br.com.cod3r.observer.party.observers.Friend;
import br.com.cod3r.observer.party.observers.Wife;
import br.com.cod3r.observer.party.subject.Doorman;

public class Client {

	public static void main(String[] args) {
		Doorman reception = new Doorman();
		Wife wife = new Wife();
		Friend friend = new Friend();

		reception.add(wife);
		reception.add(friend);

		reception.setStatus(false);
		reception.setStatus(false);
		reception.setStatus(true);
		reception.setStatus(false);
		reception.setStatus(true);
		reception.setStatus(true);


	}
}
