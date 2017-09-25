package kadai2.問題6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBLesson02 {

	public static void main(String[] args) {
		List<Word> words = new ArrayList<>();
		WordDAO wdao = new WordDAO();

		System.out.println("￼英単語と日本語をスペースで区切って入力して下さい。");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		while (!input.equals("e")) {
						String [] tmp = new String[2];
						tmp = input.split(" ");
						Word wd = new Word(tmp[0], tmp[1]);
						words.add(wd);
						System.out.println("次の英単語と日本語を入力して下さい。\"e\"で終了します。");
						input = sc.nextLine();
		}

		int count = wdao.registWords(words);
		System.out.println(count + "件の登録をしました。\n");

		List<Word> wList = new ArrayList<>();
		wList = wdao.getWords();

		int wordNum = 0;
		for (Word tmp : wList) {
			System.out.println(tmp);
			wordNum++;
		}
		System.out.println("\n登録されている単語は" + wordNum + "件です");
	}
}


