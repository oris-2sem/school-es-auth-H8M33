package com.example.secondhomework.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataTimeRequest {
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;

    //2007-12-03T10:15:30
    @Override
    public String toString() {
        return year+"-"+month+"-"+day+"T"+hour+":"+minute+":00";
    }
}
