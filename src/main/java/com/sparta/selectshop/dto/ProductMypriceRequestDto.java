package com.sparta.selectshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductMypriceRequestDto {
    private int myprice;

    public ProductMypriceRequestDto(int myprice) {
        this.myprice = myprice;
    }
}
