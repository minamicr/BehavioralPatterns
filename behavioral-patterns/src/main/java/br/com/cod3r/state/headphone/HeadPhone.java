package br.com.cod3r.state.headphone;

import br.com.cod3r.state.headphone.states.HPState;
import br.com.cod3r.state.headphone.states.OffState;

public class HeadPhone {
	private HPState state;
	private boolean isOn;
	private boolean isPlaying;

	public HeadPhone(){
		isOn = false;
		isPlaying = false;
		state = OffState.getInstance();
	}

	public void onLongClick(){
		System.out.println("Long click pressed");
		state.longClick(this);
	}

	public void onClick() {
		System.out.println("Click pressed");
		state.click(this);
	}

	public void setState(HPState state){
		System.out.println(String.format("Changing from %s to %s",
				this.state.getClass().getSimpleName(),
				state.getClass().getSimpleName()));
		this.state = state;

	}

	public HPState getState(){
		return this.state;
	}

	public boolean isOn(){
		return isOn;
	}

	public void setOn(boolean isOn){
		this.isOn = isOn;
	}

	public boolean isPlaying(){
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying){
		this.isPlaying = isPlaying;
	}

}
