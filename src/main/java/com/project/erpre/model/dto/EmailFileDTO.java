package com.project.erpre.model.dto;

import com.project.erpre.model.entity.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailFileDTO {
    private Integer emailAttachmentNm;
    private String emailFileName;
    private String emailFileUrl;
    private Email emailNm;
}
