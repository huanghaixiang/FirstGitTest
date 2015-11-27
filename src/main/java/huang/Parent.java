package huang;

public class Parent {
	private String name = "parent";
	public Parent(){
		callName();
	}
	public void callName(){
		System.out.println(name);
	}
	static class Child extends Parent{
		private String name ="child";
		public void callName(){
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		Parent p = new Child();
	}

}
