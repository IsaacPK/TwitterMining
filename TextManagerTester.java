package tweets_stock_price_prediction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextManagerTester {

	public static void main(String[] args) {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			FileInputStream fStream = new FileInputStream("tweetbodies.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
			
			//StringBuilder sb = new StringBuilder();
			int num = 0;
			while (in.ready()) {
				String line = in.readLine();
				line = TextManager.clean(line);
				lines.add(line);
				//System.out.println(TextManager.clean(line));
				//if(num++ > 100)
				//	break;
			}
            in.close();
		}
		catch (IOException e) {
            System.out.println("File input error");
            return;
        }
		
		for(int i = 0; i<lines.size(); i++)
		{
			if(!TextManager.isRelatedToApple(lines.get(i)))
				System.out.println(lines.get(i));
		}
	}

}
