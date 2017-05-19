package com.company;

import com.google.gson.Gson;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


import java.util.*;



/**
 * Created by darkwarriordono on 5/5/17.
 */
public class TweetLoader {
    private Twitter twitter;
    public TweetLoader(){
        configureKeys();

    }
    public Map <String, BYUITweet> retrieveTweetsWithHashTag(String hashtag) {
        Map<String, BYUITweet> m = new TreeMap<>();
        Query query = new Query(hashtag);
        QueryResult results = null;
        try {
            results = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
            return null;
        }


        for (Status status : results.getTweets()){
            String tweet = TwitterObjectFactory.getRawJSON(status);
            Gson gson = new Gson();
           BYUITweet bt = gson.fromJson(tweet, BYUITweet.class);
            m.put(bt.user.name, bt);
        }

            return m;

    }
    private void configureKeys(){ConfigurationBuilder cb = new ConfigurationBuilder();

// This continuous set of function calls all connected together is referred to
// as "method chaining". It is a popular technique amongst web developers and has
// gradually found its way into other languages.
//
// The way it works is that each setter returns a reference to the object.
// For example, the code in the setDebugEnabled function might look like this:
//
//  ConfigurationBuilder setDebugEnabled(Boolean value) {
//      this.debugEnabled = value;
//
//      // Returning "this" allows method chaining.
//      return this;
//  }
//
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("NKjdEWkLqKb95q0wvL1eBxFgT")
                .setOAuthConsumerSecret("7ZpdsNr2IbnDzXvXv7Bg0GftVvUWJtd1Jd3O97z6Fqy9TSdExg")
                .setOAuthAccessToken("860559076358406145-L9yanc2nkv24a6MzYAuER1vYIeZnrFE")
                .setOAuthAccessTokenSecret("JTVLiqWNfRWZOxrBCeDUZv89e93B9HP4gZmpD8ZhPdEfV")
                .setJSONStoreEnabled(true);

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();}
}
