package xyz.drshu.cs6510.dataProcessor.model;

import java.util.Date;
import lombok.Data;

@Data
public class Common {
    private Integer id;

    private Double externalTemperature;

    private Boolean isSummer;

    private Boolean isWeekday;

    private Boolean isWorkingHours;

    private Double coolingConsumption;

    private Double heatingConsumption;

    private Date time;
}