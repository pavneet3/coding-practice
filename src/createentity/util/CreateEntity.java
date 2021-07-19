package createentity.util;

import java.util.Arrays;
import java.util.List;

public class CreateEntity {

	public static void main(String[] args) {
		boolean onlyColumnNames = false;
		String query = "CREATE TABLE `tm_artist_user_data` (\r\n"
				+ "  `artist_id` int(11) NOT NULL,\r\n"
				+ "  `last_played` date NOT NULL,\r\n"
				+ "  `play_count` int(11) NOT NULL,\r\n"
				+ "  `num_reviews` int(11) NOT NULL,\r\n"
				+ "  `num_ratings` int(11) NOT NULL,\r\n"
				+ "  `rating` float NOT NULL,\r\n"
				+ "  `playlist_count` int(11) NOT NULL,\r\n"
				+ "  `favourites_count` int(11) NOT NULL,\r\n"
				+ "  `num_sold` int(11) NOT NULL,\r\n"
				+ "  `num_dedicated` int(11) NOT NULL,\r\n"
				+ "  `popularity` int(11) NOT NULL,\r\n"
				+ "  `status` int(11) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`artist_id`)\r\n"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

		List<String> queryParams = Arrays.asList(query.split("\n"));
		StringBuilder result = new StringBuilder("");
		queryParams.stream().forEach(e -> {
			e = e.trim();
			if (e.trim().startsWith("`")) {
//				System.out.println(e);
				String nameWQ = e.split(" ")[0];
//				System.out.println(nameWQ);
				String name = nameWQ.substring(1, nameWQ.length() - 1);
				String type = getType(e.split(" ")[1], name);
				String defaultValue = getDefaultValueByType(type);
				if (name.contains("_")) {
					if (!onlyColumnNames) {
						result.append("@Column(name = \"" + name + "\")\n");
					}
					name = convertToCamelCase(name);
				}
//				result.append("private " + type + " " + name + "=" + defaultValue + ";\n\n");
				result.append("private " + type + " " + name + ";\n\n");
			}
		});
		System.out.println(result);
	}

	private static String getDefaultValueByType(String type) {
		switch (type) {
		case "String":
			return "\"\"";
		case "Long":
			return "0l";
		case "Integer":
			return "0";
		case "Date":
			return "new Date()";
		default:
			return "\"\"";
		}
	}

	private static String convertToCamelCase(String name) {
		StringBuilder ccName = new StringBuilder();
		String[] aName = name.split("_");
		ccName.append(aName[0]);
		for (int i = 1; i < aName.length; i++) {
			ccName.append(aName[i].substring(0, 1).toUpperCase() + aName[i].substring(1));
		}
		return ccName.toString();
	}

	private static String getType(String string, String name) {
		if (string.contains("varchar") || string.contains("text")) {
			return "String";
		} else if (string.contains("int")) {
			if (name.substring(name.length() - 2, name.length()).contains("id")) {
				return "Long";
			}
			return "Integer";
		} else if (string.contains("time")) {
			return "Date";
		} else {
			return "String";
		}
	}
}
