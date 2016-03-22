/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweets_stock_price_prediction;

import java.util.ArrayList;

public class TextManager
{
    public static String clean(String tweet){
    
//      String tweet_no_url = Regex.VALID_URL.matcher(tweet).replaceAll("");
//      String tweet_no_hashtag = Regex.VALID_HASHTAG.matcher(tweet_no_url).replaceAll("");
//      String tweet_no_at = tweet_no_hashtag.replace("@", "");
        
    	// Remove web addresses
        String newTweet = tweet.replaceAll("((https?://)(.*?)($|\\s))", "");
        
        // Remove entire word preceded by #
        //newTweet = newTweet.replaceAll("(#(.*?)($|\\s))", "");
        
        // Remove only # symbol
        newTweet = newTweet.replaceAll("#", "");
        
        // Remove entire word (username) preceded by @
        newTweet = newTweet.replaceAll("(@(.*?)($|\\s))", "");
        
        // Remove only @ symbol
        //newTweet = newTweet.replace("@", "");
        
        // Replace all instances of '&amp;' as a word with the word 'and'
        // Change all instances of '&amp;' within a word to the & symbol
        newTweet = newTweet.replaceAll("\\s&amp;\\s", " and ");
        newTweet = newTweet.replaceAll("&amp;", "&");
        
        // Replace all instances of '&gt;' with the > symbol
        newTweet = newTweet.replaceAll("&gt;", ">");
        
        // Remove nonsense characters
        newTweet = newTweet.replaceAll("Ã.", "");
        newTweet = newTweet.replaceAll("Â.", "");
        newTweet = newTweet.replaceAll("â.š?|â.ž?", "");
        newTweet = newTweet.replaceAll("¬.", "");
        newTweet = newTweet.replaceAll("¡.", "");
        newTweet = newTweet.replaceAll("Å.", "");
        newTweet = newTweet.replaceAll("Ë.", "");
        newTweet = newTweet.replaceAll("ï¿½™?", "");
        newTweet = newTweet.replaceAll("Æ.", "");
        newTweet = newTweet.replaceAll("ž", "");
        newTweet = newTweet.replaceAll("¿½?", "");
        
        // Remove retweet indicator
        newTweet = newTweet.replaceAll("RT\\s", "");
        
        return newTweet;
    }
    
    private static String[] unrelatedWords = {".*juice.*", ".*\\stree.*", ".*\\seve(\\p{Punct}|\\s).*", ".*\\spie.*", ".*\\seating.*", 
    		".*\\seat.*", ".*\\seater.*", ".*\\sate.*", ".*red\\sdelicious.*", ".*aonemktg.*", ".*kkgame.*"};
    
    public static boolean isRelatedToApple(String tweet) {
    	String lowercaseTweet = tweet.toLowerCase();
    	for(int i = 0; i<unrelatedWords.length; i++)
    		if(lowercaseTweet.matches(unrelatedWords[i]))
    		{
    			//System.out.println(unrelatedWords[i]);
    			return false;
    		}
    	
    	return true;
    }
    
    public static ArrayList<String> clean(ArrayList<String> tweets) {
        ArrayList<String> tweets_list = new ArrayList();
        for (String tweet : tweets) {
            String cleaned_tweet = clean(tweet);
            tweets_list.add(cleaned_tweet);
        }
        return tweets_list;
    }
}