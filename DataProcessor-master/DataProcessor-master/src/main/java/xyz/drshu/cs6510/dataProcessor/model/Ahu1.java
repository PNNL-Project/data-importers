package xyz.drshu.cs6510.dataProcessor.model;

import lombok.Data;

@Data
public class Ahu1 {
    private Integer id;

    private Double dischargeAirFlow;

    private Double exhaustAirFlowSetPoint;

    private Double outdoorAirFlow;
}