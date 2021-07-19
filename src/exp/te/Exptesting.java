package exp.te;

public class Exptesting {

	public static void main(String[] args) {

		try {
			peformAction();

		} catch (Exception e) {
			e.printStackTrace();
			StringBuilder sb = new StringBuilder();
			for (StackTraceElement el : e.getStackTrace()) {
				sb.append(el.toString()+"\n");
			}
			System.out.println("Stack Trace : " + sb.toString());
			System.out.println(e.toString() + "next \n" + e.getMessage());
		}

	}

	private static void peformAction() throws Exception {
		throw new Exception("just checking");
	}

}
