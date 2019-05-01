package com.appbusters.robinpc.constitutionofindia.ui.reading

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.Utils.Constants
import com.appbusters.robinpc.constitutionofindia.Utils.Constants.Companion.DEFAULT_VALUE
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.google.gson.Gson
import com.google.gson.JsonElement
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class ReadingActivity : BaseActivity() {

    private var readElementId: Int = -1
    private lateinit var readElement: ReadElement

    companion object {
        private const val READ_ELEMENT_ID = "READ_ELEMENT_ID"

        fun newIntent(context: Context, readElementId: Int): Intent {
            val intent = Intent(context, ReadingActivity::class.java)
            intent.putExtra(READ_ELEMENT_ID, readElementId)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_reading
    }

    override fun setup() {
        setStatusBarColor(R.color.reading_status_bar)
        getExtraData()
        getReadElement()
        loadRespectiveElement()
    }

    private fun getExtraData() {
        readElementId = intent.getIntExtra(READ_ELEMENT_ID, DEFAULT_VALUE)
    }

    private fun getReadElement() {
        when(readElementId) {
            Constants.Companion.ReadElementIds.PREAMBLE_ID.ordinal -> {
//                readElement = ReadElement(
//                        0,
//                        "Robin Kamboj",
//                        "Robin is a great guy, but you know....",
//                        Category(R.color.preamble_color, getString(R.string.amendments_categories)),
//                                listOf("justice", "equality", "liberty", "fraternity", "sovereign")
//                )
            }
        }
//        val list = listOf(readElement, readElement)

//        Log.e("tag", Gson().toJson(list))
    }

    private fun loadRespectiveElement() {
        var json: String? = null
        try {
            Log.e("tag", "try")
            val inputStream = assets.open("main_db.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))

            val jsonObject = JSONObject(json)

            Log.e("tag", "json $jsonObject")

            val readElementsObjects = jsonObject.getJSONArray("read_elements")

            Log.e("tag", "read elements $readElementsObjects")
//
            val readElementZero = readElementsObjects.getJSONObject(0)

            Log.e("tag", "read element zero $readElementZero")

            val readElement = Gson().fromJson(readElementZero.toString(8), ReadElement::class.java)

            Log.e("tag", "read element zero ${readElement.id} ${readElement.title} ${readElement.content}")
        }
        catch (e: IOException) {
            Log.e("tag", "error ${e.message} ${e.cause}")
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
