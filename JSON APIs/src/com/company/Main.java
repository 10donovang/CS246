package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by darkwarriordono on 5/6/17.
 */
public class Main {
    public static void main(String[] args) {
        // It all starts here.
        TweetLoader t = new TweetLoader();
        Map<String, BYUITweet> map = t.retrieveTweetsWithHashTag("#byui");
        for (String name : map.keySet()) {
            BYUITweet theTweet = map.get(name);
            System.out.println(String.format("%s (%d followers): %s", name, theTweet.getUser().getFollowers(), theTweet.getText()));
        }
        List<String> sortedNames = new ArrayList<>(map.keySet());

        Collections.sort(sortedNames, (o1, o2) -> Integer.compare(map.get(o2).getUser().getFollowers(), map.get(o1).getUser().getFollowers()));

        for (String name : sortedNames) {
            BYUITweet theTweet = map.get(name);
            System.out.println(String.format("%s (%d followers): %s", name, theTweet.getUser().getFollowers(), theTweet.getText()));
        }
    }
}
