
object HelloWorld{
    def main (args: Array[String]) {
        val name = 'Rodrigo'
        val age = 39
        println( name + " is " + age + " years old.")
        println( s"$name is $age years old.")
        prinln( f" $name%s is $age%f years old. ")     // f for float
        println ( raw"Hello \n World")                 // print literally
}

}