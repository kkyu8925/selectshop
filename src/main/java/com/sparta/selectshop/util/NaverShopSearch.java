package com.sparta.selectshop.util;

import com.sparta.selectshop.dto.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Component
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "_aIj7Pjy9B9jEEcOplsa");
        headers.add("X-Naver-Client-Secret", "mVakCW3ynn");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);

        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        System.out.println("Response status: " + status);

        String response = responseEntity.getBody();
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
//        System.out.println("rjson = " + rjson);

        JSONArray items = rjson.getJSONArray("items");
//        System.out.println("items = " + items);

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = (JSONObject) items.get(i);
//            System.out.println("itemJson = " + itemJson);

//            String title = itemJson.getString("title");
//            String image = itemJson.getString("image");
//            String link = itemJson.getString("link");
//            int lprice = itemJson.getInt("lprice");
//            System.out.println("title = " + title);
//            System.out.println("image = " + image);
//            System.out.println("link = " + link);
//            System.out.println("lprice = " + lprice);
//            System.out.println("------------------------------");

            ItemDto itemDto = new ItemDto(itemJson);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }

//    public static void main(String[] args) {
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//        String result = naverShopSearch.search("아이맥");
//        List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(result);
//    }
}
