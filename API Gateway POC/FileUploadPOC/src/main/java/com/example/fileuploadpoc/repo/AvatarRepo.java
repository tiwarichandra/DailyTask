package com.example.fileuploadpoc.repo;

import com.example.fileuploadpoc.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepo extends JpaRepository<Avatar, Long> {
}
