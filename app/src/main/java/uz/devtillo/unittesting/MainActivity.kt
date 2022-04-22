package uz.devtillo.unittesting

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import uz.devtillo.unittesting.utils.EmailValidator
import uz.devtillo.unittesting.utils.SharedPreferenceEntry
import uz.devtillo.unittesting.utils.SharedPreferencesHelper
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mSharedPreferencesHelper: SharedPreferencesHelper? = null
    // The input field where the user enters his name.
    private var mNameText: EditText? = null
    // The date picker where the user enters his date of birth.
    private var mDobPicker: DatePicker? = null
    // The input field where the user enters his email.
    private var mEmailText: EditText? = null
    // The validator for the email input field.
    private var mEmailValidator: EmailValidator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Shortcuts to input fields.
        mNameText = findViewById<View>(R.id.userNameInput) as EditText
        mDobPicker = findViewById<View>(R.id.dateOfBirthInput) as DatePicker
        mEmailText = findViewById<View>(R.id.emailInput) as EditText
        // Setup field validators.
        mEmailValidator = EmailValidator()
        mEmailText!!.addTextChangedListener(mEmailValidator)
        // Instantiate a SharedPreferencesHelper.
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        mSharedPreferencesHelper = SharedPreferencesHelper(sharedPreferences)
        // Fill input fields from data retrieved from the SharedPreferences.
        populateUi()

    }

    private fun populateUi() {
        val sharedPreferenceEntry: SharedPreferenceEntry = mSharedPreferencesHelper!!.personalInfo
        mNameText!!.setText(sharedPreferenceEntry.name)
        val dateOfBirth: Calendar = sharedPreferenceEntry.dateOfBirth
        mDobPicker!!.init(
            dateOfBirth[Calendar.YEAR], dateOfBirth[Calendar.MONTH],
            dateOfBirth[Calendar.DAY_OF_MONTH], null
        )
        mEmailText!!.setText(sharedPreferenceEntry.email)
    }

    fun onSaveClick(view: View) {
        // Don't save if the fields do not validate.
        if (!mEmailValidator?.isValid!!) {
            mEmailText!!.error = "Invalid email"
            Log.w(TAG, "Not saving personal information: Invalid email")
            return
        }
        // Get the text from the input fields.
        val name = mNameText!!.text.toString()
        val dateOfBirth = Calendar.getInstance()
        dateOfBirth[mDobPicker!!.year, mDobPicker!!.month] = mDobPicker!!.dayOfMonth
        val email = mEmailText!!.text.toString()
        // Create a Setting model class to persist.
        val sharedPreferenceEntry = SharedPreferenceEntry(name, dateOfBirth, email)
        // Persist the personal information.
        val isSuccess: Boolean = mSharedPreferencesHelper!!.savePersonalInfo(sharedPreferenceEntry)
        if (isSuccess) {
            Toast.makeText(this, "Personal information saved", Toast.LENGTH_LONG).show()
            Log.i(TAG, "Personal information saved")
        } else {
            Log.e(TAG, "Failed to write personal information to SharedPreferences")
        }
    }
    fun onRevertClick(view: View) {
        populateUi()
        Toast.makeText(this, "Personal information reverted", Toast.LENGTH_LONG).show()
        Log.i(TAG, "Personal information reverted")
    }
    companion object {
        // Logger for this class.
        private const val TAG = "MainActivity"
    }
}