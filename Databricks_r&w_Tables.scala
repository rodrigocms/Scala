
// Read from Table
df = spark.table("tablename")


// Write to tables
eventsDF.write.mode("overwrite").saveAsTable("events_s")

// find database name
println(databaseName)