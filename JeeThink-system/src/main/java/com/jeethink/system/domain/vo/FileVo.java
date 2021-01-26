package com.jeethink.system.domain.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileVo {
    String code;
    String type;
    String id;
    MultipartFile file;
}
