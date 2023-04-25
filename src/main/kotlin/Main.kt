fun main(){
    multiples()
    var user1=CurrentAccount(2345678,"Rita Khaseyi",50000.0)
    user1.deposit(10000.0)
    println(user1.balance)
    user1.Withdraw(20000.0)
    println(user1.balance)
    user1.Withdraw(100000.0)
    user1.details()
    passwordCheck("password")
    passwordCheck("ilovekotlinkotlinisfuntocode")
    user1=SavingsAccount(5689014567,"Trishia Waweru",50000.0)
    user1.Withdraw(10000.0)
    println(user1.balance)
    user1.details()
    user1.deposit(20000.0)
    println(user1.balance)
  var string1=StringCheck("Rita")
    println( string1.firstCharacter())
    println(string1.lastCharacter())
    println(string1.string)
     println(string1.stringlength())
    println(string1.stringCheck())









}

//Write and invoke one function that takes in a random string and returns the
//following values: first character, last character, length of the string and
//whether it begins with a vowel or not. (6pts)

data class StringCheck(var string:String) {
    fun stringCheck():Boolean {
        var vowels = "AEIOUaeiou"
        return string[0] in vowels

    }

    fun firstCharacter(): Char {
        return string[0]
    }
    fun lastCharacter():Char{
        return string.last()
    }
    fun stringlength():Int{
        return string.length
    }
}





//Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
//1. Must be at least 8 characters long
//2. Must be at most 16 characters long
//3. Must not be “password”
//4. Must contain a digit
//Your function should determine whether the password provided is valid or not.
//The function returns true/false (7pts)
fun passwordCheck(password:String){
    when{

        password=="password"-> println("choose a strong password")
        password.length <=8 -> println("password too short")
        password.length >=16 -> println("password too long maximum 16 characters")
    }
    if (password.length<=16 &&password!="pasword"){
        println(true)
    }
    else{
        println(false)
    }
}



//Create a function that prints out multiples of 6 and 8 between 1 and 1000. For
//multiples of both 6 and 8 it should print out “Bingo!” (5pts)
fun multiples(){
    for (nums in 1..1000){
        when{
            nums %6==0 && nums %8==0 -> println("Bingo")
            nums %6==0-> println(" $nums is a multiple of 6")
            nums %8==0 -> println(" $nums is a multiple of 8")
            else -> println("$nums is not a multiple of 6 and 8")
        }
    }
}



//Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
//a. deposit(amount: Double) - Increments the balance by the amount
//deposited
//b. withdraw(amount: Double) - Decrements the balance by the amount
//withdrawn
//c. details() - Prints out the account number and balance and name in
//this format: “Account number x with balance y is operated by z” (6pts)

open class CurrentAccount(var accountNumber:Number,var accountName:String,var balance:Double){
     fun deposit(Amount:Double){
        balance+=Amount
    }
   open fun Withdraw(Amount:Double){
        if (Amount <=balance){
            balance-=Amount
        }
        else{
           println( "Not enough money to withdraw $Amount your balance is $balance")
        }
    }
    fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }
}

//Create another class SavingsAccount. It has the same functions and
//attributes as the current account except for one attribute, withdrawals: Int.
//Withdrawals is a counter variable that is used to keep track of how many
//withdrawals have been made from the account in a year. The only other
//difference is that the savings account withdraw() method first checks if the
//number of withdrawals is less than 4 for it to allow one to withdraw money
//from the account. It also increments the withdrawals attribute after a
//successful withdrawal (6pts)

class SavingsAccount(accountNumber: Number,accountName: String,balance: Double):CurrentAccount(accountNumber,accountName, balance) {

    var withdrawals=0

    override fun Withdraw(Amount: Double) {
        if (withdrawals <= 4 && Amount <= balance) {
            balance -= Amount
            withdrawals++
        }

        else{
            println("Too many withdrawals")
        }

    }
}
