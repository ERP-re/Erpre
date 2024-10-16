package com.project.erpre.model.dto;

import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageFileDTO {

    private Integer messageAttachmentId;
    private Long messageNo;
    private String messageFileName;
    private String messageFileUrl;
    private BigInteger messageFileSize;
    private String messageFileType;


}
