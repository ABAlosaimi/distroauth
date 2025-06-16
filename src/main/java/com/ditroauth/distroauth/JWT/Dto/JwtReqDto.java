package com.ditroauth.distroauth.JWT.Dto;

import lombok.Data;

@Data
public class JwtReqDto {

    private String nodeId;
    private String nodeAudience;
    private String nodeIssuer;

}
