package com.example.dinner_recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dinner_recommend.databinding.ActivityMainBinding
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import java.util.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val assetManager = assets
        val ipt = assetManager.open("foodlist.xlsx")
        val workBook = WorkbookFactory.create(ipt)
        val sheet = workBook.getSheetAt(0)

        binding.getRandom.setOnClickListener {
            val randomNumber = Random().nextInt(760)
            val row = sheet.getRow(randomNumber)
            binding.foodText.text = row.getCell(5).toString()
        }

        binding.btnLicense.setOnClickListener {
            OssLicensesMenuActivity.setActivityTitle("오픈소스 라이선스")
            startActivity(Intent(this, OssLicensesMenuActivity::class.java))
        }


    }


}