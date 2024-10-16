package com.project.erpre.model.dto;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatFileDTO {

    private Integer chatAttachmentId;
    private Long chatMessageNo;
    private String chatFileName;
    private String chatFileUrl;
    private BigInteger chatFileSize;
    private String chatFileType;
    private String chatFileDeleteYn;
    private LocalDateTime chatFileDeleteDate;
}
