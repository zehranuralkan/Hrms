package com.example.Hrms.business;

import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessResult;

public class Rules {
	public static Result run(Result... logics){
        for(Result logic:logics){
            if(!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
}
}