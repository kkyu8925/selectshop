package com.sparta.selectshop.repository;

import com.sparta.selectshop.model.Folder;
import com.sparta.selectshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUser(User user);

    List<Folder> findAllByUserAndNameIn(User user, List<String> nameList);

    Folder findByName(String folderName);
}
