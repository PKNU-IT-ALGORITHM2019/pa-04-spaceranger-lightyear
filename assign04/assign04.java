import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class assign04 {
	private static List<WebLog> webLogs = new ArrayList<WebLog>();
	private static int flag = 0;

	public static void main(String[] args) {
		String command = new String();
		Scanner s = new Scanner(System.in);

		while (!command.equals("exit")) {
			System.out.print("$ ");
			command = s.nextLine();

			if (command.equals("read"))
				readFile();
			else if (command.equals("sort -ip")) {
				Collections.sort(webLogs, new Comparator<WebLog>() {
					@Override
					public int compare(WebLog w1, WebLog w2) {
						if (w1.getIP().compareTo(w2.getIP()) < 0) {
							return -1;
						} else if (w1.getIP().compareTo(w2.getIP()) > 0) {
							return 1;
						}
						return 0;
					}
				});
				flag = 1;
			}	
			else if (command.equals("sort -t")) {
				Collections.sort(webLogs, new Comparator<WebLog>() {
					@Override
					public int compare(WebLog w1, WebLog w2) {
						if (w1.getTime().compareTo(w2.getTime()) < 0) {
							return -1;
						} else if (w1.getTime().compareTo(w2.getTime()) > 0) {
							return 1;
						}
						return 0;
					}
				});
				flag = 2;
			}
			else if (command.contentEquals("print")) {
				if (flag == 1)
					printByIP();
				else if (flag == 2)
					printByTime();
				else
					print();
			}
			else
				continue;
		}
		return;
	}

	public static void readFile() {
		String uri = "/Users/spaceranger.lightyear/eclipse-workspace/Algorithm/assign04/webLog.csv";
		String line = "";
		BufferedReader inFile = null;

		try {
			inFile = new BufferedReader(new FileReader(uri));
			Charset.forName("UTF-8");

			StringTokenizer st;

			while((line = inFile.readLine()) != null) {
				st = new StringTokenizer(line, ",");
				WebLog webLog = new WebLog(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
				webLogs.add(webLog);
			}

			inFile.close();
			System.out.println("Read Successfully.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sort() {

	}

	public static void print() {
		for (int i = 1; i < webLogs.size() - 1; i++) {
			System.out.println("    IP: " + webLogs.get(i).getIP());
			System.out.println("    Time: " + webLogs.get(i).getTime());
			System.out.println("    URL: " + webLogs.get(i).getURL());
			System.out.println("    Status: " + webLogs.get(i).getStatus() + "\n");
		}
	}


	public static void printByIP() {
		for (int i = 0; i < webLogs.size() - 1; i++) {
			System.out.println(webLogs.get(i).getIP());
			System.out.println("    Time: " + webLogs.get(i).getTime());
			System.out.println("    URL: " + webLogs.get(i).getURL());
			System.out.println("    Status: " + webLogs.get(i).getStatus() + "\n");
		}
	}
	public static void printByTime() {
		for (int i = 0; i < webLogs.size() - 1; i++) {
			System.out.println(webLogs.get(i).getTime());
			System.out.println("    IP: " + webLogs.get(i).getIP());
			System.out.println("    URL: " + webLogs.get(i).getURL());
			System.out.println("    Status: " + webLogs.get(i).getStatus() + "\n");
		}
	}
}