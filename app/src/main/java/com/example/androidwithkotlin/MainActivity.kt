package com.example.androidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var output : TextView
    lateinit var submit_btn : Button

    lateinit var rd_gender : RadioGroup
    lateinit var male : RadioButton
    lateinit var female : RadioButton
    lateinit var english : CheckBox
    lateinit var bangla : CheckBox


    lateinit var edittext : EditText
    lateinit var edittextview : TextView
    lateinit var cpy_btn : Button



    lateinit var spin: Spinner
    lateinit var spin_text : TextView

    lateinit var slider: SeekBar
    lateinit var value : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rd_gender = findViewById<RadioGroup>(R.id.rd_gender)
        male = findViewById<RadioButton>(R.id.male)
        female = findViewById<RadioButton>(R.id.female)

        english = findViewById<CheckBox>(R.id.english)
        bangla = findViewById<CheckBox>(R.id.bangla)

        submit_btn = findViewById(R.id.submit_btn)
        output = findViewById(R.id.output)

        submit_btn.setOnClickListener(View.OnClickListener {

            var output_text : String
            output_text = ""

            if(rd_gender.checkedRadioButtonId != -1){
                output_text += " Gender :  "
                if(male.isChecked){
                    output_text += "Male\n"
                }else{
                    output_text += "Female\n"
                }
            }

            output_text += "Language Known : "

            if (english.isChecked){
                output_text += " English\n"
            }
            if(bangla.isChecked){
                output_text += "Bangla\n"
            }

            output_text += " Thank You "


            output.setText(output_text)


        })


        /* edit text  */


        edittext = findViewById(R.id.edittext)
        edittextview = findViewById(R.id.edittextview)

        edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edittextview.text = s
            }

        })

        /* Spinner */

        spin = findViewById(R.id.spin)
        spin_text = findViewById(R.id.spin_text)

        val option = arrayOf<String>("Option 11", "Option 12","Option 13")

        spin.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option)


        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented"  )
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spin_text.text = option.get(position)
            }
        }


        slider =  findViewById(R.id.sb_slider)
        value = findViewById(R.id.seek_text)

        slider.max = 50

        slider.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value.text = "Selecting : " +  progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                value.text = "started : " +  seekBar.progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                value.text = "selected : " +  seekBar.progress
            }
        })




    }
}