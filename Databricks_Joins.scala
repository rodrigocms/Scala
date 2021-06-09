// Join
val conversionsDF = (usersDF
                            .join(convertedUsersDF, Seq("email"), "outer")
                            .filter(col("email").isNotNull)
                            .na.fill(false))

