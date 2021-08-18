package my.edu.tarc.livedatademo.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    var accNo : String = ""
    var owner : String = ""

    //underscore indicating this variable is private in class only
    private var _balance = MutableLiveData<Double>()
    //val is read only not allow to change
    //var can change
    //Live Data only read and get() data from deposit() and withdraw() , MutableLiveData is can change
    val balance : LiveData<Double>
                get() = _balance

    init {
        //this.accNO is refer to the AccountModel)
        this.accNo = accNo
        this.owner = owner
        this._balance.value = balance
    }

    fun deposit(amount: Double) {
        //balance += amount

       _balance.value =  (balance.value)?.plus(amount)
    }

    fun withdraw(amount:Double){
        //balance -= amount
        //()? means if the value is null then function no be called
        _balance.value = (balance.value)?.minus(amount)
    }

}