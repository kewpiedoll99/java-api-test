package com.inrhythm.service.impl;

import com.google.gson.reflect.TypeToken;
import com.inrhythm.pojo.InRhythmResponse;
import com.inrhythm.pojo.Post;
import com.inrhythm.service.IJsonService;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonService implements IJsonService{

	public InRhythmResponse parseJson(String url) throws Exception {
		Gson gson = new Gson();

		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
		httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.76"); // got a 403 not allowed without this

		Type type = new TypeToken<List<Post>>(){}.getType();
		List<Post> postList = gson.fromJson(
				new InputStreamReader(httpURLConnection.getInputStream()), type);

		postList.get(3).setTitle("InRhythm");
		postList.get(3).setBody("InRhythm");

		InRhythmResponse inRhythmResponse = new InRhythmResponse();
		inRhythmResponse.setPosts(postList);

        Map<Integer, Long> userIdCountsMap =
				postList.stream()
						.filter(x -> x.getUserId() != null) // ignore json element(s) with no user id
						.collect(Collectors.groupingBy(Post::getUserId, Collectors.counting()));
		inRhythmResponse.setUserCount(userIdCountsMap.keySet().size());

		inRhythmResponse.setJson(gson.toJson(postList));

		return inRhythmResponse;
	}
}
