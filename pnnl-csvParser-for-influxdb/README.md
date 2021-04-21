# pnnl-csvParser-for-influxdb

You may import this content to a module in [IntelliJ](https://www.jetbrains.com/idea/) with maven configuration (See `pom.xml`)

Two main class: 
`Split.java`: split the big `.csv` file into separate ones based on the measurements.
`ExtractConsumption.java`: extract one table for `consumption.csv`

Every generated `.csv` file has its own `measurement` in the influxDB (ask Zhenke or Xinglu for influxDB log-in credentials)

The generated `.csv` file was imported to the influxDB via [this python script](https://github.ccs.neu.edu/cs6510-pnnl/pnnl-csvToInflux-importer)
