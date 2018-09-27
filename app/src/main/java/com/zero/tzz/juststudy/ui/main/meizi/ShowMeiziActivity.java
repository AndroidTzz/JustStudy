package com.zero.tzz.juststudy.ui.main.meizi;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.PhotoView;
import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseActivity;
import com.zero.tzz.juststudy.utils.FileUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author lucy
 * @date 2018-09-27 14:15
 * @description //TODO
 */

public class ShowMeiziActivity extends BaseActivity {
    private static final String TAG = "ShowMeiziActivity";
    @BindView(R.id.iv_show_meizi)
    PhotoView mPhotoView;
    private String mUrl;
    private String mId;
    private MyAsyncTask mAsyncTask;

    @Override
    protected int getLayoutId() {
        setWindowStatusBarColor(R.color.black);
        return R.layout.activity_show_meizi;
    }

    @Override
    protected void initEventAndData() {
        mUrl = getIntent().getStringExtra("url");
        mId = getIntent().getStringExtra("id");
        Glide.with(this).load(mUrl).into(mPhotoView);
        mPhotoView.setOnClickListener(v -> finishAfterTransition());
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.iv_download)
    public void onViewClicked() {
        storageMeizi();
    }

    private void storageMeizi() {
        checkPermision();
    }

    private void checkPermision() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

            } else {
                saveAsync();
            }
        } else {
            saveAsync();
        }
    }

    private void saveAsync() {
        new MyAsyncTask().execute();
    }

    public void setWindowStatusBarColor(int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                saveAsync();
            } else {
                Toast.makeText(this, "玩不来，你不给权限！", Toast.LENGTH_LONG).show();
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    class MyAsyncTask extends AsyncTask<Void, Integer, File> {
        @Override
        protected File doInBackground(Void... params) {
            // 首先保存图片
            File pictureFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();
            File appDir = new File(pictureFolder, "JustMeizi");
            if (appDir.exists() && appDir.isDirectory()) {
                File[] listFiles = appDir.listFiles();
                for (File file : listFiles) {
                    if (file.getName().equals(mId + ".jpg")) {
                        return null;
                    }
                }
            }
            File file = null;
            try {
                FutureTarget<File> future = Glide
                        .with(ShowMeiziActivity.this)
                        .load(mUrl)
                        .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);

                file = future.get();

                if (!appDir.exists()) {
                    appDir.mkdirs();
                }
                String fileName = mId + ".jpg";
                File destFile = new File(appDir, fileName);

                FileUtil.CopyFile(file, destFile);

                // 最后通知图库更新
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        Uri.fromFile(new File(destFile.getPath()))));
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
            return file;
        }

        @Override
        protected void onPostExecute(File file) {
            if (file == null) {
                Toast.makeText(ShowMeiziActivity.this, mId + ".jpg 已存在本地", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ShowMeiziActivity.this, "图片保存成功 " + file.getPath(), Toast.LENGTH_SHORT).show();
            }
            cancel(true);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

    ;
}
