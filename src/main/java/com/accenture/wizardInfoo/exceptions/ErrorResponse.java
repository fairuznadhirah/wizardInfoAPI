package com.accenture.wizardInfoo.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String type;
    private int code;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate timeStamp;
    private String traceID;
    private Map<String, Object> errors;


    public Map<String, Object> errorResponse() {
        Map<String, Object> status = new HashMap<>();
        Map<String, Object> details = new HashMap<>();
        details.put("type", getType());
        details.put("code", getCode());
        details.put("timestamp", getTimeStamp());
        details.put("traceId", getTraceID());
        details.put("errors", getErrors());
        details.put("status", details);
        return details;
    }
}
