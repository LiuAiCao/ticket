package com.company.common.framework.model.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MapQueryResponse extends BaseResponse{
    Object object;

    public MapQueryResponse(ResultCode resultCode,Object queryList) {
        super(resultCode);
        this.object = queryList;
    }
}
