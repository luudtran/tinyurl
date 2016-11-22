package hello;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinyURLController {
	HashMap<String, URL> urls = new HashMap<String, URL>();
	Random rng = new Random();
	String characters = "abcdefghijklmnopqrstuvwxyz";
	
	public TinyURLController() {
		urls.put("",  null);
	}

	@RequestMapping(path = "/tinyurl", method = RequestMethod.POST)
	public TinyURL postTinyurl(@RequestParam(value="url") String urlStr) {
		String id = null;
		URL url = null;
		
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		id = generateString(rng, characters, 5);
		
		urls.put(id,  url);
		return new TinyURL(id, url);
	}
	
	@RequestMapping(path = "/tinyurl", method = RequestMethod.GET)
	public void getTinyurl(@RequestParam(value="id", defaultValue="") String id, HttpServletResponse response) {
		try {
			response.sendRedirect(urls.get(id).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static String generateString(Random rng, String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
}