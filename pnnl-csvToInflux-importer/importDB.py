from ExportCsvToInflux import ExporterObject

server = "localhost:8086"
exporter = ExporterObject()

f_names = ["DischargeAirFlow", "ExhaustAirFlow", "ExhaustAirFlowSetPoint", "MaximumDischargeAirFlowSetPoint", "MaximumZoneAirFlow",
"MinimumDischargeAirFlowSetPoint", "MinimumOutdoorAirFlow", "MinimumOutdoorAirFlowSetPoint", "MinimumZoneAirFlow", "OutdoorAirFlow",
"ReturnAirFlow", "SupplyAirFlow", "SupplyAirFlowSetPoint", "UnoccupiedZoneHeatingTemperatureSetPoint", "ZoneAirFlow", "ZoneAirFlowSetPointOffset",
"ZoneCoolingAirFlowSetPoint", "ZoneCoolingTemperatureSetPoint", "ZoneHeatingTemperatureSetPoint", "ZoneOutdoorAirFlow", "ZoneReheatAirFlow", "ZoneTemperature"]

for f_name in f_names:
    exporter.export_csv_to_influx(
      csv_file = f_name + ".csv",
      db_name="test",
      db_measurement=f_name,
      field_columns="value",
      tag_columns="device",
      db_server_name=server,
      db_user="",
      db_password="",
      time_column="timestamp",
      drop_database=False,
      drop_measurement=True,
      force_insert_even_csv_no_update=True
      )




# You could get the export_csv_to_influx parameter details by:
# print(exporter.export_csv_to_influx.__doc__)