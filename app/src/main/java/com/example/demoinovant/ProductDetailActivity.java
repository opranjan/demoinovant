package com.example.demoinovant;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout indicatorLayout;
    TextView brandNameTv,nameTv,skuTv,productDescTv,priceTv;

    private ProductImageAdapter imageAdapter;
    List<String> images;

    RecyclerView recyclerView ;

    List<String> swatchUrls = new ArrayList<>();

    Button quantityIncrBtn,quantityDecrBtn,quantityBtn;

    int quty = 1;

    private ProgressBar progressBar;

    ConstraintLayout parentCL;
    int blackColor = 0xFF000000;
    ScrollView scrollView;

    String sku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int titleColor = getResources().getColor(R.color.black); // Replace with your
        getSupportActionBar().setTitle(Html.fromHtml("<font color='" + titleColor + "'>" + getTitle() + "</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Find views by ID
        viewPager = findViewById(R.id.viewPager);
        indicatorLayout = findViewById(R.id.indicatorLayout);
        brandNameTv = findViewById(R.id.brand_name);
        nameTv = findViewById(R.id.name);
        skuTv = findViewById(R.id.sku_tv);
        productDescTv = findViewById(R.id.product_desc);
        priceTv = findViewById(R.id.price_tv);
        recyclerView = findViewById(R.id.swatchRecyclerView);
        quantityIncrBtn =findViewById(R.id.quantity_incr_btn);
        quantityDecrBtn = findViewById(R.id.quantity_decr_btn);
        quantityBtn = findViewById(R.id.quantity_btn);
        progressBar = findViewById(R.id.progressbar);
        parentCL = findViewById(R.id.parent_cl);
        scrollView = findViewById(R.id.scrollView2);


        FetchData();
        quantityBtn.setText(String.valueOf(quty));

        quantityIncrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quty++;
                UpdateQty();
            }
        });

        quantityDecrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quty>1){
                    quty--;
                    UpdateQty();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_wishlist) {
            return true;
        }else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public  void FetchData(){
        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        ApiService apiService= ApiClient.getClient().create(ApiService.class);
        Call<ProductDetailsResponse> call = apiService.getProductDetails("6701","253620", "en", "KWD");

        call.enqueue(new Callback<ProductDetailsResponse>() {
            @Override
            public void onResponse(Call<ProductDetailsResponse> call, Response<ProductDetailsResponse> response) {
                progressBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    // Handle the successful response
                    ProductDetailsResponse productDetailsResponse = response.body();
                    Toast.makeText(ProductDetailActivity.this, String.valueOf(productDetailsResponse.getMessage()), Toast.LENGTH_SHORT).show();
                    ProductDetails productDetails = productDetailsResponse.getData();

                    images = productDetails.getImages();
                    imageAdapter = new ProductImageAdapter(ProductDetailActivity.this, images);
                    viewPager.setAdapter(imageAdapter);
                    setUpIndicator();

                    String brandname= productDetails.getBrandName();
                    String name = productDetails.getName();
                    sku = productDetails.getSku();
                    String productDesc = productDetails.getDescription();
                    String price = productDetails.getPrice();

                   List<ConfigurableOption> configurableOptions = productDetails.getConfigurableOption();
                   List<Attribute> attributes = configurableOptions.get(0).getAttributes();

                    for (Attribute attribute : attributes) {
                        String swatchUrl = attribute.getSwatchUrl();
                        // Do something with the swatch URL, e.g., log or process it
                        swatchUrls.add(swatchUrl);
                        Log.d("Swatch URL", swatchUrl);
                    }
                    RecyclerView recyclerView = findViewById(R.id.swatchRecyclerView);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(ProductDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
                    recyclerView.setLayoutManager(layoutManager);
                    SwatchAdapter adapter = new SwatchAdapter(swatchUrls);
                    recyclerView.setAdapter(adapter);

                    CharSequence spannedText = Html.fromHtml(productDesc);
                    final SpannableString spannableString = new SpannableString(spannedText);
                    brandNameTv.setText(brandname);
                    priceTv.setText(price+" KWD");
                    nameTv.setText(name);
                    skuTv.setText("sku :"+sku);
                    productDescTv.setText(spannedText);
                } else {

                }
            }

            @Override
            public void onFailure(Call<ProductDetailsResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e("API Failure", "Network error: " + t.getMessage());
            }
        });
    }




    private void setUpIndicator() {
        int totalImages = viewPager.getAdapter().getCount();
        for (int i = 0; i < totalImages; i++) {
            RadioButton radioButton = new RadioButton(this);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                radioButton.setId(View.generateViewId());
            }
            radioButton.setButtonDrawable(R.drawable.custom_indicator_selector); // Create a selector drawable
            radioButton.setLayoutParams(new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
            ));

            indicatorLayout.addView(radioButton);
        }

        // Set a listener to handle indicator changes
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        updateIndicator(0);
    }
    private void updateIndicator(int position) {
        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) indicatorLayout.getChildAt(i);
            radioButton.setChecked(i == position);
        }
    }

    public void UpdateQty(){
        quantityBtn.setText(String.valueOf(quty));
    }

}