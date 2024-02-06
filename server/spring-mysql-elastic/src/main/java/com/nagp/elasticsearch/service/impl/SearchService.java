package com.nagp.elasticsearch.service.impl;

import com.nagp.elasticsearch.service.ISearchService;
import com.nagp.elasticsearch.utils.Constants;
import com.nagp.elasticsearch.utils.HelperFunctions;
import com.nagp.elasticsearch.utils.ResultQuery;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.nagp.elasticsearch.model.SearchSuggestionKeywordInfo;

@Service
public class SearchService implements ISearchService {
	 
    @Value("${api.elasticsearch.uri}")
    private String elasticSearchUri;

    @Value("${api.elasticsearch.search}")
    private String elasticSearchSearchPrefix;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchService.class);

    @Override
    public ResultQuery searchFromQuery(String query) throws IOException {
        String body = HelperFunctions.buildMultiIndexMatchBody(query);
        return executeHttpRequest(body);
    }

    /**
     * Fetch resultQuery from elastic engine for the given body
     *
     * @param body String
     * @return ResultQuery
     * @throws IOException IOException
     */
    private ResultQuery executeHttpRequest(String body) throws IOException{
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ResultQuery resultQuery = new ResultQuery();
            HttpPost httpPost = new HttpPost(HelperFunctions.buildSearchUri(elasticSearchUri
                    , "", elasticSearchSearchPrefix));
            httpPost.setHeader(Constants.CONTENT_ACCEPT, Constants.APP_TYPE);
            httpPost.setHeader(Constants.CONTENT_TYPE, Constants.APP_TYPE);
            try {
                httpPost.setEntity(new StringEntity(body, Constants.ENCODING_UTF8));
                HttpResponse response = httpClient.execute(httpPost);
                String message = EntityUtils.toString(response.getEntity());
                JSONObject myObject = new JSONObject(message);
                if(myObject.getJSONObject(Constants.HITS)
                        .getInt(Constants.TOTAL_HITS) != 0){
                    resultQuery
                            .setElements(myObject
                                    .getJSONObject(Constants.HITS)
                                    .getJSONArray(Constants.HITS)
                                    .toString());
                    resultQuery
                            .setNumberOfResults(myObject.getJSONObject(Constants.HITS)
                                    .getInt(Constants.TOTAL_HITS));
                    resultQuery.setTimeTook((float) ((double) myObject.getInt(Constants.TOOK) / Constants.TO_MS));
                } else {
                    resultQuery.setElements(null);
                    resultQuery.setNumberOfResults(0);
                    resultQuery.setTimeTook((float) ((double) myObject.getInt(Constants.TOOK) / Constants.TO_MS));
                }
            } catch (IOException | JSONException e) {
                LOGGER.error("Error while connecting to elastic engine --> {}", e.getMessage());
                resultQuery.setNumberOfResults(0);
            }

            return resultQuery;
        }
    }

	@Override
	public ResultQuery searchFromMentionedField(String fieldName, String searchValue) throws IOException {
		String body = HelperFunctions.buildMultiIndexMatchBodyForMentionedField(fieldName,searchValue);
        return executeHttpRequest(body);
	}

	public List<SearchSuggestionKeywordInfo> searchKeywordFromMap(String q) throws IOException {
        List<SearchSuggestionKeywordInfo> resultList = new LinkedList<>();
      //  for (int index = q.length(); index > 0; --index) {
            //String prefix = q.substring(0, index).toLowerCase();
        String prefix=q;
            ResultQuery resultQuery = searchFromMentionedField("name,productDescription",prefix);
            if(null!=resultQuery.getElements()) {
	            JSONArray resultarray = new JSONArray(resultQuery.getElements());
	            for(int i=0;i<resultarray.length();i++) {
	            	JSONObject productdata= resultarray.getJSONObject(i);
	            	JSONObject source = (JSONObject) productdata.get("_source");
	            	String product= "product_id="+source.getInt("id");
	            	String productname = source.getString("name");
	            	String productDescription = source.getString("productDescription");
	            	SearchSuggestionKeywordInfo searchobj = new SearchSuggestionKeywordInfo(productname,product,i);
	            	SearchSuggestionKeywordInfo searchobjProductDesc = new SearchSuggestionKeywordInfo(productDescription,product,i);
	            	resultList.add(searchobj);
	            	resultList.add(searchobjProductDesc);
	            }
            }
            else if(resultQuery.getNumberOfResults()==0) {
            	return new LinkedList<>();
            }
       // }   
        return resultList;
    }
}
