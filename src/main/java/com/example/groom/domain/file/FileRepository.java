package com.example.groom.domain.file;

import com.example.groom.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Attachment, Long> {
}
