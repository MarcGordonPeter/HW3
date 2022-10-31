package de.uni.koeln.se.state;

public class Elevator {

	public static int current_Floor = 5;
	int dest_Floor;

	private Elv_States State = new Elv_States();

	public Elevator(int dest_floor) {
		this.dest_Floor = dest_floor;
		System.out.println("*** Destination floor is: " + dest_Floor);
		if (current_Floor < dest_floor) {
			State.currentState = State.Moving_up;
			go_up();
		} else if (current_Floor > dest_floor) {
			State.currentState = State.Moving_down;
			go_down();
		} else {
			exit();
		}
	}

	private void exit() {
		System.out.println("Etage: " + current_Floor);
		System.out.println("Bitte aussteigen");
	}

	private void go_down() {
		System.out.println(State.currentState);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		current_Floor--;
		System.out.println("Etage: " + current_Floor);
		if (current_Floor > dest_Floor) {
			go_down();
		} else {
			arrive_to_floor();
		}
	}

	private void go_up() {
		System.out.println(State.currentState);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Etage: " + current_Floor);
		current_Floor++;
		if (current_Floor < dest_Floor) {
			go_up();
		} else {
			arrive_to_floor();
		}
	}

	private void arrive_to_floor() {
		State.currentState = State.Idle;
		System.out.println(State.currentState);
		exit();
	}

}
