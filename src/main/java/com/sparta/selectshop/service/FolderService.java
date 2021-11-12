package com.sparta.selectshop.service;

import com.sparta.selectshop.model.Folder;
import com.sparta.selectshop.model.Product;
import com.sparta.selectshop.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FolderService {

    List<Folder> getFolders(User user);

    List<Folder> createFolders(List<String> folderNameList, User user);

    // 회원 ID 가 소유한 폴더에 저장되어 있는 상품들 조회
    Page<Product> getProductsOnFolder(User user, int page, int size, String sortBy, boolean isAsc, Long folderId);
}