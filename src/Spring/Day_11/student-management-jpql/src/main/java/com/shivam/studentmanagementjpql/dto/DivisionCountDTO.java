package com.shivam.studentmanagementjpql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DivisionCountDTO {
    private String division;
    private long count;
}
