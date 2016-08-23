package com.inrhythm;

import com.inrhythm.pojo.InRhythmResponse;
import com.inrhythm.service.impl.JsonService;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class App {
	public static void main(String[] args) {
	
		String url = "http://jsonplaceholder.typicode.com/posts";	

		System.out.println("STARTED");

		JsonService service = new JsonService();

		InRhythmResponse response;
		try {
			response = service.parseJson(url);
			FileUtils.write(new File("inrhythm.json"), response.getJson());
		} catch (Exception e) {
			// TODO - handle error after consultation w/PM
			e.printStackTrace();
		}

		System.out.println("FINISHED");

	}
}
