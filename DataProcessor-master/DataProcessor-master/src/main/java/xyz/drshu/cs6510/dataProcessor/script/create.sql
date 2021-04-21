create table ahu1
(
    ID                         int auto_increment
        primary key,
    discharge_air_flow         double null,
    exhaust_air_flow_set_point double null,
    outdoor_air_flow           double null
);

create table ahu1_thresholds
(
    ID                                 int auto_increment
        primary key,
    minimum_outdoor_air_flow_set_point int null
);

create table ahu2
(
    ID                                 int auto_increment
        primary key,
    outdoor_air_flow                   double null,
    return_air_flow                    double null,
    supply_air_flow                    double null,
    supply_air_flow_set_point          int    null,
    zone_cooling_temperature_set_point int    null,
    zone_heating_temperature_set_point int    null,
    zone_temperature                   double null
);

create table ahu3
(
    ID                       int auto_increment
        primary key,
    discharge_air_flow       double null,
    exhaust_air_flow         double null,
    minimum_outdoor_air_flow int    null,
    outdoor_air_flow         double null
);

create table ahu3_thresholds
(
    ID                                 int auto_increment
        primary key,
    exhaust_air_flow_set_point         double null,
    minimum_outdoor_air_flow           int    null,
    minimum_outdoor_air_flow_set_point int    null
);

create table ahu4
(
    ID                                            int auto_increment
        primary key,
    exhaust_air_flow                              double null,
    exhaust_air_flow_set_point                    double null,
    maximum_discharge_air_flow_set_point          int    null,
    minimum_discharge_air_flow_set_point          int    null,
    supply_air_flow                               double null,
    unoccupied_zone_heating_temperature_set_point int    null,
    zone_cooling_temperature_set_point            int    null,
    zone_heating_temperature_set_point            int    null,
    zone_outdoor_air_flow                         double null,
    zone_temperature                              double null
);

create table common
(
    ID                   int auto_increment
        primary key,
    external_temperature double     null,
    is_summer            tinyint(1) null,
    is_weekday           tinyint(1) null,
    is_working_hours     tinyint(1) null,
    cooling_consumption  double     null,
    heating_consumption  double     null,
    time                 date       null
);

create table seb
(
    common_id          int not null,
    ahu1_id            int not null,
    ahu2_id            int not null,
    ahu3_id            int not null,
    ahu4_id            int not null,
    ahu1_thresholds_id int not null,
    ahu3_thresholds_id int not null
);

create table vav
(
    ID                                 int auto_increment
        primary key,
    zone_air_flow                      int    null,
    zone_cooling_air_flow_set_point    int    null,
    zone_cooling_temperature_set_point int    null,
    zone_heating_temperature_set_point int    null,
    zone_temperature                   double null,
    ahu1_id                            int    null,
    ahu3_id                            int    null,
    vav_name                           int    null
);

create table vav_thresholds
(
    ID                             int auto_increment
        primary key,
    maximum_zone_air_flow          int           null,
    minimum_zone_air_flow          int           null,
    zone_air_flow_set_point_offset int default 0 null,
    zone_reheat_air_flow           int           null,
    ahu1_id                        int           not null,
    ahu3_id                        int           null,
    vav_name                       int           null
);

