package br.com.meli.linktracker.dto;

public class LinkDTO {
	private Integer id;
	private Integer count;
	private String  url;
	private boolean valid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	@Override
	public String toString() {
		return "LinkDTO [id=" + id + ", count=" + count + ", url=" + url + ", valid=" + valid + "]";
	}

	
}
