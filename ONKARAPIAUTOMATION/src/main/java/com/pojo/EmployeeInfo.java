package com.pojo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_EMPTY) //does not allow to pass any empty values
public class EmployeeInfo {

	
	private int id;
    private String firstname;
    private String lastname;
    private String email;

    private FavFoodInfo favFood;
    private List<String> jobs;

    private List<MarksInfo> marks;
}
