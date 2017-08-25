package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WordsCount {

    public static void main(String[] args) throws Exception {
        /*
		 * File file = new File("1.txt"); PrintWriter pw = new
		 * PrintWriter(file); pw.println("hello world, hello java.");
		 * pw.println("hello program, hello java."); pw.close();
		 * printWords(file);
		 */
        Has h = new Has();
		/*
		 * String s = new String(
		 * "You are the mananger of an office supplies company. A colleague has received a letter compaining about an order for office furniture. She has left the letter for you to answer and has written some notes on it."
		 * );
		 */
        String s = new String("aa bb cc dd aa cc ee");
        System.out.println(h.StatList(s));
    }

	/*public static void printWords(File file) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		Pattern pattern = Pattern.compile("[A-Za-z]+");
		Map<String, Integer> map = new LinkedHashMap<>();
		while (br.ready()) {
			Matcher matcher = pattern.matcher(br.readLine());
			while (matcher.find()) {
				String word = matcher.group();
				if (!map.containsKey(word)) {
					map.put(word, 0);
				}
				map.put(word, map.get(word) + 1);
			}
		}
		br.close();
		for (String word : map.keySet()) {
			System.out.println(word + " : " + map.get(word));
		}
	}*/
}

class Has {
    // 统计单词出现的次数
    public static String StatList(String str) {
        StringBuffer sb = new StringBuffer();
        HashMap<String, Integer> has = new HashMap<String, Integer>(); // 打开一个哈希表
        String[] slist = str.split(" ");
        for (int i = 0; i < slist.length; i++) {
            if (!has.containsKey(slist[i])) { // 若尚无此单词
                has.put(slist[i], 1);
            } else {// 如果有，就在将次数加1
                has.put(slist[i], has.get(slist[i]) + 1);
            }
        }
        List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(has.entrySet());

		/*Collection c = has.keySet();
		System.out.println(c);*/
        // 排序方法
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // return (o2.getValue() - o1.getValue());
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });
        System.out.println(infoIds);
        for (Map.Entry<String, Integer> map : infoIds) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }
        // 遍历map
        Iterator iterator = has.keySet().iterator();
        while (iterator.hasNext()) {
            String word = (String) iterator.next();
            sb.append(word).append(" 次数").append(has.get(word)).append("\n");
        }
        return sb.toString();
    }

	/*
	 * public static void main(String[] args) { String s = new String(
	 * "You are the mananger of an office supplies company. A colleague has received a letter compaining about an order for office furniture. She has left the letter for you to answer and has written some notes on it."
	 * ); System.out.println(StatList(s)); }
	 */
}
