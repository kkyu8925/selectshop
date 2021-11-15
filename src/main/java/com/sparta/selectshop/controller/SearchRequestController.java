package com.sparta.selectshop.controller;

import com.sparta.selectshop.dto.NaverItemDto;
import com.sparta.selectshop.service.feign.NaverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

//    private final NaverShopSearch naverShopSearch;
//
//    @GetMapping("/api/search")
//    public List<ItemDto> getItems(@RequestParam String query) {
//        String resultString = naverShopSearch.search(query);
//        return naverShopSearch.fromJSONtoItems(resultString);
//    }

    @Value("${naver.clientId}")
    private String clientId;

    @Value("${naver.clientSecret}")
    private String clientSecret;

    private final NaverService naverService;

    @GetMapping("/api/search")
    public NaverItemDto getItems(@RequestParam String query) {
        return naverService.search(clientId, clientSecret, query);
    }
}