package br.com.treinamento.marvel.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

public class MarvelClient {

	private static String publicKey = "909f42f109281ac1e55564a4b4f747f4";
	private static String privateKey = "32b57ce5b871336a3e6278f8432e8f85ef254593";
	private static String baseUrl = "http://gateway.marvel.com";

	public static void main(String[] args) {
		String url = baseUrl + "/v1/public/series?apikey=" + publicKey;
		long timestamp = System.currentTimeMillis();
		url += "&hash=" + DigestUtils.md5DigestAsHex(String.valueOf(timestamp + privateKey + publicKey).getBytes());
		url += "&ts=" + timestamp;
		System.out.println(url);
		ResponseEntity<ResponseWrapper> dto = new RestTemplate().getForEntity(url, ResponseWrapper.class);
		System.out.println(dto);
	}
}

class ResponseWrapper {
	private String code;
	private String status;

	private ResponseData data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ResponseData getData() {
		return data;
	}

	public void setData(ResponseData data) {
		this.data = data;
	}

}

class ResponseData {
	List<SeriesResponse> results;

	public List<SeriesResponse> getResults() {
		return results;
	}

	public void setResults(List<SeriesResponse> results) {
		this.results = results;
	}

}

class SeriesResponse {
	private String title;
	private List<SeriesComic> comics;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SeriesComic> getComics() {
		return comics;
	}

	public void setComics(List<SeriesComic> comics) {
		this.comics = comics;
	}
}

class SeriesComic {

	private List<SeriesComicResource> items;

	public List<SeriesComicResource> getItems() {
		return items;
	}

	public void setItems(List<SeriesComicResource> items) {
		this.items = items;
	}
}

class SeriesComicResource {
	private String resourceURI;
	private String name;

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
