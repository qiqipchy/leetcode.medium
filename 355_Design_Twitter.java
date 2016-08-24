package otherclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Twitter {

	// 哪个用户都粉了谁；
	TreeMap<Integer, List<Integer>> userFollowDB;
	// 用户发的推特；TreeMap<Integer,Integer>代表 [N,tweetId];
	TreeMap<Integer, TreeMap<Integer, Integer>> tweetDB;
	// 用户关联的推特；
	int N;

	/** Initialize your data structure here. */
	public Twitter() {
		userFollowDB = new TreeMap<Integer, List<Integer>>();
		tweetDB = new TreeMap<Integer, TreeMap<Integer, Integer>>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!tweetDB.containsKey(userId)) {
			tweetDB.put(userId, new TreeMap<Integer, Integer>());
		}
		tweetDB.get(userId).put(N++, tweetId);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> follows;
		// 这个人没有发过tweet，也没有关注人

		if (!userFollowDB.containsKey(userId) && !tweetDB.containsKey(userId))
			return list;
		
		if (userFollowDB.containsKey(userId))
			follows = userFollowDB.get(userId);
		else
			follows = new ArrayList<Integer>();
		follows.add(userId);
		TreeMap<Integer, Integer> allTweets = new TreeMap<Integer, Integer>();

		for (int i = 0; i < follows.size(); i++) {
			int followeeId = follows.get(i);
			// 这个关注者没有发过
			if (!tweetDB.containsKey(followeeId))
				continue;
			allTweets.putAll(tweetDB.get(followeeId));
		}
		follows.remove(follows.size() - 1);
		Iterator<Entry<Integer, Integer>> iter = allTweets.entrySet()
				.iterator();
		while (iter.hasNext())
			list.add(iter.next().getValue());

		int length = Math.max(0, list.size() - 10);
		list = list.subList(length, list.size());
		Collections.reverse(list);
		return list;

	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (!userFollowDB.containsKey(followerId)) {
			userFollowDB.put(followerId, new ArrayList<Integer>());
		}
		userFollowDB.get(followerId).add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (userFollowDB.containsKey(followerId)) {
			if (userFollowDB.get(followerId) == null)
				return;
			List<Integer> list = userFollowDB.get(followerId);
			int index = list.indexOf(followeeId);
			if (index == -1)
				return;
			list.remove(index);
		}

	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
