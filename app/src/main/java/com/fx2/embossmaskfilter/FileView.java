package com.fx2.embossmaskfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by chenshuo on 2018/4/23.
 */

public class FileView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;

    public FileView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.DITHER_FLAG);
        mPaint.setColor(Color.BLUE);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy2);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
      /*  *//***
         * 花圖片
         *
         *//*

        canvas.drawBitmap(mBitmap,0,0,mPaint);
        mPaint.reset();
        canvas.save();

        *//***
         *
         *話矩形區域
         *
         *//*

        mPaint.setColor(Color.RED);


        RectF rectF =  new RectF(mBitmap.getWidth(),0,2*mBitmap.getWidth(),mBitmap.getHeight());
        canvas.drawBitmap(mBitmap,null,rectF,mPaint);
        mPaint.reset();


        *//**
         * 画filter   cardView 效果
         *
         * *//*

        mPaint.setColor(Color.YELLOW);

        mPaint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL));

        //canvas.drawRect(0,mBitmap.getHeight()+20,mBitmap.getWidth(),mBitmap.getHeight()*2,mPaint);


        canvas.drawBitmap(mBitmap,0,mBitmap.getHeight()+20,mPaint);



        *//**
         *
         * 浮雕效果
         * 设置浮雕效果
         * *//*



        mPaint.reset();

        mPaint.setColor(Color.GRAY);



        float []direction = new float[]{10, 10, 10};
        float ambient = 0.1f;
        float specular = 1;
        float blurRadius = 20;
        EmbossMaskFilter filter = new EmbossMaskFilter(direction, ambient, specular, blurRadius);
        mPaint.setMaskFilter(filter);

        canvas.drawBitmap(mBitmap,20+mBitmap.getWidth(),mBitmap.getHeight()+20,mPaint);
*/


         /**
          *
          * 设置滤镜  1
          * */

          /* ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1, 0,0,0,0,
                0,1,0,0,100,
                0,0,1,0,0,
                0,0,0,1,0,
           });


           mPaint.setColor(Color.GRAY);
           mPaint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));
          canvas.drawBitmap(mBitmap,0,0,mPaint);*/


        /**
         *
         * 设置滤镜  2
         * */

        /* //反相效果 -- 底片效果  照片底板
         ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                -1, 0,0,0,255,
                0,-1,0,0,255,
                0,0,-1,0,255,
                0,0,0,1,0,
        });



        mPaint.setColor(Color.GRAY);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));
        canvas.drawBitmap(mBitmap,0,0,mPaint);*/





        /**
         *
         * 设置滤镜  3  去色效果(黑白照片)
         * */

        // 黑白照片
        // 去色原理：只要把R G B 三通道的色彩信息设置成一样，那么图像就会变成灰色，
        // 同时为了保证图像亮度不变，同一个通道里的R+G+B =1
        //
      /*  ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                0.213f, 0.715f,0.072f,0,0,
                0.213f, 0.715f,0.072f,0,0,
                0.213f, 0.715f,0.072f,0,0,
                0,0,0,1,0,
        });
        mPaint.setColor(Color.GRAY);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));
        canvas.drawBitmap(mBitmap,0,0,mPaint);*/








        /**
         *
         * 设置滤镜  4  发色效果  颜色更加鲜明
         * */


      /*  ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                0,1,0,0,0,
                1, 0,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0,
        });

        mPaint.setColor(Color.GRAY);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));
        canvas.drawBitmap(mBitmap,0,0,mPaint);*/





        /**
         *
         * 设置滤镜  5  复古效果
         * */



        /*ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1/2f,1/2f,1/2f,0,0,
                1/3f, 1/3f,1/3f,0,0,
                1/4f,1/4f,1/4f,0,0,
                0,0,0,1,0,
        });

        mPaint.setColor(Color.GRAY);

        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMartrix);
        mPaint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(mBitmap,0,0,mPaint);*/





        /**
         *
         * 过滤
         * */


    ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1, 0,0,0,0,
                0,0,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0,
        });

        mPaint.setColor(Color.YELLOW);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));

        canvas.drawBitmap(mBitmap,0,0,mPaint);

























    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
