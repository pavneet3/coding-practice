
public class SplitTest {

	public static void main(String[] args) {

		String s = "Thphile duet with Massard ";

		String st[] = s.split(
				"&| and | AND | ; |;| Duet |DUET WITH| Duet With|duet| DUET | feat | featuring |/| ft | ft. | feat. | Feat | Featuring , Ft | Ft. | FT.| Feat. |duet with");

		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i]);
		}
	}

}
