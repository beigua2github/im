package com.starsea.im.aggregation.dto;

/**
 * Created by danny on 16/5/8.
 */

import lombok.*;
import lombok.experimental.Builder;

/**
 * Created by danny on 16/4/24.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AdvantageFormDto {
    private String name;
    private Integer age;
    private String sex;
    private String banji;
    private String school;
    private int now_score[];
    private int scoreTotal;
}
