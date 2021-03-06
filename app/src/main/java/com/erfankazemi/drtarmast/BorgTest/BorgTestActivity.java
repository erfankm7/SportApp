package com.erfankazemi.drtarmast.BorgTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.erfankazemi.drtarmast.BorgTest.Adapter.BorgTestAdapter;
import com.erfankazemi.drtarmast.MainActivity;
import com.erfankazemi.drtarmast.R;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class BorgTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //-------------------------------------------------------------------------
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/vazir.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
        //-------------------------------------------------------------------------
        setContentView(R.layout.activity_borg_test);

        List<String> desc = Arrays.asList(
                "استراحت و نشستن",
                "فعالیت بسیار کم",
                "فعالیت و استراحت کم",
                "فعالیت روزمره و عادی",
                "فعالیت عادی",
                "فعالیت روزمره نسبتا زیاد",
                "فعالیت  نسبتا شدید",
                "فعالیت  شدید",
                "فعالیت بسیار شدید",
                "بیشترین حالت فعالیت"
        );
        List<String> desc2 = Arrays.asList(
                "اگر در حالت خوابیده روی تخت و یا نشستن رو مبل ، در حال استراحت هستید",
                "اگر میتوانید با یک نفس گیری مقدار زیادی صحبت کنید",
                "هم استراحت میکنید اما کمی هم در کنارش کارهای کمی انجام میدید",
                "کار های عادی خود را از جمله تلوزیون نگاه کردن را انجام میدهید",
                "فعالیت های روزمره خود را اگر به درستی انجام میدهید",
                "اگر هنگام کار فشار نسبتا کمی را متحمل میشوید",
                "اگر ورزش را شروع کرده اید ، یا فشار های کاری شما زیاد شده است",
                "اگر به عنوان مثال ، در حال دویدن هستید",
                "اگر تمرینات بسیار شدیدی از جمله تمارین سنگین بدنسازی انجام میدهید",
                "اگر به طاقت فرسا تمرین حد ممکن رسیده اید و احساس تنگی نفس دارید"
        );

        RecyclerView borgCat = findViewById(R.id.borgRcv);
        borgCat.setAdapter(new BorgTestAdapter(this, desc,desc2));
        borgCat.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}