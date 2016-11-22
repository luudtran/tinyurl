package hello;

import java.net.URL;

public class TinyURL {
	private final String id;
	private final URL target;

	public TinyURL(String id, URL target) {
		super();
		this.id = id;
		this.target = target;
	}

	public String getId() {
		return id;
	}

	public URL getTarget() {
		return target;
	}

}
