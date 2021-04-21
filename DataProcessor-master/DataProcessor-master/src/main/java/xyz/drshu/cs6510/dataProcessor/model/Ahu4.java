package xyz.drshu.cs6510.dataProcessor.model;

import lombok.Data;

@Data
public class Ahu4 {
    private Integer id;

    private Double exhaustAirFlow;

    private Double exhaustAirFlowSetPoint;

    private Double maximumDischargeAirFlowSetPoint;

    private Double minimumDischargeAirFlowSetPoint;

    private Double supplyAirFlow;

    private Double unoccupiedZoneHeatingTemperatureSetPoint;

    private Double zoneCoolingTemperatureSetPoint;

    private Double zoneHeatingTemperatureSetPoint;

    private Double zoneOutdoorAirFlow;

    private Double zoneTemperature;
}