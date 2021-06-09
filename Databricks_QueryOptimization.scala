
// Prints the plans (logical and physical), optionally formatted by a given explain mode
limitEventsDF.explain(true)


// Predict PushDown - import and filter at the same time
val jdbcURL = "jdbc:postgresql://54.213.33.240/training"

// Username and Password w/read-only rights
val connProperties = new java.util.Properties()
connProperties.put("user", "training")
connProperties.put("password", "training")

val ppDF = spark.read.jdbc(
    jdbcURL,                      // the JDBC URL
    "training.people_1m",         // the name of the table
    "id",                         // the name of a column of an integral type that will be used for partitioning
    1,                            // the minimum value of columnName used to decide partition stride
    1000000,                      // the maximum value of columnName used to decide partition stride
    8,                            // the number of partitions/connections
    connProperties                // the connection properties
  )
  .filter($"gender" === "M")      // Filter the data by gender


  // NO Predict PushDown - Cache data before filter

  val cachedDF = spark.read
  .jdbc(
    jdbcURL,                      // the JDBC URL
    "training.people_1m",         // the name of the table
    "id",                         // the name of a column of an integral type that will be used for partitioning
    1,                            // the minimum value of columnName used to decide partition stride
    1000000,                      // the maximum value of columnName used to decide partition stride
    8,                            // the number of partitions/connections
    connProperties                // the connection properties
  )

cachedDF.cache().count()     // materialize the cache

val filteredDF = cachedDF.filter($"gender" === "M")      // Filter the data by gender

