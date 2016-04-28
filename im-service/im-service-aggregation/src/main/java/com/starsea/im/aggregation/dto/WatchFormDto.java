package com.starsea.im.aggregation.dto;

import lombok.*;
import lombok.experimental.Builder;

import java.util.Date;

/**
 * Created by danny on 16/4/24.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WatchFormDto {
    private String name;
    private String evaluationPerson;
    private String evaluationTime;
    private int now_score[];
    private String now_comment[];
}
