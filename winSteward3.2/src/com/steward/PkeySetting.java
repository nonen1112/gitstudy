package com.steward;

public class PkeySetting {
	
	private String key, url, shkey, category;
	
	//기본 생성자...불필요
	PkeySetting(){
	}
	
	// 한개의 긴 텍스트(key/url,shkey~category)로 던져주면 잘라서 저장
	PkeySetting(String sumString){
		key = sumString.substring(0,sumString.indexOf('/'));
		url = sumString.substring(sumString.indexOf('/')+1,sumString.indexOf(','));
		shkey = sumString.substring(sumString.indexOf(',')+1,sumString.indexOf('~'));
		category = sumString.substring(sumString.indexOf('~')+1);
	}

	//각각의 스트링 나눠서 주면 저장
	PkeySetting(String key, String url, String shkey, String category) {
		this.key = key;
		this.url = url;
		this.shkey = shkey;
		this.category = category;
	}

	//이하 getter setter
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShkey() {
		return shkey;
	}

	public void setShkey(String shkey) {
		this.shkey = shkey;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	//toString 재정의 (도로 붙여서 뿌려줌)
	@Override
	public String toString() {
		return key + "/" + url + "," + shkey + "~" + category;
	}


}
