// Read from Delta
val dt_test = spark.read
                        .format("delta")
                        .load(workingDir + "/delta/events")
display(dt_test)


// Write to Delta
usersDF.write
            .format("delta")
            .mode("overwrite")
            .save(usersOutputPath)