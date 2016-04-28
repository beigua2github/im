package com.starsea.im.aggregation.dto;

import lombok.*;
import lombok.experimental.Builder;


/**
 * Created by danny on 16/4/27.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudyFormDto {
    private String name;
    private Integer age;
    private String sex;
    private String banji;
    private String school;
    private String organization;
    private String evaluationPerson;
    private String evaluationTime;
    private int now_score[];
}
