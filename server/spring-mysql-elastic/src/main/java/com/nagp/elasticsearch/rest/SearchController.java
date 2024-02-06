package com.nagp.elasticsearch.rest;

import com.nagp.elasticsearch.model.SearchSuggestionKeywordInfo;
import com.nagp.elasticsearch.service.ISearchService;
import com.nagp.elasticsearch.utils.Constants;
import com.nagp.elasticsearch.utils.PathResources;
import com.nagp.elasticsearch.utils.ResultQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(PathResources.SEARCH_CONTROLLER)
public class SearchController {

    private ISearchService searchService;

    @Autowired
    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(Constants.SEARCH_QUERY + "/{" + Constants.QUERY + "}")
    public ResponseEntity<ResultQuery> searchQuery(@PathVariable String query) throws IOException {
        return new ResponseEntity<> (searchService.searchFromQuery(query.trim().toLowerCase()), HttpStatus.OK);
    }
    
    @GetMapping("/search-suggestion")
    public ResponseEntity<List<SearchSuggestionKeywordInfo>> searchKeyword(@RequestParam String q) throws IOException {
        return ResponseEntity.ok(searchService.searchKeywordFromMap(q));
    }
}
