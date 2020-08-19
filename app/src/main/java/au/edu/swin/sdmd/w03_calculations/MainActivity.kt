package au.edu.swin.sdmd.w03_calculations

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onStop() {
        super.onStop()

        Log.i("LIFECYCLE","The app has been STOPPED!")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE","The app has been RESTARTED!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFECYCLE","The app has been DESTROYED!")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val plus = findViewById<RadioButton>(R.id.plus)
        val minus = findViewById<RadioButton>(R.id.minus)
        var result: Int

        val equals = findViewById<Button>(R.id.equals)
        val answer = findViewById<TextView>(R.id.answer)
        equals.setOnClickListener { _ ->
            if (plus.isChecked) {
                result = add(number1.text.toString(), number2.text.toString())
            }
            else
            {
                result = subtract(number1.text.toString(), number2.text.toString())
            }
            // TODO: show result on the
            answer.text = result.toString()
        }

        plus.setOnClickListener {
            Toast.makeText(this@MainActivity, "PLUS clicked!", Toast.LENGTH_SHORT).show();
        }

        minus.setOnClickListener {
            Toast.makeText(this@MainActivity, "MINUS clicked!", Toast.LENGTH_SHORT).show();
        }

    }

    // adds two numbers together
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()
    private fun subtract(number1: String, number2: String) = number1.toInt() - number2.toInt()

}