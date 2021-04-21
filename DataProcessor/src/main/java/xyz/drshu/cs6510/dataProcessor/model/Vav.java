package xyz.drshu.cs6510.dataProcessor.model;

import lombok.Data;

@Data
public class Vav {
    private Integer id;

    private Double zoneAirFlow;

    private Double zoneCoolingAirFlowSetPoint;

    private Double zoneCoolingTemperatureSetPoint;

    private Double zoneHeatingTemperatureSetPoint;

    private Double zoneTemperature;

    private Integer ahu1Id;

    private Integer ahu3Id;

    private String vavName;
}