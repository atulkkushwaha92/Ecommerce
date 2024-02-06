package com.nagp.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class SearchSuggestionKeywordInfo {
    String keyword;
    public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	String link;
    Integer rank;

    public SearchSuggestionKeywordInfo(String keyword, String link, Integer rank) {
        this.keyword = keyword;
        this.link = link;
        this.rank = rank;
    }
}
