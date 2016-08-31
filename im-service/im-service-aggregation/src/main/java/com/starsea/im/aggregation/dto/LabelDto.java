package com.starsea.im.aggregation.dto;

import lombok.*;
import lombok.experimental.Builder;

/**
 * Created by danny on 16/8/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LabelDto {
    private Integer id;
    private String labelOne;
    private String labelTwo;
    private String content;
}
