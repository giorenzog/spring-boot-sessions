package com.daily.session_seven.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class PersonSearchCriteria {

    @Size(max = 100)
    private String name;

    @Min(0)
    private Integer minAge;

    @Min(0)
    private Integer maxAge;

    @AssertTrue(message = "minAge must not be greater than maxAge")
    public boolean isAgeRangeValid(){
        return minAge == null || maxAge == null || minAge <= maxAge;
    }

    public PersonSearchCriteria() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }
}
