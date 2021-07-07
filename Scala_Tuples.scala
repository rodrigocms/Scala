// TUPLES

//Quant Limit - 22 elements

val mytuple1 = (1,2,"hello", true)
val mytuple_x = new Tuple3(1,2,"hello")    // new TupleX  (X = num elements)
val mytuple_y = new Tuple4(1,2,"hello", (true,3))

println(mytuple1._1)  // Print fist element
println(mytuple1._4)  // Print forth element
println(mytuple_y._4._2)  // Print second element of the forth element

mytuple.productIterator.foreach {
    x => println(x)
}

val mytuple_z = (1->"Rod", 2->"Gi",3->"Cat")
