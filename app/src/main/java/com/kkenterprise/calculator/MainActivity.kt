package com.kkenterprise.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var op="*"
    var oldNum=""
    var isNewOp=true
    var decimal=false
    var valueInt=0.0
    fun buNumEvent(view:View){
        if(isNewOp){
            textView.setText("")
        }
        isNewOp=false
        var buSelect = view as Button
        var buClickValue:String=textView.text.toString()
        when(buSelect.id){
            bu0.id->{
                buClickValue+="0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id-> {
                buClickValue+="9"
            }
            buDot.id->{
                if(!decimal) {
                    buClickValue += "."
                    decimal=true
                }
            }
            buPlusMinus.id-> {
                try {
                    valueInt = textView.text.toString().toDouble()
                    if (valueInt > 0.0) {
                        buClickValue = "-" + buClickValue
                    }
                }catch (e: Exception){}
            }
        }
        textView.setText(buClickValue)
    }
    fun buOpEvent(view:View){
        var buSelect = view as Button
        when(buSelect.id) {
            buMul.id->{
                op="*"
            }
            buDiv.id->{
                op="/"
            }
            buAdd.id->{
                op="+"
            }
            buSub.id->{
                op="-"
            }
        }
        oldNum=textView.text.toString()
        isNewOp=true
        decimal=false
    }
    fun buEqual(view: View){
        var newNumber=textView.text.toString()
        var answer:Double?=null
        when(op){
            "*"->{
                answer=oldNum.toDouble()*newNumber.toDouble()
            }
            "/"->{
                answer=oldNum.toDouble()/newNumber.toDouble()
            }
            "+"->{
                answer=oldNum.toDouble()+newNumber.toDouble()
            }
            "-"->{
                answer=oldNum.toDouble()-newNumber.toDouble()
            }
        }
        textView.setText(answer.toString())
        isNewOp=true
        decimal=false
    }
    fun buPerC(view: View){
        var numbernew=textView.text.toString()
        var answer=numbernew.toDouble()/100
        textView.setText(answer.toString())
        isNewOp=true
        decimal=false
    }
    fun buClear(view: View){
        textView.setText("")
        isNewOp=true
        decimal=false
    }
}
