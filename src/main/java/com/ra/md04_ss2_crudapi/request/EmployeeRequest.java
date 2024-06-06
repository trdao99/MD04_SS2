package com.ra.md04_ss2_crudapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private Integer page;
    private Integer itemPage;
    private String sortBy;
    private String direction;
}
