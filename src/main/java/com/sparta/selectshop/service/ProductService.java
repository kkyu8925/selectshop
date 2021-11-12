package com.sparta.selectshop.service;

import com.sparta.selectshop.dto.ItemDto;
import com.sparta.selectshop.dto.ProductMypriceRequestDto;
import com.sparta.selectshop.dto.ProductRequestDto;
import com.sparta.selectshop.model.Product;
import com.sparta.selectshop.model.User;
import org.springframework.data.domain.Page;


public interface ProductService {

    Page<Product> getProducts(Long userId, int page, int size, String sortBy, boolean isAsc);

    // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    Product createProduct(ProductRequestDto requestDto, Long userId);

    // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    Product updateProduct(Long id, ProductMypriceRequestDto requestDto);

    /**
     * utils.Scheduler 에서 사용
     */
    // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    void updateBySearch(Long id, ItemDto itemDto);

    // 모든 상품 조회 (관리자용)
    Page<Product> getAllProducts(int page, int size, String sortBy, boolean isAsc);

    Product addFolder(Long productId, Long folderId, User user);
}
