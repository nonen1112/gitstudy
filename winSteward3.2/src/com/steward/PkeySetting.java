package com.steward;

public class PkeySetting {
	
	private String key, url, shkey, category;
	
	//�⺻ ������...���ʿ�
	PkeySetting(){
	}
	
	// �Ѱ��� �� �ؽ�Ʈ(key/url,shkey~category)�� �����ָ� �߶� ����
	PkeySetting(String sumString){
		key = sumString.substring(0,sumString.indexOf('/'));
		url = sumString.substring(sumString.indexOf('/')+1,sumString.indexOf(','));
		shkey = sumString.substring(sumString.indexOf(',')+1,sumString.indexOf('~'));
		category = sumString.substring(sumString.indexOf('~')+1);
	}

	//������ ��Ʈ�� ������ �ָ� ����
	PkeySetting(String key, String url, String shkey, String category) {
		this.key = key;
		this.url = url;
		this.shkey = shkey;
		this.category = category;
	}

	//���� getter setter
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

	//toString ������ (���� �ٿ��� �ѷ���)
	@Override
	public String toString() {
		return key + "/" + url + "," + shkey + "~" + category;
	}


}
