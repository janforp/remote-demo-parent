package com.janita.remote.one.constant;

public class ResultDtoFactory {
    
    

    public ResultDtoFactory() {
    }

    public static ResultDto toSuccess(String reason) {
        return toSuccess(reason, null);
    }

    public static ResultDto toSuccess(Object data) {
        return toSuccess(null, data);
    }

    public static ResultDto toSuccess(String reason, Object result) {
        ResultDto dto = new ResultDto();
        dto.setResultCode("0");
        dto.setReason(reason);
        dto.setResult(result);
        return dto;
    }
    
    public static ResultDto toUnknowErroe(){
    	ResultDto dto = new ResultDto();
        dto.setResultCode("-1");
        dto.setReason("UnknowErroe");
        dto.setResult(null);
        return dto;
    }
    
    public static ResultDto toError(ResultCode rc) {
        ResultDto dto = new ResultDto();
        dto.setResultCode(rc.getCode());
        dto.setReason(rc.getMessage());
        dto.setResult(null);
        return dto;
    }
    
    public ResultDto toInvalideTokenError() {
        ResultDto dto = new ResultDto();
        dto.setResultCode("10004");
        dto.setReason("InvalideTokenErrer");
        dto.setResult(null);
        return dto;
    }
    
    
}
