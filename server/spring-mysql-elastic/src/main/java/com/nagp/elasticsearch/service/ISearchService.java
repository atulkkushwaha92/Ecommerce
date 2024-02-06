package com.nagp.elasticsearch.service;

import com.nagp.elasticsearch.model.SearchSuggestionKeywordInfo;
import com.nagp.elasticsearch.utils.ResultQuery;

import java.io.IOException;
import java.util.List;

public interface ISearchService {
    ResultQuery searchFromQuery(String query) throws IOException;

	ResultQuery searchFromMentionedField(String fieldName, String Value) throws IOException;

	List<SearchSuggestionKeywordInfo> searchKeywordFromMap(String q) throws IOException;
}
