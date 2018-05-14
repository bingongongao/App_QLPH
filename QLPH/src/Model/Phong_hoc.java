package Model;

public class Phong_hoc {
	public String Room;
	public String Class;
	public String State;
	public String Detail;

	public Phong_hoc() {

	}

	public Phong_hoc(String Room, String Class, String State, String Detail) {
		this.Room = Room;
		this.Class = Class;
		this.State = State;
		this.Detail = Detail;
	}

	public void Set_Room(String Room) {
		this.Room = Room;
	}

	public void Set_Class(String Class) {
		this.Class = Class;
	}

	public void Set_State(String State) {
		this.State = State;
	}

	public String get_Room() {
		return Room;
	}

	public String get_Class() {
		return Class;
	}

	public String get_State() {
		return State;
	}
}