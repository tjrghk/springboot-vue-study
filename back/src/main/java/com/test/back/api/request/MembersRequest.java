package com.test.back.api.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MembersRequest {
    private final int MAX_SIZE = 2000;
    private Integer page = 1;
    private Integer size = 10;

    public long getOffset() {
        return (long) (Math.max(this.page, 1) - 1) * Math.min(this.size, MAX_SIZE);
     }
}
