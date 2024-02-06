package com.nagp.elasticsearch.utils;

import org.json.JSONArray;

import java.util.Arrays;

public class HelperFunctions {

    private HelperFunctions() {}

    private static final String[] USER_FIELDS = {"name^5","productBrandCategory^4","genderCategory^2","apparelCategory","priceRangeCategory","productDescription^3"};
    private static final String[] SEARCH_FIELDS = {"name","productDescription","productBrandCategory"};

    /**
     * Construct the query body for multi index matching
     *
     * @param query String
     * @return String
     */
    public static String buildMultiIndexMatchBody(String query) {
        return "{\n" +
                "\"from\": 0,\n" +
                "\"size\": 100,\n" +
                "\"track_total_hits\": true,\n" +
                "\"sort\" : {\n" +
                "      \"id\": {\"order\": \"asc\"}\n" +
                "      },\n" +
                "  \"query\": {\n" +
                "    \"query_string\" : {\n" +
                "      \"query\":      \"*" + query + "*\",\n" +
                "      \"fields\":     " + new JSONArray(Arrays.asList(USER_FIELDS)) + ",\n" +
                "      \"default_operator\": \"OR\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"highlight\": {\n" +
                "    \"fields\": {\n" +
                "      \"*\": {}\n" +
                "    },\n" +
                "    \"require_field_match\": true\n" +
                " }\n" +
                "}";
    }

    
    public static String buildMultiIndexMatchBodyForMentionedField(String fieldName,String Value) {
        return "{\n" +
                "\"from\": 0,\n" +
                "\"size\": 100,\n" +
                "\"track_total_hits\": true,\n" +
                "\"sort\" : {\n" +
                "      \"id\": {\"order\": \"asc\"}\n" +
                "      },\n" +
                "  \"query\": {\n" +
                "    \"query_string\" : {\n" +
                "      \"query\":      \"*" + Value + "*\",\n" +
                "      \"fields\":     " + new JSONArray(Arrays.asList(SEARCH_FIELDS)) + ",\n" +
                "      \"default_operator\": \"OR\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"highlight\": {\n" +
                "    \"fields\": {\n" +
                "      \"*\": {}\n" +
                "    },\n" +
                "    \"require_field_match\": true\n" +
                " }\n" +
                "}";
    }

    
    public static String buildSearchUri(String elasticSearchUri,
                                        String elasticSearchIndex,
                                        String elasticSearchSearch) {
        return elasticSearchUri + elasticSearchIndex + elasticSearchSearch;
    }
}
	