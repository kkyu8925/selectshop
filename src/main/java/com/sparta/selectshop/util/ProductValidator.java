package com.sparta.selectshop.util;

import com.sparta.selectshop.dto.ProductMypriceRequestDto;
import com.sparta.selectshop.dto.ProductRequestDto;
import com.sparta.selectshop.exception.ApiRequestException;

public class ProductValidator {

    private static final int MIN_PRICE = 100;

    // 관심상품 생성 validation
    public static void validateCreate(ProductRequestDto requestDto, Long userId) {
        if (userId == null || userId < 0) {
            throw new IllegalArgumentException("회원 Id 가 유효하지 않습니다.");
        }

        if (requestDto.getTitle() == null || requestDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("저장할 수 있는 상품명이 없습니다.");
        }

        if (!URLValidator.urlValidator(requestDto.getImage())) {
            throw new IllegalArgumentException("상품 이미지 URL 포맷이 맞지 않습니다.");
        }

        if (!URLValidator.urlValidator(requestDto.getLink())) {
            throw new IllegalArgumentException("상품 최저가 페이지 URL 포맷이 맞지 않습니다.");
        }

        if (requestDto.getLprice() <= 0) {
            throw new IllegalArgumentException("상품 최저가가 0 이하입니다.");
        }
    }

    // 관심상품 업데이트 validation
    public static void validateUpdate(ProductMypriceRequestDto requestDto) {
        // 변경될 관심 가격이 유효한지 확인합니다.
        int myPrice = requestDto.getMyprice();
        if (myPrice < MIN_PRICE) {
            throw new ApiRequestException("유효하지 않은 관심 가격입니다. 최소 " + MIN_PRICE + " 원 이상으로 설정해 주세요.");
        }
    }
}
