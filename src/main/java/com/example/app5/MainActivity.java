package com.example.app5;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.time.chrono.MinguoEra;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv_bitmap = findViewById(R.id.iv_bitmap);

//        getTest();
//        getTest2();
//        getTest3();
//        postTest();
//        getTest4();
//        getTest5();
//        getTest6();
//        getTest7();
//        getTest8();
//        getTest9();

//        getTest10();

        getTest11();
    }

    private void getTest11() {

        //这表示的是文字
        RequestBody name = RequestBody.create(MediaType.parse("text/plain;charset=UTF-8"), "嗯嗯嗯");
        RequestBody age = RequestBody.create(MediaType.parse("text/plain;charset=UTF-8"), "12");
        Map<String, RequestBody> args = new HashMap<>();
        args.put("name",name);
        args.put("age",age);


        File file = new File(Environment.getExternalStorageDirectory() + "/" + "aaaaa.jpeg");
        String mimeType = getMimeType(file);
        Log.e("TAG", "mineType=="+mimeType);
        RequestBody fileRequestBody = RequestBody.create(MediaType.parse(mimeType), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), fileRequestBody);

        Call<ResponseBody> responseBodyCall = Retrofit2Util.getApi().upload_1(args, filePart);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("TAG", "response=="+response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public static String getMimeType(final File file) {
        String extension = getExtension(file);
        if(extension.equals("m4a")) {
            return "audio/x-m4a";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
    }
    public static String getExtension(final File file) {
        String suffix = "";
        String name = file.getName();
        final int idx = name.lastIndexOf(".");
        if (idx > 0) {
            suffix = name.substring(idx + 1);
        }
        return suffix;
    }

    /**
     *
     *  ============Descript   附件
     *   ============PartNumber   0
     *  ============FileName   JPEG_20181016_1838022210.jpg
     *  ============Title   图片
     * ============MIMEType   image/jpeg
     * ============SerialKey   07492e9c-8212-4f62-afab-57e4eb6468d9
     * ============StartIndex   0
     * ============FileLength   265763
     * ============PartStartIndex   0
     *============FileUrl
     */

    private void getTest10() {


        File file = new File(Environment.getExternalStorageDirectory() + "/" + "aaaaa.jpeg");

        HashMap<String, RequestBody> params = new HashMap<String, RequestBody>();
        Log.e("TAG", "==="+UUID.randomUUID().toString());
        params = addParameter(params, "SerialKey", UUID.randomUUID().toString());
        params = addParameter(params, "FileName", "JPEG_20181016_1838022210.jpg");
        params = addParameter(params, "Title", "图片");
        params = addParameter(params, "FileUrl", "");
        params = addParameter(params, "Descript", "附件");
        params = addParameter(params, "MIMEType", "image/jpeg");
        params = addParameter(params, "PartNumber", "0");
        params = addParameter(params, "StartIndex", "0");
        params = addParameter(params, "PartStartIndex", "0");
        params = addParameter(params, "FileLength", "265763");
        params = addParameter(params, "PartLength", "265763");
        params = addParameter(params, "eee", file);




        Call<ResponseBody> call = Retrofit2Util.getApi().upload_2(params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("TAG", "===" + response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    public HashMap<String, RequestBody> addParameter(HashMap<String, RequestBody> params, String key, Object o) {

        if (o instanceof String) {
            RequestBody body = RequestBody.create(MediaType.parse("text/plain;charset=UTF-8"), (String) o);
            params.put(key, body);
        } else if (o instanceof File) {
            RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), (File) o);
            params.put(key + "\"; filename=\"" + ((File) o).getName() + "", body);
        }
        return params;
    }

    private void getTest9() {

        HashMap<String, String> map = new HashMap<>();
        map.put("CreatedBy", "cyf_1");
        map.put("Company", "10570bed-54ff-11e5-8ec1-64006a4cb35a");
        map.put("TaskStartTime", "2018-10-16 14:05:54");
        map.put("TaskCode", "201810161406237070");
        map.put("TaskStatus", "1");
        map.put("TaskEndTime", "2018-10-17 14:05:00");
        map.put("TaskName", "hggg");
        map.put("TaskID", "b3c1af81-4e5e-445e-b4ac-994612c2b790");
        map.put("ReleaseSerialKey", "240910ac-78f8-4617-95a3-012d55e5291f");
        map.put("TaskDescript", "ghh");
        map.put("RegionID", "db3d0c97-91e7-4135-99aa-e468a8ef4f3e");

        Call<ResponseBody> cyf_1 = Retrofit2Util.getApi().postNews5(map);
        cyf_1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("TAG", "====" + response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getTest8() {
        Call<News> cyf_1 = Retrofit2Util.getApi().getNews4("4", "cyf_1");
        Call<News> cyf_2 = Retrofit2Util.getApi().getNews4("4", "cyf_1");
        cyf_1.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.e("TAG", "news===" + response.body().getDataSource().getTables().get(0).toString());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
        cyf_2.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }

    @SuppressLint("CheckResult")
    private void getTest7() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                }
                int delayTime = (int) (1 + Math.random() * 10);
                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.e("TAG", "flatMap : accept : " + s + "\n");
                    }
                });

    }

    @SuppressLint("CheckResult")
    private void getTest6() {
        final Observable<News> cyf_1 = Retrofit2Util.getApi().getNews4("00-00-00", "4", "cyf_1");
        Observable<News> cyf_2 = Retrofit2Util.getApi().getNews4("00-00-00", "1", "cyf_1");
        Observable<News> cyf_3 = Retrofit2Util.getApi().getNews4("00-00-00", "3", "cyf_1");
        //使用concat进行连续调用
//        Observable.concat(cyf_1, cyf_2, cyf_3)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<News>() {
//                    @Override
//                    public void accept(News news) throws Exception {
//                        Log.e("TAG", "news=====" + news.getDataSource().getTables().get(0).toString());
//                    }
//                });


//        进行连续的调用
        Flowable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        if (aLong == 1) {

                        }
                        cyf_1.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<News>() {
                                    @Override
                                    public void accept(News news) throws Exception {
                                        Log.e("TAG", "news=====" + news.getDataSource().getTables().get(0).toString());
                                    }
                                });

                    }
                });
    }


    //    在这里进行链式调用
    @SuppressLint("CheckResult")
    private void getTest5() {
        Observable<News> cyf_1 = Retrofit2Util.getApi().getNews4("00-00-00", "4", "cyf_1");
        cyf_1.subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
//                在这里处理第一个接口调用后的结果
                .doOnNext(new Consumer<News>() {
                    @Override
                    public void accept(News news) throws Exception {
                        Log.e("TAG", "第一个接口调用成功news===" + news.getDataSource().getTables().get(0).toString());
                    }
                })
//                调用完毕后，使用flatMap()方法进行调用下一个接口
                .flatMap(new Function<News, Observable<ResponseBody>>() {
                    @Override
                    public Observable<ResponseBody> apply(News news) throws Exception {
                        Log.e("TAG", "第一个接口调用成功,开始调用第二个接口");
                        return Retrofit2Util.getApi().retrofitDownloadFile1("http://img7.ph.126.net/csEStb0_mEOfFeJek8qqsg==/6597237991937396867.jpg");
                    }
                })
                //进行处理返回的数据流，然后转化成Bitmap对象。
                .map(new Function<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap apply(ResponseBody responseBody) throws Exception {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File file = new File(externalStorageDirectory.getAbsolutePath() + File.separator + "aaaaa.jpeg");
                        boolean b = DownLoadManager.writeResponseBodyToDisk(file, responseBody);
                        Bitmap bitmap = BitmapFactory.decodeFile(externalStorageDirectory.getAbsolutePath() + File.separator + "aaaaa.jpeg");
                        return bitmap;
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap bitmap) throws Exception {
                        Log.e("TAG", "第2个接口调用成功");
                        iv_bitmap.setImageBitmap(bitmap);
                    }
                });

    }


    @SuppressLint("CheckResult")
    private void getTest4() {

//       rxjava  2.0增加了背压，也就是被观察者的发送速度快于观察者的处理的速度。
        Log.e("TAG", "news===");
        Observable<News> cyf_1 = Retrofit2Util.getApi().getNews4("00-00-00", "4", "cyf_1");

        cyf_1.subscribeOn(Schedulers.newThread()) //在分线程中订阅
                .observeOn(AndroidSchedulers.mainThread()) //在主线程中观察
                .subscribe(new Consumer<News>() {
                    @Override
                    public void accept(News news) throws Exception {
                        Log.e("TAG", "news111===" + news.toString() + Thread.currentThread().getName());
                    }
                });


        Observable<ResponseBody> responseBodyObservable = Retrofit2Util.getApi().retrofitDownloadFile1("http://img7.ph.126.net/csEStb0_mEOfFeJek8qqsg==/6597237991937396867.jpg");

        responseBodyObservable.subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .map(new Function<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap apply(ResponseBody response) throws Exception {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File file = new File(externalStorageDirectory.getAbsolutePath() + File.separator + "aaaaa.jpeg");
                        boolean b = DownLoadManager.writeResponseBodyToDisk(file, response);
                        Bitmap bitmap = BitmapFactory.decodeFile(externalStorageDirectory.getAbsolutePath() + File.separator + "aaaaa.jpeg");
                        return bitmap;
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap bitmap) throws Exception {
                        iv_bitmap.setImageBitmap(bitmap);
                    }
                });


    }

    private void getTest3() {

        Call<ResponseBody> responseBodyCall = Retrofit2Util.getApi().retrofitDownloadFile("http://img7.ph.126.net/csEStb0_mEOfFeJek8qqsg==/6597237991937396867.jpg");

        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {

                Log.e("TAG", "response.body()==" + response.body());
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = null;
                try {
                    Log.e("TAG", "externalStorageDirectory.getCanonicalPath()==" + externalStorageDirectory.getCanonicalPath());
                    file = new File(externalStorageDirectory.getAbsolutePath() + File.separator + "aaaaa.jpeg");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                final File finalFile = file;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                       这个应该在分线程中进行调用
                        DownLoadManager.writeResponseBodyToDisk(finalFile, response.body());
                        Log.e("TAG", "下载成功");
                    }
                }).start();


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    private void getTest2() {

        Call<ResponseBody> cyf_1 = Retrofit2Util.getApi().getNews("00-00-00", "4", "cyf_1");
        Call<News.DataSourceBean.TablesBean.DatasBean> cyf_11 = Retrofit2Util.getApi().getNews3("00-00-00", "4", "cyf_1");


        cyf_1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("TAG", "response===" + response.toString());
                Log.e("TAG", "response.body()===" + response.body().toString());
                Log.e("TAG", "response.code()===" + response.code());
                Log.e("TAG", "response.message()===" + response.message());
                Log.e("TAG", "response.raw()===" + response.raw());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });

        cyf_11.enqueue(new Callback<News.DataSourceBean.TablesBean.DatasBean>() {
            @Override
            public void onResponse(Call<News.DataSourceBean.TablesBean.DatasBean> call, Response<News.DataSourceBean.TablesBean.DatasBean> response) {
                Log.e("TAG", "response2===" + response.toString());
                Log.e("TAG", "response2.body()===" + response.body().toString());
                Log.e("TAG", "response2.code()===" + response.code());
                Log.e("TAG", "response2.message()===" + response.message());
                Log.e("TAG", "response2.raw()===" + response.raw());
            }

            @Override
            public void onFailure(Call<News.DataSourceBean.TablesBean.DatasBean> call, Throwable t) {

            }
        });
    }

    private void postTest() {

//        当前的接口，在设置上不能用post代替get
        HashMap<String, String> map = new HashMap<>();
        map.put("dataKey", "00-00-00");
        map.put("Status", "4");
        map.put("UserID", "cyf_1");
        Call<News> newsCall = Retrofit2Util.getApi().postNews1(map);
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
//                Log.e("TAG", "====" + response.body().getDataSource().getTables().get(0).getDatas().get(0).toString());

                Log.e("TAG", "response===" + response.toString());
//                Log.e("TAG", "response.body()===" + response.body().toString());
                Log.e("TAG", "response.code()===" + response.code());
                Log.e("TAG", "response.message()===" + response.message());
                Log.e("TAG", "response.raw()===" + response.raw());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }

    private void getTest() {
        Call<ResponseBody> cyf_1 = Retrofit2Util.getApi().getNews("00-00-00", "4", "cyf_1");
        Call<News> cyf_11 = Retrofit2Util.getApi().getNews2("00-00-00", "4", "cyf_1");

        cyf_1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.e("TAG", "response==" + response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });

        try {
            cyf_11.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {
//                    Log.e("TAG", "response===" + response.toString());
//                    Log.e("TAG", "response.body()===" + response.body().toString());
//                    Log.e("TAG", "response.code()===" + response.code());
//                    Log.e("TAG", "response.message()===" + response.message());
//                    Log.e("TAG", "response.raw()===" + response.raw());
                    for (int i = 0; i < response.body().getDataSource().getTables().size(); i++) {

                        for (int i1 = 0; i1 < response.body().getDataSource().getTables().get(i).getDatas().size(); i1++) {
//                            Log.e("TAG", "Datas===" + response.body().getDataSource().getTables().get(i).getDatas().get(i1).toString());
                        }
                    }
                }

                @Override
                public void onFailure(Call<News> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
//            Log.e("TAG", "===2===" + cyf_1.request().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
