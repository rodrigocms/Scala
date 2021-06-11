// UDF

def firstLetterFunction(email):
    return email.take(1)

firstLetterFunction("rodrigo@email.com")

//Define a UDF that wraps the function -> sends it to executors be able to use in the df
firstLetterUDF = udf(firstLetterFunction)

//Register UDF to use in SQL
sales.createOrReplaceTempView("sales")

spark.udf.register("sql_udf", firstLetterFunction)

%sql
select sql_udf(email) as fisrt from sales 
