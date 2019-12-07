package com.company.common.framework.model.response;

import com.company.common.framework.model.response.kindQuery.QueryList;

public class QueryResponse extends BaseResponse{

    QueryList queryList;

    public QueryResponse(ResultCode resultCode,QueryList queryList) {
        super(resultCode);
        this.queryList = queryList;
    }
}
